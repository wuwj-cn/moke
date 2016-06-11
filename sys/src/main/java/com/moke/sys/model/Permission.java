package com.moke.sys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_PERMISSION")
public class Permission {
	@Id  
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name = "system-uuid",strategy="uuid")  
	@Column(length=32)  
	private String uuid;
	
	@Column(length=64)
    private String permission; //权限标识 程序中判断使用,如"user:create"
    
	@Column(length=255)
	private String description; //权限描述,UI界面显示使用
    
	@Column(length=1, nullable=false)
	private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
