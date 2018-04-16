package com.hsl.clgl.pc.admin.modules.maintenance.car.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 车系表
 * 
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-27 10:06:21
 */
@TableName("tb_car_train")
public class CarTrainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 车系名称
	 */
	private String trainName;
	/**
	 * 车系编号
	 */
	private String trainNo;
	/**
	 * 所属品牌id
	 */
	private String brandId;
	/**
	 * 所属品牌名称
	 */
	@TableField(exist=false)
	private String brandName;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 状态  0：禁用   1：正常  2：删除
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新人
	 */
	private String updateUser;

	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：车系名称
	 */
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	/**
	 * 获取：车系名称
	 */
	public String getTrainName() {
		return trainName;
	}
	/**
	 * 设置：车系编号
	 */
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	/**
	 * 获取：车系编号
	 */
	public String getTrainNo() {
		return trainNo;
	}
	/**
	 * 设置：所属品牌id
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：所属品牌id
	 */
	public String getBrandId() {
		return brandId;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：状态  0：禁用   1：正常  2：删除
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态  0：禁用   1：正常  2：删除
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
}
