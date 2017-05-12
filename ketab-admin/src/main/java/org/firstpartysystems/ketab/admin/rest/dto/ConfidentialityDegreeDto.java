package org.firstpartysystems.ketab.admin.rest.dto;

public class ConfidentialityDegreeDto implements UserModel<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5881191981188613950L;
	
	private Byte id;
	private String code;
	private String description;

	@Override
	public Byte getId() {
		return id;
	}

	@Override
	public void setId(Byte id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
