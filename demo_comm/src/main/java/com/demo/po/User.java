package com.demo.po;

import java.util.Date;

public class User {

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 登录名
	 */
	private String loginString;

	/**
	 * 邮件
	 */
	private String email;

	/**
	 * 电话号码（加密后的）
	 */
	private String phone;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户昵称
	 */
	private String nickname;

	/**
	 * 头像
	 */
	private String headImage;

	/**
	 * 是否为内部账号
	 */
	private Boolean innerFlag;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 上一次登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 上一次登录IP地址
	 */
	private Date lastLoginIp;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	public static enum STATUS {

		NORMAL(1, "正常"),

		FREEZE(2, "已冻结"),

		delete(3, "已删除");

		private Integer code;

		private String cnName;

		STATUS(Integer code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}

		public Integer code() {
			return this.code;
		}

		public String cnName() {
			return this.cnName;
		}

		public String getCnNameByCode(Integer code) {
			for (STATUS item : STATUS.values()) {
				if (item.code.equals(code)) {
					return item.cnName;
				}
			}

			return code == null ? null : code.toString();
		}

		public boolean isValidCode(Integer code) {
			for (STATUS item : STATUS.values()) {
				if (item.code.equals(code)) {
					return true;
				}
			}

			return false;
		}

		@Override
		public String toString(){
			return this.name();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginString() {
		return loginString;
	}

	public void setLoginString(String loginString) {
		this.loginString = loginString;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Boolean getInnerFlag() {
		return innerFlag;
	}

	public void setInnerFlag(Boolean innerFlag) {
		this.innerFlag = innerFlag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(Date lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
