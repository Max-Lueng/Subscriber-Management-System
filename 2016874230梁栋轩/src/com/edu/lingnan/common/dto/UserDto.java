package com.edu.lingnan.common.dto;

import java.util.Date;

/**
 * 用户信息类
 * @author 涟动喧
 *
 */
public class UserDto {
		
	private int id = 0;					//ID编号
	private String userid = null;		//用户ID
	private String name = null;			//用户姓名
	private String password = null;		//用户密码
	private String mail = null;			//用户邮箱
	private String power = null;		//用户权限
	private Date birth = null;			//用户生日
	private String status = null;		//用户状态
	
	/**
	 * ID编号
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 用户ID
	 * @return
	 */
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 用户姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 用户密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 用户邮箱
	 * @return
	 */
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * 用户权限
	 * @return
	 */
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	/**
	 * 用户生日
	 * @return
	 */
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * 用户状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
