package org.firstpartysystems.ketab.domain.support;

import java.io.Serializable;
import java.util.Date;

import org.firstpartysystems.ketab.domain.AbstractDomainModel;
import org.firstpartysystems.ketab.domain.CreateUpdateLog;

/**
 * 
 * @author Ahmad Omar
 *
 */

public class DomainModelBuilder<D extends AbstractDomainModel<T>, T extends Serializable>  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3038708864876822678L;
	protected D entity;
	protected String createBy;
	protected Date createDate;
	
	public D build(){
		CreateUpdateLog createUpdateLog = new CreateUpdateLog(createBy, createDate);
		entity.setCreateUpdateLog(createUpdateLog);
		return entity;
	}
	
	public DomainModelBuilder<D, T> id(T id){
		entity.setId(id);
		return this;
	}
}
