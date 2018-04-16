package com.hsl.clgl.pc.admin.modules.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 封装部门tree实体
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-24 17:24:13
 */
public class SysDeptTreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 部门ID
	 */
	private String Id;


	/**
	 * 父节点ID
	 */
	private String Pid;


	/**
	 * 部门层级
	 */
	private Integer level;

	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 部门
	 */
	List<SysDeptTreeEntity> children;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		Pid = pid;
	}



	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SysDeptTreeEntity> getChildren() {
		return children;
	}

	public void setChildren(List<SysDeptTreeEntity> children) {
		this.children = children;
	}
}
