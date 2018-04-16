package com.hsl.clgl.sh.pc.admin.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 部门表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-03 10:15:08
 */
@TableName("sh_dept")
public class ShDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type=IdType.INPUT)
	private String deptId;
	/**
	 * 所属商户id
	 */
	private String shId;
	/**
	 * 上级部门ID，一级部门为0
	 */
	private String parentId;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 部门层级（1-最高层级）
	 */
	private Integer level;

	//上级部门名称
	@TableField(exist=false)
	private String parentName;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 是否删除  0：已删除  1：正常 2:禁用
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


	@TableField(exist=false)
	private List<ShDeptEntity> children;

	/**
	 * 设置：
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：所属商户id
	 */
	public void setShId(String shId) {
		this.shId = shId;
	}
	/**
	 * 获取：所属商户id
	 */
	public String getShId() {
		return shId;
	}
	/**
	 * 设置：上级部门ID，一级部门为0
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：部门层级（1-最高层级）
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：部门层级（1-最高层级）
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：是否删除  0：已删除  1：正常 2:禁用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否删除  0：已删除  1：正常 2:禁用
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

	public List<ShDeptEntity> getChildren() {
		return children;
	}

	public void setChildren(List<ShDeptEntity> children) {
		this.children = children;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
