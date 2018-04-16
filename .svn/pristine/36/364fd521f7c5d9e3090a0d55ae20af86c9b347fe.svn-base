package com.hsl.clgl.pc.admin.modules.merchant.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商户表
 * 
 * @author yinpengxuan
 * @email yinpengxuanxia@163.com
 * @date 2018-03-29 16:11:44
 */
@TableName("tb_merchant")
public class MerchantEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type=IdType.INPUT)
	private String id;
	/**
	 * 商户名称
	 */
	private String merchantName;
	/**
	 * 商户编号
	 */
	private String merchantNo;
	/**
	 * 负责人
	 */
	private String manager;
	/**
	 * 负责人手机号
	 */
	private String managerPhone;
	/**
	 * 上班时间
	 */
	private String startWorkTime;
	/**
	 * 下班时间
	 */
	private String endWorkTime;
	/**
	 * 简介
	 */
	private String introduce;
	/**
	 * 详细介绍
	 */
	private String detailedIntroduce;
	/**
	 * 地址
	 */
	private String adress;
	/**
	 * 经纬度json值
	 */
	private String lngLat;
	private Double lng;
	private Double lat;
	@TableField(exist=false)
	private List<String> repairType;
	/**
	 * 商户类型 1-快速处理中心 2-修理厂 3-4S店
	 */
	private String type;
	@TableField(exist=false)
	private String typeName;
	/**
	 * 4S店品牌，其他类型留空
	 */
	private String brandId;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	/**
	 * 省份id
	 */
	private String provinceId;
	@TableField(exist=false)
	private String provinceName;
	/**
	 * 地市id
	 */
	private String cityId;
	@TableField(exist=false)
	private String cityName;
	/**
	 * 区县id
	 */
	private String districtId;
	@TableField(exist=false)
	private String districtName;
	/**
	 * 中心管辖临界点坐标数群
	 */
	private String allLatiLongi;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 绘图版本
	 */
	private Integer mappingVersion;
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

	public Integer getMappingVersion() {
		return mappingVersion;
	}

	public void setMappingVersion(Integer mappingVersion) {
		this.mappingVersion = mappingVersion;
	}

	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：商户名称
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	/**
	 * 获取：商户名称
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * 设置：商户编号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	/**
	 * 获取：商户编号
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	/**
	 * 设置：负责人
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	/**
	 * 获取：负责人
	 */
	public String getManager() {
		return manager;
	}
	/**
	 * 设置：负责人手机号
	 */
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	/**
	 * 获取：负责人手机号
	 */
	public String getManagerPhone() {
		return managerPhone;
	}

	public String getStartWorkTime() {
		return startWorkTime;
	}

	public void setStartWorkTime(String startWorkTime) {
		this.startWorkTime = startWorkTime;
	}

	public String getEndWorkTime() {
		return endWorkTime;
	}

	public void setEndWorkTime(String endWorkTime) {
		this.endWorkTime = endWorkTime;
	}

	/**
	 * 设置：简介
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：简介
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * 设置：详细介绍
	 */
	public void setDetailedIntroduce(String detailedIntroduce) {
		this.detailedIntroduce = detailedIntroduce;
	}
	/**
	 * 获取：详细介绍
	 */
	public String getDetailedIntroduce() {
		return detailedIntroduce;
	}
	/**
	 * 设置：地址
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * 获取：地址
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * 设置：经纬度json值
	 */
	public void setLngLat(String lngLat) {
		this.lngLat = lngLat;
	}
	/**
	 * 获取：经纬度json值
	 */
	public String getLngLat() {
		return lngLat;
	}
	/**
	 * 设置：商户类型 1-快速处理中心 2-修理厂 3-4S店
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：商户类型 1-快速处理中心 2-修理厂 3-4S店
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：省份id
	 */
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：省份id
	 */
	public String getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：地市id
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：地市id
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * 设置：区县id
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	/**
	 * 获取：区县id
	 */
	public String getDistrictId() {
		return districtId;
	}
	/**
	 * 设置：中心管辖临界点坐标数群
	 */
	public void setAllLatiLongi(String allLatiLongi) {
		this.allLatiLongi = allLatiLongi;
	}
	/**
	 * 获取：中心管辖临界点坐标数群
	 */
	public String getAllLatiLongi() {
		return allLatiLongi;
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public List<String> getRepairType() {
		return repairType;
	}

	public void setRepairType(List<String> repairType) {
		this.repairType = repairType;
	}
}
