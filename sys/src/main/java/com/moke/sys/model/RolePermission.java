package com.moke.sys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_ROLE_PERMISSION")
public class RolePermission {

	@Id  
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name = "system-uuid",strategy="uuid")  
	@Column(length=32)  
	private String uuid;
	
	@Column(length=32)
    private String roleId;
	
	@Column(length=32)
    private String permissionId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
}
