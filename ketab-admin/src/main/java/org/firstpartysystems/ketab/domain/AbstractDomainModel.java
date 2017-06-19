package org.firstpartysystems.ketab.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
	
	@Override
	public T getId(){
		return id;
	}
	
	@Override
	public void setId(T id){
		this.id = id;
	}
}
