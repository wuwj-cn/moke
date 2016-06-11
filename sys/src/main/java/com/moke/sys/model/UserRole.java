package com.moke.sys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_USER_ROLE")
public class UserRole {

	@Id  
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name = "system-uuid",strategy="uuid")  
	@Column(length=32)  
	private String uuid;
	
	@Column(length=32)
    private String userId;
	
	@Column(length=32)
    private String roleId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
