package com.hsl.clgl.app.cz.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 车主管理表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 11:05:43
 */
@TableName("tb_cz")
public class CzEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 客户ID
	 */
	@TableId(type=IdType.INPUT)
	private String czId;
	/**
	 * 车主姓名
	 */
	private String czName;
	/**
	 * 车主手机号
	 */
	private String czPhone;

	/**
	 * 驾驶证号码
	 */
	private String driverLicenseNumber;
	/**
	 * 驾驶证发证日期
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date licenseStartDate;
	/**
	 * 驾驶证到期日期
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date licenseEndDate;
	/**
	 * 维修次数
	 */
	private Integer repairNumber;
	/**
	 * 维修金额
	 */
	private Double repairAmount;
	/**
	 * 车主所在地址
	 */
	private String czAddress;
	/**
	 * 状态  0：禁用   1：正常  2：删除
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd")
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
	 * 设置：客户ID
	 */
	public void setCzId(String czId) {
		this.czId = czId;
	}
	/**
	 * 获取：客户ID
	 */
	public String getCzId() {
		return czId;
	}
	/**
	 * 设置：车主姓名
	 */
	public void setCzName(String czName) {
		this.czName = czName;
	}
	/**
	 * 获取：车主姓名
	 */
	public String getCzName() {
		return czName;
	}
	/**
	 * 设置：车主手机号
	 */
	public void setCzPhone(String czPhone) {
		this.czPhone = czPhone;
	}
	/**
	 * 获取：车主手机号
	 */
	public String getCzPhone() {
		return czPhone;
	}

	/**
	 * 设置：驾驶证号码
	 */
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	/**
	 * 获取：驾驶证号码
	 */
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	/**
	 * 设置：驾驶证发证日期
	 */
	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}
	/**
	 * 获取：驾驶证发证日期
	 */
	public Date getLicenseStartDate() {
		return licenseStartDate;
	}
	/**
	 * 设置：驾驶证到期日期
	 */
	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}
	/**
	 * 获取：驾驶证到期日期
	 */
	public Date getLicenseEndDate() {
		return licenseEndDate;
	}
	/**
	 * 设置：维修次数
	 */
	public void setRepairNumber(Integer repairNumber) {
		this.repairNumber = repairNumber;
	}
	/**
	 * 获取：维修次数
	 */
	public Integer getRepairNumber() {
		return repairNumber;
	}
	/**
	 * 设置：维修金额
	 */
	public void setRepairAmount(Double repairAmount) {
		this.repairAmount = repairAmount;
	}
	/**
	 * 获取：维修金额
	 */
	public Double getRepairAmount() {
		return repairAmount;
	}
	/**
	 * 设置：车主所在地址
	 */
	public void setCzAddress(String czAddress) {
		this.czAddress = czAddress;
	}
	/**
	 * 获取：车主所在地址
	 */
	public String getCzAddress() {
		return czAddress;
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
