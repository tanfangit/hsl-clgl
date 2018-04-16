package com.hsl.clgl.app.cz.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 车主与车辆关联表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 13:50:45
 */
@TableName("tb_cz_car")
public class CzCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 车主id
	 */
	private String czId;
	/**
	 * 车辆id
	 */
	private String carId;

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
	 * 设置：车主id
	 */
	public void setCzId(String czId) {
		this.czId = czId;
	}
	/**
	 * 获取：车主id
	 */
	public String getCzId() {
		return czId;
	}
	/**
	 * 设置：车辆id
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车辆id
	 */
	public String getCarId() {
		return carId;
	}
}
