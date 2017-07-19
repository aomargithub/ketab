package org.firstpartysystems.ketab.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractDomainModel<T extends Serializable> implements DomainModel<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3823759111272993467L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private T id;
	
	@Version
	@Column(name="orm_version")
	private Integer ormVersion;

	@Embedded
	private CreateUpdateLog createUpdateLog;
	
	@Override
	public T getId(){
		return id;
	}
	
	@Override
	public void setId(T id){
		this.id = id;
	}

	public Integer getOrmVersion() {
		return ormVersion;
	}

	public void setOrmVersion(Integer ormVersion) {
		this.ormVersion = ormVersion;
	}

	public CreateUpdateLog getCreateUpdateLog() {
		return createUpdateLog;
	}

	public void setCreateUpdateLog(CreateUpdateLog createUpdateLog) {
		this.createUpdateLog = createUpdateLog;
	}
}
