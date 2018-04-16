package com.hsl.clgl.pc.admin.modules.maintenance.car.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 车型表
 * 
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-28 15:14:25
 */
@TableName("tb_car_type")
public class CarTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 所属品牌id
	 */
	@TableField(exist=false)
	private String brandId;

	/**
	 * 所属品牌名称
	 */
	@TableField(exist=false)
	private String brandName;
	/**
	 * 所属车系名称
	 */
	@TableField(exist=false)
	private String trainName;
	/**
	 * 车型名称
	 */
	private String typeName;
	/**
	 * 车型编号
	 */
	private String typeNo;
	/**
	 * 所属车系id
	 */
	private String trainId;
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
	 * 设置：车型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：车型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：车型编号
	 */
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}
	/**
	 * 获取：车型编号
	 */
	public String getTypeNo() {
		return typeNo;
	}
	/**
	 * 设置：所属车系id
	 */
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	/**
	 * 获取：所属车系id
	 */
	public String getTrainId() {
		return trainId;
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
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
}
