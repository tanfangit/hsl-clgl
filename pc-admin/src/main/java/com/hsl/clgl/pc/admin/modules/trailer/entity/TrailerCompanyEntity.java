package com.hsl.clgl.pc.admin.modules.trailer.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 拖车公司表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-03-28 14:41:00
 */
@TableName("tb_trailer_company")
public class TrailerCompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 拖车公司id
	 */
	@TableId(type=IdType.INPUT)
	private String trailerCompanyId;
	/**
	 * 公司名称
	 */
	private String trailerCompanyName;
	/**
	 * 负责人
	 */
	private String trailerCompanyPerson;
	/**
	 * 负责人电话
	 */
	private String trailerCompanyMobile;
	/**
	 * 公司电话
	 */
	private String trailerCompanyPhone;
	/**
	 * 公司地址
	 */
	private String trailerCompanyAddress;
	/**
	 * 公司简介
	 */
	private String trailerCompanyRemark;
	/**
	 * 省级代码
	 */
	private String trailerCompanySjdm;
	/**
	 * 地级代码
	 */
	private String trailerCompanyDjdm;
	/**
	 * 县级代码
	 */
	private String trailerCompanyXjdm;
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
	 * 所属省份名称
	 */
	@TableField(exist=false)
	private String province;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 所属市名称
	 */
	@TableField(exist=false)
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 所属县区份名称
	 */
	@TableField(exist=false)
	private String area;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 设置：拖车公司id
	 */
	public void setTrailerCompanyId(String trailerCompanyId) {
		this.trailerCompanyId = trailerCompanyId;
	}
	/**
	 * 获取：拖车公司id
	 */
	public String getTrailerCompanyId() {
		return trailerCompanyId;
	}
	/**
	 * 设置：公司名称
	 */
	public void setTrailerCompanyName(String trailerCompanyName) {
		this.trailerCompanyName = trailerCompanyName;
	}
	/**
	 * 获取：公司名称
	 */
	public String getTrailerCompanyName() {
		return trailerCompanyName;
	}
	/**
	 * 设置：负责人
	 */
	public void setTrailerCompanyPerson(String trailerCompanyPerson) {
		this.trailerCompanyPerson = trailerCompanyPerson;
	}
	/**
	 * 获取：负责人
	 */
	public String getTrailerCompanyPerson() {
		return trailerCompanyPerson;
	}
	/**
	 * 设置：负责人电话
	 */
	public void setTrailerCompanyMobile(String trailerCompanyMobile) {
		this.trailerCompanyMobile = trailerCompanyMobile;
	}
	/**
	 * 获取：负责人电话
	 */
	public String getTrailerCompanyMobile() {
		return trailerCompanyMobile;
	}
	/**
	 * 设置：公司电话
	 */
	public void setTrailerCompanyPhone(String trailerCompanyPhone) {
		this.trailerCompanyPhone = trailerCompanyPhone;
	}
	/**
	 * 获取：公司电话
	 */
	public String getTrailerCompanyPhone() {
		return trailerCompanyPhone;
	}
	/**
	 * 设置：公司地址
	 */
	public void setTrailerCompanyAddress(String trailerCompanyAddress) {
		this.trailerCompanyAddress = trailerCompanyAddress;
	}
	/**
	 * 获取：公司地址
	 */
	public String getTrailerCompanyAddress() {
		return trailerCompanyAddress;
	}
	/**
	 * 设置：公司简介
	 */
	public void setTrailerCompanyRemark(String trailerCompanyRemark) {
		this.trailerCompanyRemark = trailerCompanyRemark;
	}
	/**
	 * 获取：公司简介
	 */
	public String getTrailerCompanyRemark() {
		return trailerCompanyRemark;
	}
	/**
	 * 设置：省级代码
	 */
	public void setTrailerCompanySjdm(String trailerCompanySjdm) {
		this.trailerCompanySjdm = trailerCompanySjdm;
	}
	/**
	 * 获取：省级代码
	 */
	public String getTrailerCompanySjdm() {
		return trailerCompanySjdm;
	}
	/**
	 * 设置：地级代码
	 */
	public void setTrailerCompanyDjdm(String trailerCompanyDjdm) {
		this.trailerCompanyDjdm = trailerCompanyDjdm;
	}
	/**
	 * 获取：地级代码
	 */
	public String getTrailerCompanyDjdm() {
		return trailerCompanyDjdm;
	}
	/**
	 * 设置：县级代码
	 */
	public void setTrailerCompanyXjdm(String trailerCompanyXjdm) {
		this.trailerCompanyXjdm = trailerCompanyXjdm;
	}
	/**
	 * 获取：县级代码
	 */
	public String getTrailerCompanyXjdm() {
		return trailerCompanyXjdm;
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
