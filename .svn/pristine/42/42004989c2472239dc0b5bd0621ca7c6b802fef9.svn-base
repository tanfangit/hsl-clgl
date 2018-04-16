package com.hsl.clgl.sh.pc.admin.modules.area.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 区县行政编码字典表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-28 11:58:15
 */
@TableName("sh_tb_area")
public class AreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type=IdType.INPUT)
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 层级标识： 1  省份， 2  市， 3  区县
	 */
	private Integer arealevel;
	/**
	 * 父节点
	 */
	private Integer parentId;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：层级标识： 1  省份， 2  市， 3  区县
	 */
	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
	}
	/**
	 * 获取：层级标识： 1  省份， 2  市， 3  区县
	 */
	public Integer getArealevel() {
		return arealevel;
	}
	/**
	 * 设置：父节点
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父节点
	 */
	public Integer getParentId() {
		return parentId;
	}
}
