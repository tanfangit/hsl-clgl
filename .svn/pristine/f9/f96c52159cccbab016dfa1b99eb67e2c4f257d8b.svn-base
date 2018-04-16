package com.hsl.clgl.pc.admin.modules.dictionary.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典类型表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-02 15:10:26
 */
@TableName("sys_dict_type")
public class SysDictTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字典类型id
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 字典类型名称
	 */
	private String name;
	/**
	 * 字典类型
	 */
	private String type;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记0:废弃  1：正常 2：已删除
	 */
	private Integer delFlag;

	/**
	 * 设置：字典类型id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：字典类型id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：字典类型名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：字典类型名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：字典类型
	 */
	public String getType() {
		return type;
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
	 * 设置：删除标记0:废弃  1：正常 2：已删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标记0:废弃  1：正常 2：已删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}
