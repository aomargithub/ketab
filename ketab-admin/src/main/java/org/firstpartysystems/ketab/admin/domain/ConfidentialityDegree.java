package org.firstpartysystems.ketab.admin.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "confidentiality_degree")
public class ConfidentialityDegree implements DomainModel<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8320050401392880950L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Byte id;
	
	@Column(name = "lookup_code")
	private String lookupCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Embedded
	private CreateUpdateLog createUpdateLog;

	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CreateUpdateLog getCreateUpdateLog() {
		return createUpdateLog;
	}

	public void setCreateUpdateLog(CreateUpdateLog createUpdateLog) {
		this.createUpdateLog = createUpdateLog;
	}

	@Override
	public Byte getId() {
		return id;
	}

	@Override
	public void setId(Byte id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
