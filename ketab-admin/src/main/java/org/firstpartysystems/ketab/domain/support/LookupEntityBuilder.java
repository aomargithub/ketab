package org.firstpartysystems.ketab.domain.support;

import java.io.Serializable;

import org.firstpartysystems.ketab.domain.LookupEntity;

/**
 * 
 * @author Ahmad Omar
 *
 */

public class LookupEntityBuilder<D extends LookupEntity<T>, T extends Serializable> extends DomainModelBuilder<D, T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7554827673287636865L;
	
	public D isActive(Boolean isActive){
		entity.setIsActive(isActive);
		return entity;
	}
	
	public D code(String code){
		entity.setCode(code);
		return entity;
	}

}
