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

/**
 * <积分体系用户表实体类>
 *
 * @author listlessp
 * @create 2020-11-19 13:51:29
 */
public class PointsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @ApiModelProperty(value = "商户ID", hidden = true)
    private Long merchantId;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "头像url")
    private String avatarUrl;
    @ApiModelProperty(value = "对方用户编号(开平微信ID)")
    private String userCode; // TODO:相同的openId不同的userCode会有问题
    @ApiModelProperty(value = "微信open_id")
    private String openId;
    @ApiModelProperty(value = "微信union_id")
    private String unionId;
    @ApiModelProperty(value = "最后一次渠道编码")
    private String lastChannelCode;
    @ApiModelProperty(value = "最后一次所选渠道分组id")
    private Long lastChannelGroupId;
    @ApiModelProperty(value = "用户分类(1:群内用户, 2:小程序用户)")
    private Integer userType;
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updatedTime;
    @ApiModelProperty(value = "是否发货(1:发货, 2:不发货)")
    private Integer deliverySymbol;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getLastChannelCode() {
        return lastChannelCode;
    }

    public void setLastChannelCode(String lastChannelCode) {
        this.lastChannelCode = lastChannelCode;
    }

    public Long getLastChannelGroupId() {
        return lastChannelGroupId;
    }

    public void setLastChannelGroupId(Long lastChannelGroupId) {
        this.lastChannelGroupId = lastChannelGroupId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getDeliverySymbol() {
        return deliverySymbol;
    }

    public void setDeliverySymbol(Integer deliverySymbol) {
        this.deliverySymbol = deliverySymbol;
    }
}
