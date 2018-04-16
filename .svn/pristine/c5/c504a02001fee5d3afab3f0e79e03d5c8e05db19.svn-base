package com.hsl.clgl.sh.pc.admin.modules.rescue.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 救援单表
 * 
 * @author zhangqiao
 * @email zhangqiao@qq.com
 * @date 2018-04-09 11:17:55
 */
@TableName("sh_rescue_order")
public class ShRescueOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * JY开头时间戳加6位随机数JY20180409091000123456
	 */
	@TableId(type=IdType.INPUT)
	private String rescueId;
	/**
	 * 用户open_id
	 */
	private String openId;
	/**
	 * 商户id
	 */
	private String shId;
	/**
	 * 拖车单id
	 */
	private String trailerListId;
	/**
	 * 接车单id
	 */
	private String jcLisId;
	/**
	 * 车主车牌号
	 */
	private String rescueCarNo;
	/**
	 * 救援类型字典值：1：换胎、2：送油、3：送水、4:送电、5:其他
	 */
	private String rescueTypeCode;

	/**
	 * 救援类型名称
	 */
	@TableField(exist = false)
	private String  rescueTypeName;
	/**
	 * 0:无法正常行驶，1:正常行驶
	 */
	private Integer isNormalDriving;
	/**
	 * 0:不需要拖车，1:需要拖车
	 */
	private Integer isNeedTrailer;
	/**
	 * 故障描述
	 */
	private String rescueRemark;
	/**
	 * 联系电话
	 */
	private String rescuePhone;
	/**
	 * 地址
	 */
	private String rescueAdress;
	/**
	 * 经纬度json值
	 */
	private String rescueLngLat;
	/**
	 * 联系人
	 */
	private String rescuePerson;
	/**
	 * 救援单状态:0：取消订单、1：已提交、2：已派单、3：已接单、4:救援中、5:已完成、6:已评价
	 */
	private Integer rescueStatus;

	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新人
	 */
	private String updateUser;
	/**
	 * 更新平台:clgl：运营平台,sh:商户平台
	 */
	private String updatePlat;

	/**
	 * 经度  调用gis匹配需要的参数
	 */
	@TableField(exist = false)
	private String lng;
	/**
	 *纬度   调用gis匹配需要的参数
	 */
	@TableField(exist = false)
	private String lat;
	/**
	 * 拖车状态
	 */
	@TableField(exist = false)
	private String  trailerListStatus;

	/**
	 * 城市id    调用gis匹配需要的参数
	 */
	@TableField(exist = false)
	private String  cityId;

	/**
	 * 设置：JY开头时间戳加6位随机数JY20180409091000123456
	 */
	public void setRescueId(String rescueId) {
		this.rescueId = rescueId;
	}
	/**
	 * 获取：JY开头时间戳加6位随机数JY20180409091000123456
	 */
	public String getRescueId() {
		return rescueId;
	}
	/**
	 * 设置：用户open_id
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：用户open_id
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：商户id
	 */
	public void setShId(String shId) {
		this.shId = shId;
	}
	/**
	 * 获取：商户id
	 */
	public String getShId() {
		return shId;
	}
	/**
	 * 设置：拖车单id
	 */
	public void setTrailerListId(String trailerListId) {
		this.trailerListId = trailerListId;
	}
	/**
	 * 获取：拖车单id
	 */
	public String getTrailerListId() {
		return trailerListId;
	}
	/**
	 * 设置：接车单id
	 */
	public void setJcLisId(String jcLisId) {
		this.jcLisId = jcLisId;
	}
	/**
	 * 获取：接车单id
	 */
	public String getJcLisId() {
		return jcLisId;
	}
	/**
	 * 设置：车主车牌号
	 */
	public void setRescueCarNo(String rescueCarNo) {
		this.rescueCarNo = rescueCarNo;
	}
	/**
	 * 获取：车主车牌号
	 */
	public String getRescueCarNo() {
		return rescueCarNo;
	}
	/**
	 * 设置：救援类型字典值：1：换胎、2：送油、3：送水、4:送电、5:其他
	 */
	public void setRescueTypeCode(String rescueTypeCode) {
		this.rescueTypeCode = rescueTypeCode;
	}
	/**
	 * 获取：救援类型字典值：1：换胎、2：送油、3：送水、4:送电、5:其他
	 */
	public String getRescueTypeCode() {
		return rescueTypeCode;
	}
	/**
	 * 设置：0:无法正常行驶，1:正常行驶
	 */
	public void setIsNormalDriving(Integer isNormalDriving) {
		this.isNormalDriving = isNormalDriving;
	}
	/**
	 * 获取：0:无法正常行驶，1:正常行驶
	 */
	public Integer getIsNormalDriving() {
		return isNormalDriving;
	}
	/**
	 * 设置：0:不需要拖车，1:需要拖车
	 */
	public void setIsNeedTrailer(Integer isNeedTrailer) {
		this.isNeedTrailer = isNeedTrailer;
	}
	/**
	 * 获取：0:不需要拖车，1:需要拖车
	 */
	public Integer getIsNeedTrailer() {
		return isNeedTrailer;
	}
	/**
	 * 设置：故障描述
	 */
	public void setRescueRemark(String rescueRemark) {
		this.rescueRemark = rescueRemark;
	}
	/**
	 * 获取：故障描述
	 */
	public String getRescueRemark() {
		return rescueRemark;
	}
	/**
	 * 设置：联系电话
	 */
	public void setRescuePhone(String rescuePhone) {
		this.rescuePhone = rescuePhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getRescuePhone() {
		return rescuePhone;
	}
	/**
	 * 设置：地址
	 */
	public void setRescueAdress(String rescueAdress) {
		this.rescueAdress = rescueAdress;
	}
	/**
	 * 获取：地址
	 */
	public String getRescueAdress() {
		return rescueAdress;
	}
	/**
	 * 设置：经纬度json值
	 */
	public void setRescueLngLat(String rescueLngLat) {
		this.rescueLngLat = rescueLngLat;
	}
	/**
	 * 获取：经纬度json值
	 */
	public String getRescueLngLat() {
		return rescueLngLat;
	}
	/**
	 * 设置：联系人
	 */
	public void setRescuePerson(String rescuePerson) {
		this.rescuePerson = rescuePerson;
	}
	/**
	 * 获取：联系人
	 */
	public String getRescuePerson() {
		return rescuePerson;
	}
	/**
	 * 设置：救援单状态:0：取消订单、1：已提交、2：已派单、3：已接单、4:救援中、5:已完成、6:已评价
	 */
	public void setRescueStatus(Integer rescueStatus) {
		this.rescueStatus = rescueStatus;
	}
	/**
	 * 获取：救援单状态:0：取消订单、1：已提交、2：已派单、3：已接单、4:救援中、5:已完成、6:已评价
	 */
	public Integer getRescueStatus() {
		return rescueStatus;
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
	 * 设置：更新平台:clgl：运营平台,sh:商户平台
	 */
	public void setUpdatePlat(String updatePlat) {
		this.updatePlat = updatePlat;
	}
	/**
	 * 获取：更新平台:clgl：运营平台,sh:商户平台
	 */
	public String getUpdatePlat() {
		return updatePlat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getRescueTypeName() {
		return rescueTypeName;
	}

	public void setRescueTypeName(String rescueTypeName) {
		this.rescueTypeName = rescueTypeName;
	}

	public String getTrailerListStatus() {
		return trailerListStatus;
	}

	public void setTrailerListStatus(String trailerListStatus) {
		this.trailerListStatus = trailerListStatus;
	}


	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
