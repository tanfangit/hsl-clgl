package com.hsl.clgl.sh.pc.admin.modules.dictionary.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 数据字典值表
 * 
 * @author huangpengbin
 * @email 496512819@qq.com
 * @date 2018-04-03 09:17:13
 */
@TableName("sys_dict_value")
public class SysDictValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字典值id
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 所属字典类型id
	 */
	private String parentId;
	/**
	 * 字典值名称
	 */
	private String name;
	/**
	 * 字典码
	 */
	private String code;
	/**
	 * 字典值
	 */
	private String value;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记0:废弃  1：正常 2：已删除
	 */
	private Integer delFlag;

	/**
	 * 设置：字典值id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：字典值id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：所属字典类型id
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：所属字典类型id
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：字典值名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：字典值名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：字典码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：字典值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：字典值
	 */
	public String getValue() {
		return value;
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
