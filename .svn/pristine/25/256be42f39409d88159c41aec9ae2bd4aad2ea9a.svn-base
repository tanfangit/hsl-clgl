package com.hsl.clgl.pc.admin.modules.maintenance.repair.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修类别表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-28 18:28:55
 */
@TableName("tb_repair_type")
public class RepairTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 维修类别id
	 */
	@TableId(type=IdType.INPUT)
	private String repairTypeId;
	/**
	 * 维修类别编号
	 */
	private String repairTypeNo;
	/**
	 * 维修类别名称
	 */
	private String repairTypeName;
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 更新时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 更新人
	 */
	private String updateUser;

	/**
	 * 设置：维修类别id
	 */
	public void setRepairTypeId(String repairTypeId) {
		this.repairTypeId = repairTypeId;
	}
	/**
	 * 获取：维修类别id
	 */
	public String getRepairTypeId() {
		return repairTypeId;
	}
	/**
	 * 设置：维修类别编号
	 */
	public void setRepairTypeNo(String repairTypeNo) {
		this.repairTypeNo = repairTypeNo;
	}
	/**
	 * 获取：维修类别编号
	 */
	public String getRepairTypeNo() {
		return repairTypeNo;
	}
	/**
	 * 设置：维修类别名称
	 */
	public void setRepairTypeName(String repairTypeName) {
		this.repairTypeName = repairTypeName;
	}
	/**
	 * 获取：维修类别名称
	 */
	public String getRepairTypeName() {
		return repairTypeName;
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
