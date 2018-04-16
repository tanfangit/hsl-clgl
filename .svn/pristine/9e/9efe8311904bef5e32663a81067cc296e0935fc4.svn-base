package com.hsl.clgl.app.cz.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆品牌表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 13:49:21
 */
@TableName("tb_car_brand")
public class CarBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type=IdType.INPUT)
	private String brandId;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 品牌编号
	 */
	private String brandNo;
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
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 更新时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date updateTime;
	/**
	 * 更新人
	 */
	private String updateUser;

	/**
	 * 设置：主键id
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：主键id
	 */
	public String getBrandId() {
		return brandId;
	}
	/**
	 * 设置：品牌名称
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取：品牌名称
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 设置：品牌编号
	 */
	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}
	/**
	 * 获取：品牌编号
	 */
	public String getBrandNo() {
		return brandNo;
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
