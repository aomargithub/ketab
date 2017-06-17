package org.firstpartysystems.ketab.rest.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ThemeDto implements UserModel<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7599317787017155054L;
	
	private Byte id;
	private String code;
	private String description;
	
	
	public boolean equals(Object object){
		
		if(object == null){
			return false;
		}
		
		if(!(object instanceof ThemeDto)){
			return false;
		}
		
		ThemeDto other = (ThemeDto) object;
		
		return new EqualsBuilder().append(getCode(), other.getCode()).isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder().append(getCode()).hashCode();
	}
	
	public String toString(){
		return new ToStringBuilder(this).append(getId()).append(getCode()).append(getDescription()).toString();
	}

	@Override
	public Byte getId() {
		return id;
	}

	@Override
	public void setId(Byte id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
