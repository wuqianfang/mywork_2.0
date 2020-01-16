package com.tomwu.maven.ssm.login.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class User  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String username;
    private String password;
    private String email;
    private String createTime;
    private String lastLoginTime;
    private int status;
    private String phone;
    private BigDecimal account;
     
    public BigDecimal getAccount() {
        return account;
    }
 
    public void setAccount(BigDecimal account) {
        this.account = account;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getCreateTime() {
        return createTime;
    }
 
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
 
    public String getLastLoginTime() {
        return lastLoginTime;
    }
 
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
 
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
 
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
        return serialVersionUID;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + ", status=" + status
				+ ", account=" + account + "]";
	}
    
}
