package org.firstpartysystems.ketab.rest.dto;

import java.io.Serializable;

/**
 * 
 * @author Ahmad Omar
 *
 */
public abstract class AbstractUserModel<T extends Serializable> implements UserModel<T>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2709319364850379857L;
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
