package com.moke.sys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_USER")
public class User {

	@Id  
	@GeneratedValue(generator="system-uuid")  
	@GenericGenerator(name = "system-uuid",strategy="uuid")  
	@Column(length=32)  
	private String uuid;
	
	@Column(length=32)
	private String username;
	
	@Column(length=32)
	private String nickname;
	
	@Column(length=32)
	private String deptCode;
	
	@Column(length=32)
	private String password;
	
	@Column(length=32)
	private String salt;

	@Column(length=1, nullable=false)
    private Boolean locked = Boolean.FALSE;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
        return username + salt;
    }
	
	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
}
