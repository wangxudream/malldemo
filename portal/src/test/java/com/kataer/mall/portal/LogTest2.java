package com.kataer.mall.portal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kataer.mall.portal.log.InvitationPointsLog;
import com.kataer.mall.portal.log.InvitationPointsLogMapper;
import com.kataer.mall.portal.log.Node;
import com.kataer.mall.portal.log.PointsUserMapper;
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
public class LogTest2 {
    @Autowired
    private InvitationPointsLogMapper logMapper;

    @Autowired
    private PointsUserMapper pointsUserMapper;

    @Test
    public void test() {
        String userId = "B";
        List<InvitationPointsLog> logs = logMapper.selectList(new LambdaQueryWrapper<InvitationPointsLog>()
                .eq(InvitationPointsLog::getChannelCode, "123456")
                .eq(InvitationPointsLog::getChannelGroupId, "1367000302968365057")
                .eq(InvitationPointsLog::getDelFlag, 0));
        //数据去重
        HashSet<InvitationPointsLog> logsSet = new HashSet<>();
        logsSet.addAll(logs);

        //创建遍历的map 邀请人ID value 邀请记录
        HashMap<String, List<InvitationPointsLog>> map1 = new HashMap<>();//key邀请人
        HashMap<String, InvitationPointsLog> map2 = new HashMap<>();//key被邀请人
        for (InvitationPointsLog pointsLog : logsSet) {
            if (!map1.containsKey(pointsLog.getInvitationUserId())) {
                ArrayList<InvitationPointsLog> list1 = new ArrayList<>();
                list1.add(pointsLog);
                map1.put(pointsLog.getInvitationUserId(), list1);
            } else {
                map1.get(pointsLog.getInvitationUserId()).add(pointsLog);
            }

            if (!map2.containsKey(pointsLog.getUserId())) {
                map2.put(pointsLog.getUserId(), pointsLog);
            }
        }

        HashSet<InvitationPointsLog> superLogs = new HashSet<>();
        InvitationPointsLog superLog = null;
        while (map2.get(userId) != null) {
            InvitationPointsLog log = map2.get(userId);
            if (superLogs.contains(log)) {
                break;
            }
            superLogs.add(superLog);
            if (superLog == null) {
                userId = log.getUserId();
                superLog = log;
            } else if (log.getCreatedTime().before(superLog.getCreatedTime())) {
                superLog = log;
            }
        }

        Node node = new Node();
        if (superLog != null) {
            node.setUserId(superLog.getInvitationUserId());
        } else {
            node.setUserId("B");
        }

        HashSet<InvitationPointsLog> usedLog = new HashSet<>();
//        usedLog.add(superLog);
        appendSub(node, map1, usedLog);
        System.out.println(node);
    }

    public Node appendSub(Node node, HashMap<String, List<InvitationPointsLog>> map, HashSet<InvitationPointsLog> usedLog) {
        if (node != null) {
            List<InvitationPointsLog> subLogs = map.get(node.getUserId());
            if (subLogs != null) {
                int subNums = subLogs.size();
                int leftSubNums = 0;
                List<Node> subNodes = new ArrayList<>();
                for (InvitationPointsLog subLog : subLogs) {
                    if (!usedLog.contains(subLog)) {
                        usedLog.add(subLog);
                        if (subLog.getType() == 1) {
                            leftSubNums++;
                        }
                        Node subNode = new Node();
                        subNode.setUserId(subLog.getUserId());
                        subNode.setName(subLog.getUserName());
                        subNodes.add(subNode);
                        appendSub(subNode, map, usedLog);
                    }
                }
                node.setSubs(subNodes);
                node.setSubNums(subNums);
                node.setLeftSubNums(leftSubNums);
            }
        }
        return node;
    }
}
