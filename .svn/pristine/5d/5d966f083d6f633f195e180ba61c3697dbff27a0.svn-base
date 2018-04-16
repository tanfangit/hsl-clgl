package com.hsl.clgl.pc.admin.modules.maintenance.repair.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修项目表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 10:02:08
 */
@TableName("tb_repair_item")
public class RepairItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 维修项目id
	 */
	@TableId(type=IdType.INPUT)
	private String repairItemId;
	/**
	 * 维修项目编号
	 */
	private String repairItemNo;
	/**
	 * 维修项目名称
	 */
	private String repairItemName;

	/**
	 * 维修类型id  对应维修类型表id
	 */
	@TableField(exist=false)
	private String repairTypeId;
	/**
	 * 项目所属的维修类型名称
	 */
	@TableField(exist=false)
	private String repairTypeName;
	/**
	 * 维修部位ID  对应字典表id
	 */
	private String repairItemPosition;

	/**
	 * 维修部位名称
	 */
	@TableField(exist=false)
	private String repairItemPositionName;

	/**
	 * 维修工时
	 */
	private String repairWorkHours;
	/**
	 * 工时费
	 */
	private Double workFee;
	/**
	 * 内部工时
	 */
	private String withinHours;
	/**
	 * 拼音码
	 */
	private String pinyinCode;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * 状态  0：禁用   1：正常  2：删除
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
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
	 * 设置：维修项目id
	 */
	public void setRepairItemId(String repairItemId) {
		this.repairItemId = repairItemId;
	}
	/**
	 * 获取：维修项目id
	 */
	public String getRepairItemId() {
		return repairItemId;
	}
	/**
	 * 设置：维修项目编号
	 */
	public void setRepairItemNo(String repairItemNo) {
		this.repairItemNo = repairItemNo;
	}
	/**
	 * 获取：维修项目编号
	 */
	public String getRepairItemNo() {
		return repairItemNo;
	}
	/**
	 * 设置：维修项目名称
	 */
	public void setRepairItemName(String repairItemName) {
		this.repairItemName = repairItemName;
	}
	/**
	 * 获取：维修项目名称
	 */
	public String getRepairItemName() {
		return repairItemName;
	}
	/**
	 * 设置：维修部位
	 */
	public void setRepairItemPosition(String repairItemPosition) {
		this.repairItemPosition = repairItemPosition;
	}
	/**
	 * 获取：维修部位
	 */
	public String getRepairItemPosition() {
		return repairItemPosition;
	}
	/**
	 * 设置：维修工时
	 */
	public void setRepairWorkHours(String repairWorkHours) {
		this.repairWorkHours = repairWorkHours;
	}
	/**
	 * 获取：维修工时
	 */
	public String getRepairWorkHours() {
		return repairWorkHours;
	}
	/**
	 * 设置：工时费
	 */
	public void setWorkFee(Double workFee) {
		this.workFee = workFee;
	}
	/**
	 * 获取：工时费
	 */
	public Double getWorkFee() {
		return workFee;
	}
	/**
	 * 设置：内部工时
	 */
	public void setWithinHours(String withinHours) {
		this.withinHours = withinHours;
	}
	/**
	 * 获取：内部工时
	 */
	public String getWithinHours() {
		return withinHours;
	}
	/**
	 * 设置：拼音码
	 */
	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}
	/**
	 * 获取：拼音码
	 */
	public String getPinyinCode() {
		return pinyinCode;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注信息
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

	public String getRepairTypeName() {
		return repairTypeName;
	}

	public void setRepairTypeName(String repairTypeName) {
		this.repairTypeName = repairTypeName;
	}

	public String getRepairItemPositionName() {
		return repairItemPositionName;
	}

	public void setRepairItemPositionName(String repairItemPositionName) {
		this.repairItemPositionName = repairItemPositionName;
	}

	public String getRepairTypeId() {
		return repairTypeId;
	}

	public void setRepairTypeId(String repairTypeId) {
		this.repairTypeId = repairTypeId;
	}
}
