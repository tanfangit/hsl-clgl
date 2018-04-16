package com.hsl.clgl.pc.admin.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-22 14:35:04
 */
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId(type = IdType.INPUT)
	private String userId;
	/**
	 * 用户工号
	 */
	private Long userNo;
	/**
	 * 用户真实姓名
	 */
	private String name;
	/**
	 * 登录名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 部门
	 */
	private String dept;

	/**
	 * 部门名称
	 */
	@TableField(exist=false)
	private String deptName;
	/**
	 * 手机号
	 */
	private String mobile;
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
	 * 工作年限
	 */
	private Integer workYear;
	/**
	 * 职位
	 */
	private String userPosition;

	/**
	 * 角色ID列表
	 */
	@TableField(exist=false)
	private List<String> roleIdList;


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：用户工号
	 */
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	/**
	 * 获取：用户工号
	 */
	public Long getUserNo() {
		return userNo;
	}
	/**
	 * 设置：用户真实姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：用户真实姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：登录名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：登录名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
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
	/**
	 * 设置：工作年限
	 */
	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}
	/**
	 * 获取：工作年限
	 */
	public Integer getWorkYear() {
		return workYear;
	}
	/**
	 * 设置：职位
	 */
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	/**
	 * 获取：职位
	 */
	public String getUserPosition() {
		return userPosition;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<String> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}
}
