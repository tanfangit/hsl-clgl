package com.hsl.clgl.app.cz.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户Token
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-29 11:43:28
 */
@TableName("tb_cz_token")
public class CzTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 车主id
	 */
	@TableId(type=IdType.INPUT)
	private String userId;
	/**
	 * token
	 */
	private String token;
	/**
	 * 过期时间
	 */
	private Date expireTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：车主id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：车主id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取：token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * 设置：过期时间
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpireTime() {
		return expireTime;
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
}
