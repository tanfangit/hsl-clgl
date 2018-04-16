package com.hsl.clgl.app.cz.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 车主对应的车辆表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-02 13:47:43
 */
@TableName("tb_car")
public class CarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 车辆ID
	 */
	@TableId(type=IdType.INPUT)
	private String carId;

	/**
	 * 车主id
	 */
	@TableField(exist=false)
	private String czId;
	/**
	 * 车牌号码
	 */
	private String carNumber;
	/**
	 * 车辆品牌id
	 */
	private String carBrand;
	/**
	 * 车系ID
	 */
	private String carTrain;
	/**
	 * 车型
	 */
	private String carType;


	/**
	 * 车架号码
	 */
	private String frameNumber;
	/**
	 * 发动机号码
	 */
	private String engineNumber;
	/**
	 * 注册时间
	 */
	private Date registerTime;
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
	 * 设置：车辆ID
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车辆ID
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * 设置：车牌号码
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	/**
	 * 获取：车牌号码
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * 设置：车型
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * 获取：车型
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * 设置：车架号码
	 */
	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}
	/**
	 * 获取：车架号码
	 */
	public String getFrameNumber() {
		return frameNumber;
	}
	/**
	 * 设置：发动机号码
	 */
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	/**
	 * 获取：发动机号码
	 */
	public String getEngineNumber() {
		return engineNumber;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
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

	public String getCzId() {
		return czId;
	}

	public void setCzId(String czId) {
		this.czId = czId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarTrain() {
		return carTrain;
	}

	public void setCarTrain(String carTrain) {
		this.carTrain = carTrain;
	}
}
