package org.firstpartysystems.ketab.domain.support;

import java.io.Serializable;

import org.firstpartysystems.ketab.domain.LookupEntity;

/**
 * 
 * @author Ahmad Omar
 *
 */

public class LookupEntityBuilder<E extends LookupEntityBuilder<E, D, T>, D extends LookupEntity<T>, T extends Serializable> extends DomainModelBuilder<E, D, T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7554827673287636865L;
	
	@SuppressWarnings("unchecked")
	public E isActive(Boolean isActive){
		entity.setIsActive(isActive);
		return (E) this;
	}
	
	@SuppressWarnings("unchecked")
	public E code(String code){
		entity.setCode(code);
		return (E) this;
	}

}
