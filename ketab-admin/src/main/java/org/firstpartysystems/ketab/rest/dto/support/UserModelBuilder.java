package org.firstpartysystems.ketab.rest.dto.support;

import java.io.Serializable;

import org.firstpartysystems.ketab.rest.dto.UserModel;

/**
 * 
 * @author Ahmad Omar
 *
 */
public class UserModelBuilder<E extends UserModelBuilder<E, D, T>, D extends UserModel<T>, T extends Serializable>  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5018451666138516555L;
	
	protected D entity;
	
	public D build(){
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public E id(T id){
		entity.setId(id);
		return (E) this;
	}
}
