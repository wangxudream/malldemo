package com.kataer.mall.portal.log;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <邀请积分记录表实体类>
 * 
 * @author listlessp
 * @create 2020-12-10 16:46:22
 */
public class InvitationPointsLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id", example = "1")
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	@ApiModelProperty(value = "被邀请人id", example = "1")
	private String userId;
	@ApiModelProperty(value = "被邀请人昵称", example = "1")
	private String userName;
	@ApiModelProperty(value = "邀请人id", example = "1")
	private String invitationUserId;
	@ApiModelProperty(value = "群组渠道id", example = "1")
	private String channelCode;
	@ApiModelProperty(value = "商家id", example = "1")
	private Long merchantId;
	@ApiModelProperty(value = "渠道分组id", example = "1")
	private Long channelGroupId;
	@ApiModelProperty(value = "0：进群  1：退群", example = "1")
	private Integer type;
	@ApiModelProperty(value = "积分值", example = "1")
	private Integer points;
	@ApiModelProperty(value = "被邀请人积分值", example = "1")
	private Integer pointsInviteesNum;
	@ApiModelProperty(value = "创建时间", example = "1")
	@TableField(fill = FieldFill.INSERT)
	private Date createdTime;
	@ApiModelProperty(value = "0:未删除，1:删除", example = "1")
	private Integer delFlag;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InvitationPointsLog that = (InvitationPointsLog) o;
		return userId.equals(that.userId) &&
				userName.equals(that.userName) &&
				invitationUserId.equals(that.invitationUserId) &&
				channelCode.equals(that.channelCode) &&
				merchantId.equals(that.merchantId) &&
				channelGroupId.equals(that.channelGroupId) &&
				type.equals(that.type) &&
				points.equals(that.points) &&
				pointsInviteesNum.equals(that.pointsInviteesNum) &&
				createdTime.equals(that.createdTime) &&
				delFlag.equals(that.delFlag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, invitationUserId, channelCode, merchantId, channelGroupId, type, points, pointsInviteesNum, createdTime, delFlag);
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInvitationUserId() {
		return invitationUserId;
	}

	public void setInvitationUserId(String invitationUserId) {
		this.invitationUserId = invitationUserId;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getChannelGroupId() {
		return channelGroupId;
	}

	public void setChannelGroupId(Long channelGroupId) {
		this.channelGroupId = channelGroupId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getPointsInviteesNum() {
		return pointsInviteesNum;
	}

	public void setPointsInviteesNum(Integer pointsInviteesNum) {
		this.pointsInviteesNum = pointsInviteesNum;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
}
