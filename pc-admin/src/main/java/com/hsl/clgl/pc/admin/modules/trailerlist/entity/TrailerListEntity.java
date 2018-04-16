package com.hsl.clgl.pc.admin.modules.trailerlist.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 拖车单表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:22:14
 */
@TableName("tb_trailer_list")
public class TrailerListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 拖车单id
	 */
	@TableId(type=IdType.INPUT)
	private String trailerListId;
	/**
	 * 拖车车牌号
	 */
	private String trailerCarNo;
	/**
	 * 驾驶员id
	 */
	private String trailerDriverId;
	/**
	 * 所属公司id
	 */
	private String trailerCompanyId;
	/**
	 * 对应救援单or事故单号
	 */
	private String rescueOrCaseId;
	/**
	 * 拖车单状态0:已派车 1:完成
	 */
	private Integer trailerListStatus;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
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
	 * 司机姓名
	 */
	@TableField(exist = false)
	private String driverName;

	public String getDriverName() { return driverName; }

	public void setDriverName(String driverName) { this.driverName = driverName; }
	/**
	 * 司机手机号
	 */
	@TableField(exist = false)
	private String driverMobile;

	public String getDriverMobile() { return driverMobile; }

	public void setDriverMobile(String driverMobile){ this.driverMobile = driverMobile; }
	/**
	 * 公司名称
	 */
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() { return companyName; }

	public void setCompanyName(String companyName) { this.companyName = companyName; }
	/**
	 * 拖车单类型
	 */
	private String trailerListType;

	public String getTrailerListType(){ return trailerListType; }

	public void setTrailerListType(String trailerListType){ this.trailerListType = trailerListType; }
	/**
	 * 设置：拖车单id
	 */
	public void setTrailerListId(String trailerListId) {
		this.trailerListId = trailerListId;
	}
	/**
	 * 获取：拖车单id
	 */
	public String getTrailerListId() {
		return trailerListId;
	}
	/**
	 * 设置：拖车车牌号
	 */
	public void setTrailerCarNo(String trailerCarNo) {
		this.trailerCarNo = trailerCarNo;
	}
	/**
	 * 获取：拖车车牌号
	 */
	public String getTrailerCarNo() {
		return trailerCarNo;
	}
	/**
	 * 设置：驾驶员id
	 */
	public void setTrailerDriverId(String trailerDriverId) {
		this.trailerDriverId = trailerDriverId;
	}
	/**
	 * 获取：驾驶员id
	 */
	public String getTrailerDriverId() {
		return trailerDriverId;
	}
	/**
	 * 设置：所属公司id
	 */
	public void setTrailerCompanyId(String trailerCompanyId) {
		this.trailerCompanyId = trailerCompanyId;
	}
	/**
	 * 获取：所属公司id
	 */
	public String getTrailerCompanyId() {
		return trailerCompanyId;
	}
	/**
	 * 设置：对应救援单or事故单号
	 */
	public void setRescueOrCaseId(String rescueOrCaseId) {
		this.rescueOrCaseId = rescueOrCaseId;
	}
	/**
	 * 获取：对应救援单or事故单号
	 */
	public String getRescueOrCaseId() {
		return rescueOrCaseId;
	}
	/**
	 * 设置：拖车单状态0:已派车 1:完成
	 */
	public void setTrailerListStatus(Integer trailerListStatus) {
		this.trailerListStatus = trailerListStatus;
	}
	/**
	 * 获取：拖车单状态0:已派车 1:完成
	 */
	public Integer getTrailerListStatus() {
		return trailerListStatus;
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
