package org.firstpartysystems.ketab.rest.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ConfidentialityDegreeDto extends AbstractUserModel<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5881191981188613950L;
	
	private String code;
	private String description;
	private Byte precedence;
	
	public boolean equals(Object object){
		
		if(object == null){
			return false;
		}
		
		if(!(object instanceof ConfidentialityDegreeDto)){
			return false;
		}
		
		ConfidentialityDegreeDto other = (ConfidentialityDegreeDto) object;
		
		return new EqualsBuilder().append(getCode(), other.getCode()).isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder().append(getCode()).hashCode();
	}
	
	public String toString(){
		return new ToStringBuilder(this).append(getId()).append(getCode()).append(getDescription()).toString();
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

	public Byte getPrecedence() {
		return precedence;
	}

	public void setPrecedence(Byte precedence) {
		this.precedence = precedence;
	}

}
