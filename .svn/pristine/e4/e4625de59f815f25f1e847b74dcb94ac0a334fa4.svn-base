package com.hsl.clgl.pc.admin.modules.maintenance.repair.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 维修类别与维修项目对应关系
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-29 14:45:05
 */
@TableName("tb_repair_type_item")
public class RepairTypeItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 维修类型ID
	 */
	private String repairTypeId;
	/**
	 * 维修项目ID
	 */
	private String repairItemId;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：维修类型ID
	 */
	public void setRepairTypeId(String repairTypeId) {
		this.repairTypeId = repairTypeId;
	}
	/**
	 * 获取：维修类型ID
	 */
	public String getRepairTypeId() {
		return repairTypeId;
	}
	/**
	 * 设置：维修项目ID
	 */
	public void setRepairItemId(String repairItemId) {
		this.repairItemId = repairItemId;
	}
	/**
	 * 获取：维修项目ID
	 */
	public String getRepairItemId() {
		return repairItemId;
	}
}
