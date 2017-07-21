package org.firstpartysystems.ketab.rest.dto.support;

import java.io.Serializable;

import org.firstpartysystems.ketab.rest.dto.LookupDto;

/**
 * 
 * @author Ahmad Omar
 *
 */
public class LookupDtoBuilder<E extends LookupDtoBuilder<E, D, T>, D extends LookupDto<T>, T extends Serializable>extends UserModelBuilder<E, D, T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5456767146350644565L;
	
	@SuppressWarnings("unchecked")
	public E code(String code){
		entity.setCode(code);
		return (E) this;
	}

}
