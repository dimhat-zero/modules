package com.jianla.model.base;


import com.jianla.web.Subject;

import java.io.Serializable;
import java.util.Set;

/**
 * sessionInfo模型
 * 
 * @author 孙宇
 * 
 */
public class SessionInfo implements Serializable,Subject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ID
	 * 	 organization登录时为联系人的id，member登录时为登录id
	 */
	private Long userId;
	/*
	 * 真实姓名
	 * 	 organization登录时为联系人的真实姓名，member登录时为登录者的真实姓名
	 */
	private String realName;
	/*
	 * 所属部门id
	 * 	 organization登录时为null，member登录时为其所属部门id
	 */
	private Long departmentId;
	/*
	 * 所属部门名称
	 * 	 organization登录时为null，member登录时为其所属部门名称
	 */
	private String departmentName;
	
	
	/*
	 * 以下5项为企业联系人或者登录个人用户的个人信息，一般不用
	 */
	private String sfzID;
	private String birth;
	private String gender;
	private String email;
	private String tel;
	private String mobile;
	
	/*
	 * 登录名
	 *   organization登录时为企业登录名，member登录时为个人登录名
	 */
	
	private String loginName;	
	/*
	 * 登录密码
	 *   organization登录时为企业登录密码，member登录时为个人登录密码
	 */
	
	private String loginPassword;// 登录密码	
	/*
	 * 登录类型
	 *    0表示organization，1表示member
	 */
	private int loginType;
	
	
	
	private String ip;// IP地址
	private String authIds;// 拥有的权限ID集合
	private String authNames;
	private String authUrls;
	private String roleIds;
	private String roleNames;

	//扩展两个权限字段
	private Set<String> roles;
	private Set<String> perms;
	private long authTime=-1;//权限更新时间，-1会自动更新
	
	
	/*
	 * 企业ID
	 * 	 organization登录时为登录企业id，member登录时为其所属企业id
	 */
	private Long orgnizationId;
	/*
	 * 企业名字（中文名）
	 * 	 organization登录时为登录企业名字，member登录时为其所属企业名字
	 */
	private String orgnizationName;
	
	/**
	 * 企业类型
	 * 
	 */
	private int orgnizationType;
	

	public int getOrgnizationType() {
		return orgnizationType;
	}

	public void setOrgnizationType(int orgnizationType) {
		this.orgnizationType = orgnizationType;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSfzID() {
		return sfzID;
	}

	public void setSfzID(String sfzID) {
		this.sfzID = sfzID;
	}

	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrgnizationName() {
		return orgnizationName;
	}

	public void setOrgnizationName(String orgnizationName) {
		this.orgnizationName = orgnizationName;
	}

	public String getAuthUrls() {
		return authUrls;
	}

	public void setAuthUrls(String authUrls) {
		this.authUrls = authUrls;
	}

	public String getAuthNames() {
		return authNames;
	}

	public void setAuthNames(String authNames) {
		this.authNames = authNames;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getAuthIds() {
		return authIds;
	}

	public void setAuthIds(String authIds) {
		this.authIds = authIds;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getOrgnizationId() {
		return orgnizationId;
	}

	public void setOrgnizationId(Long orgnizationId) {
		this.orgnizationId = orgnizationId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return loginName;
	}


	@Override
	public Serializable identifier() {
		return loginName;
	}

	@Override
	public Set<String> getPerms() {
		return perms;
	}

	@Override
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void setPerms(Set<String> perms) {
		this.perms = perms;
	}

	@Override
	public long getAuthTime() {
		return authTime;
	}

	@Override
	public void setAuthTime(long authTime) {
		this.authTime = authTime;
	}
}
