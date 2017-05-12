package org.firstpartysystems.ketab.admin.domain;

import java.io.Serializable;

import javax.persistence.Column;

public abstract class LookupEntity<T extends Serializable> extends DomainEntity<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 100858682110387115L;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "code")
	private String code;
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
