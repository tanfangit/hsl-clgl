package com.hsl.clgl.pc.admin.modules.trailer.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 拖车表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-30 16:05:07
 */
@TableName("tb_trailer")
public class TrailerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 拖车id
	 */
	@TableId(type=IdType.INPUT)
	private String trailerId;
	/**
	 * 车牌号
	 */
	private String trailerCarNo;
	/**
	 * 所属公司id
	 */
	private String trailerCompanyId;
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
	 * 公司名称
	 */
	@TableField(exist = false)
	private  String companyName;

	public String getCompanyName(){ return companyName; }

	public void setCompanyName(String companyName){ this.companyName = companyName; }
	/**
	 * 设置：拖车id
	 */
	public void setTrailerId(String trailerId) {
		this.trailerId = trailerId;
	}
	/**
	 * 获取：拖车id
	 */
	public String getTrailerId() {
		return trailerId;
	}
	/**
	 * 设置：车牌号
	 */
	public void setTrailerCarNo(String trailerCarNo) {
		this.trailerCarNo = trailerCarNo;
	}
	/**
	 * 获取：车牌号
	 */
	public String getTrailerCarNo() {
		return trailerCarNo;
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
