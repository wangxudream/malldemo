package com.kataer.mall.portal;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kataer.mall.portal.log.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class LogTest {
    @Autowired
    private InvitationPointsLogMapper logMapper;

    @Autowired
    private PointsUserMapper pointsUserMapper;

    @Test
    public void test() {
        //查询数据
        List<InvitationPointsLog> logs = logMapper.selectList(new LambdaQueryWrapper<InvitationPointsLog>()
                .eq(InvitationPointsLog::getChannelCode, "F916F691CB30E037742079A30283DB4E")
                .eq(InvitationPointsLog::getChannelGroupId, "1367000302968365057")
                .eq(InvitationPointsLog::getDelFlag, 0));
        //数据去重
        HashSet<InvitationPointsLog> logsSet = new HashSet<>();
        logsSet.addAll(logs);
        //去除多余的邀请记录
        HashMap<String, InvitationPointsLog> countMap = new HashMap<>();
        Iterator<InvitationPointsLog> iterator = logsSet.iterator();
        while (iterator.hasNext()) {
            InvitationPointsLog log = iterator.next();
            InvitationPointsLog value = countMap.get(log.getUserId());
            if (value == null) {
                countMap.put(log.getUserId(), log);
            } else {
                //去除时间晚的邀请记录
                if (log.getCreatedTime().after(value.getCreatedTime())) {
                    iterator.remove();
                } else {
                    countMap.put(log.getUserId(), log);
                }
            }
        }
        //确定根用户
        HashSet<String> userIdsSet = new HashSet<>();//被邀请的人的Id
        for (InvitationPointsLog invitationPointsLog : logsSet) {
            userIdsSet.add(invitationPointsLog.getUserId());
        }
        Set<String> roots = new HashSet<>();//根用户，不在被邀请记录里的邀请人
        for (InvitationPointsLog invitationPointsLog : logsSet) {
            if (!userIdsSet.contains(invitationPointsLog.getInvitationUserId())) {
                roots.add(invitationPointsLog.getInvitationUserId());
            }
        }

        if (roots.size() == 0) {
            throw new RuntimeException();
        }


        //创建遍历的map 邀请人ID value 邀请记录
        HashMap<String, List<InvitationPointsLog>> map = new HashMap<>();
        for (InvitationPointsLog pointsLog : logsSet) {
            if (!map.containsKey(pointsLog.getInvitationUserId())) {
                ArrayList<InvitationPointsLog> list = new ArrayList<>();
                list.add(pointsLog);
                map.put(pointsLog.getInvitationUserId(), list);
            } else {
                map.get(pointsLog.getInvitationUserId()).add(pointsLog);
            }
        }

        List<Node> nodeList = new ArrayList<>();
        HashSet<InvitationPointsLog> usedLog = new HashSet<>();
        for (String root : roots) {
            Node rootNode = new Node();
            rootNode.setUserId(root);
            rootNode.setName("机器人");
            Node node = iter(rootNode, map, usedLog);
            PointsUser pointsUser = pointsUserMapper.selectOne(new LambdaQueryWrapper<PointsUser>().eq(PointsUser::getUserCode, root));
            if (pointsUser != null) {
                node.setName(pointsUser.getNickName());
            }
            System.out.println(JSONObject.toJSONString(node));
        }

        System.out.println(usedLog);

        logsSet.removeAll(usedLog);

        //形成环的数据
        System.out.println(logsSet);

        //处理环状数据



    }


    public Node iter(Node node, HashMap<String, List<InvitationPointsLog>> map, HashSet<InvitationPointsLog> usedLog) {
        if (node != null) {
            List<InvitationPointsLog> subLogs = map.get(node.getUserId());
            if (subLogs != null) {
                int subNums = subLogs.size();
                int leftSubNums = 0;
                List<Node> subNodes = new ArrayList<>();
                for (InvitationPointsLog subLog : subLogs) {
                    usedLog.add(subLog);
                    if (subLog.getType() == 1) {
                        leftSubNums++;
                    }
                    Node subNode = new Node();
                    subNode.setUserId(subLog.getUserId());
                    subNode.setName(subLog.getUserName());
                    subNodes.add(subNode);
                    iter(subNode, map, usedLog);
                }
                node.setSubs(subNodes);
                node.setSubNums(subNums);
                node.setLeftSubNums(leftSubNums);
            }
        }
        return node;
    }


}
