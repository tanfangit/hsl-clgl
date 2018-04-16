package com.hsl.clgl.pc.admin.modules.maintenance.parts.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 配件数据维护
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-03-26 20:44:02
 */
@TableName("tb_parts")
public class PartsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 配件id
	 */
	@TableId(type=IdType.INPUT)
	private String partsId;
	/**
	 * 配件名称
	 */
	private String partsName;
	/**
	 * 部位
	 */
	private String part;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 车系
	 */
	private String carLine;
	/**
	 * 合适车型
	 */
	private String suitableModel;
	/**
	 * 配件编号
	 */
	private String partsNum;
	/**
	 * 配件简码
	 */
	private String partsSimpleCode;
	/**
	 * 属性
	 */
	private String properties;
	/**
	 * 年份
	 */
	private String year;
	/**
	 * 成本
	 */
	private String cost;
	/**
	 * 外销价
	 */
	private Double exportPrice;
	/**
	 * 维修价
	 */
	private Double repairPrice;
	/**
	 * 索赔价
	 */
	private Double claimPrice1;
	/**
	 * 理赔价
	 */
	private Double claimPrice2;
	/**
	 * 库位
	 */
	private String torage;
	/**
	 * 下限
	 */
	private String lowerLimit;
	/**
	 * 上限
	 */
	private String upperLimit;
	/**
	 * 最新价
	 */
	private Double latestPrice;
	/**
	 * 网点价
	 */
	private Double branchPrice;
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
	private Date updateTime;
	/**
	 * 更新人
	 */
	private String updateUser;
	/**
	 * 状态(0:新增,1:修改,2:删除)
	 */
	private Integer status;
	/**
	 * 品牌名称
	 */
	@TableField(exist = false)
	private String brandName;

	public String getBrandName() { return brandName; }

	public void setBrandName(String brandName){ this.brandName = brandName; }
	/**
	 * 车系名称
	 */
	@TableField(exist = false)
	private String carLineName;

	public String getCarLineName(){ return carLineName; }

	public void setCarLineName(String carLineName){ this.carLineName = carLineName; }
	/**
	 * 配件名称
	 */
	@TableField(exist = false)
	private String partName;

	public String getPartName(){ return partName; }

	public void setPartName(String partName){ this.partName = partName; }
	/**
	 * 单位名称
	 */
	@TableField(exist = false)
	private String unitName;

	public String getUnitName(){ return unitName; }

	public void setUnitName(String unitName){ this.unitName = unitName; }
	/**
	 * 设置：配件id
	 */
	public void setPartsId(String partsId) {
		this.partsId = partsId;
	}
	/**
	 * 获取：配件id
	 */
	public String getPartsId() {
		return partsId;
	}
	/**
	 * 设置：配件名称
	 */
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	/**
	 * 获取：配件名称
	 */
	public String getPartsName() {
		return partsName;
	}
	/**
	 * 设置：部位
	 */
	public void setPart(String part) {
		this.part = part;
	}
	/**
	 * 获取：部位
	 */
	public String getPart() {
		return part;
	}
	/**
	 * 设置：单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：车系
	 */
	public void setCarLine(String carLine) {
		this.carLine = carLine;
	}
	/**
	 * 获取：车系
	 */
	public String getCarLine() {
		return carLine;
	}
	/**
	 * 设置：合适车型
	 */
	public void setSuitableModel(String suitableModel) {
		this.suitableModel = suitableModel;
	}
	/**
	 * 获取：合适车型
	 */
	public String getSuitableModel() {
		return suitableModel;
	}
	/**
	 * 设置：配件编号
	 */
	public void setPartsNum(String partsNum) {
		this.partsNum = partsNum;
	}
	/**
	 * 获取：配件编号
	 */
	public String getPartsNum() {
		return partsNum;
	}
	/**
	 * 设置：配件简码
	 */
	public void setPartsSimpleCode(String partsSimpleCode) {
		this.partsSimpleCode = partsSimpleCode;
	}
	/**
	 * 获取：配件简码
	 */
	public String getPartsSimpleCode() {
		return partsSimpleCode;
	}
	/**
	 * 设置：属性
	 */
	public void setProperties(String properties) {
		this.properties = properties;
	}
	/**
	 * 获取：属性
	 */
	public String getProperties() {
		return properties;
	}
	/**
	 * 设置：年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年份
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：成本
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	/**
	 * 获取：成本
	 */
	public String getCost() {
		return cost;
	}
	/**
	 * 设置：外销价
	 */
	public void setExportPrice(Double exportPrice) {
		this.exportPrice = exportPrice;
	}
	/**
	 * 获取：外销价
	 */
	public Double getExportPrice() {
		return exportPrice;
	}
	/**
	 * 设置：维修价
	 */
	public void setRepairPrice(Double repairPrice) {
		this.repairPrice = repairPrice;
	}
	/**
	 * 获取：维修价
	 */
	public Double getRepairPrice() {
		return repairPrice;
	}
	/**
	 * 设置：索赔价
	 */
	public void setClaimPrice1(Double claimPrice1) {
		this.claimPrice1 = claimPrice1;
	}
	/**
	 * 获取：索赔价
	 */
	public Double getClaimPrice1() {
		return claimPrice1;
	}
	/**
	 * 设置：理赔价
	 */
	public void setClaimPrice2(Double claimPrice2) {
		this.claimPrice2 = claimPrice2;
	}
	/**
	 * 获取：理赔价
	 */
	public Double getClaimPrice2() {
		return claimPrice2;
	}
	/**
	 * 设置：库位
	 */
	public void setTorage(String torage) {
		this.torage = torage;
	}
	/**
	 * 获取：库位
	 */
	public String getTorage() {
		return torage;
	}
	/**
	 * 设置：下限
	 */
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	/**
	 * 获取：下限
	 */
	public String getLowerLimit() {
		return lowerLimit;
	}
	/**
	 * 设置：上限
	 */
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	/**
	 * 获取：上限
	 */
	public String getUpperLimit() {
		return upperLimit;
	}
	/**
	 * 设置：最新价
	 */
	public void setLatestPrice(Double latestPrice) {
		this.latestPrice = latestPrice;
	}
	/**
	 * 获取：最新价
	 */
	public Double getLatestPrice() {
		return latestPrice;
	}
	/**
	 * 设置：网点价
	 */
	public void setBranchPrice(Double branchPrice) {
		this.branchPrice = branchPrice;
	}
	/**
	 * 获取：网点价
	 */
	public Double getBranchPrice() {
		return branchPrice;
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
	/**
	 * 设置：状态(0:新增,1:修改,2:删除)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:新增,1:修改,2:删除)
	 */
	public Integer getStatus() {
		return status;
	}
}
