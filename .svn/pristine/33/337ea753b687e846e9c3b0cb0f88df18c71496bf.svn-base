package com.hsl.clgl.pc.admin.modules.trailer.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 拖车驾驶员表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-30 11:46:45
 */
@TableName("tb_trailer_driver")
public class TrailerDriverEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 拖车驾驶员id
	 */
	@TableId(type=IdType.INPUT)
	private String trailerDriverId;
	/**
	 * 驾驶员名称
	 */
	private String trailerDriverName;
	/**
	 * 所属公司id
	 */
	private String trailerCompanyId;

	/**
	 * 所属公司名称
	 */
	@TableField(exist=false)
	private String trailerCompanyName;
	/**
	 * 驾驶员手机号
	 */
	private String trailerDriverMobile;
	/**
	 * 驾驶员状态0:离职 1:在职
	 */
	private Integer trailerDriverStatus;
	/**
	 * 备注
	 */
	private String trailerDriverRemark;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	 * 设置：拖车驾驶员id
	 */
	public void setTrailerDriverId(String trailerDriverId) {
		this.trailerDriverId = trailerDriverId;
	}
	/**
	 * 获取：拖车驾驶员id
	 */
	public String getTrailerDriverId() {
		return trailerDriverId;
	}
	/**
	 * 设置：驾驶员名称
	 */
	public void setTrailerDriverName(String trailerDriverName) {
		this.trailerDriverName = trailerDriverName;
	}
	/**
	 * 获取：驾驶员名称
	 */
	public String getTrailerDriverName() {
		return trailerDriverName;
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
	 * 设置：驾驶员手机号
	 */
	public void setTrailerDriverMobile(String trailerDriverMobile) {
		this.trailerDriverMobile = trailerDriverMobile;
	}
	/**
	 * 获取：驾驶员手机号
	 */
	public String getTrailerDriverMobile() {
		return trailerDriverMobile;
	}
	/**
	 * 设置：驾驶员状态0:离职 1:在职
	 */
	public void setTrailerDriverStatus(Integer trailerDriverStatus) {
		this.trailerDriverStatus = trailerDriverStatus;
	}
	/**
	 * 获取：驾驶员状态0:离职 1:在职
	 */
	public Integer getTrailerDriverStatus() {
		return trailerDriverStatus;
	}
	/**
	 * 设置：备注
	 */
	public void setTrailerDriverRemark(String trailerDriverRemark) {
		this.trailerDriverRemark = trailerDriverRemark;
	}
	/**
	 * 获取：备注
	 */
	public String getTrailerDriverRemark() {
		return trailerDriverRemark;
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


	public String getTrailerCompanyName() {
		return trailerCompanyName;
	}

	public void setTrailerCompanyName(String trailerCompanyName) {
		this.trailerCompanyName = trailerCompanyName;
	}
}
