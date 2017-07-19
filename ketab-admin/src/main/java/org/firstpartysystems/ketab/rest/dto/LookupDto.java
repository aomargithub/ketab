package org.firstpartysystems.ketab.rest.dto;

import java.io.Serializable;

public class LookupDto<T extends Serializable> extends AbstractUserModel<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2721251324769691558L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
