package org.firstpartysystems.ketab.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class DomainEntity<T extends Serializable> implements DomainModel<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7353309897348767159L;
	
	@Version
	@Column(name="orm_version")
	private Integer ormVersion;

	@Embedded
	private CreateUpdateLog createUpdateLog;

	public CreateUpdateLog getCreateUpdateLog() {
		return createUpdateLog;
	}

	public void setCreateUpdateLog(CreateUpdateLog createUpdateLog) {
		this.createUpdateLog = createUpdateLog;
	}

}
