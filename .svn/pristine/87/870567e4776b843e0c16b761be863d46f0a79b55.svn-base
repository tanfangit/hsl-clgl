package com.hsl.clgl.sh.pc.admin.modules.rescuelog.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 救援单日志表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-09 11:22:05
 */
@TableName("sh_rescue_log")
public class ShRescueLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 日志id
	 */
	@TableId(type=IdType.INPUT)
	private String rescueLogId;
	/**
	 * JY开头时间戳加6位随机数JY20180409091000123456
	 */
	private String rescueId;
	/**
	 * 救援单状态:0：取消订单、1：已提交、2：已派单、3：已接单、4:救援中、5:已完成、6:已评价
	 */
	private Integer rescueStatus;
	/**
	 * 救援单日志记录描述
	 */
	private String logRemark;
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
	 * 设置：日志id
	 */
	public void setRescueLogId(String rescueLogId) {
		this.rescueLogId = rescueLogId;
	}
	/**
	 * 获取：日志id
	 */
	public String getRescueLogId() {
		return rescueLogId;
	}
	/**
	 * 设置：JY开头时间戳加6位随机数JY20180409091000123456
	 */
	public void setRescueId(String rescueId) {
		this.rescueId = rescueId;
	}
	/**
	 * 获取：JY开头时间戳加6位随机数JY20180409091000123456
	 */
	public String getRescueId() {
		return rescueId;
	}
	/**
	 * 设置：救援单状态:0：取消订单、1：已提交、2：已派单、3：已接单、4:救援中、5:已完成、6:已评价
	 */
	public void setRescueStatus(Integer rescueStatus) {
		this.rescueStatus = rescueStatus;
	}
	/**
	 * 获取：救援单状态:0：取消订单、1：已提交、2：已派单、3：已接单、4:救援中、5:已完成、6:已评价
	 */
	public Integer getRescueStatus() {
		return rescueStatus;
	}
	/**
	 * 设置：救援单日志记录描述
	 */
	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
	}
	/**
	 * 获取：救援单日志记录描述
	 */
	public String getLogRemark() {
		return logRemark;
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
}
