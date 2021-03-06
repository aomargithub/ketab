package org.firstpartysystems.ketab.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author Ahmad Omar
 *
 */
@Entity
@Table(name = "confidentiality_degree")
public class ConfidentialityDegree extends LookupEntity<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8320050401392880950L;
	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "precedence")
	private Byte precedence;
	
	public boolean equals(Object object){
		
		if(object == this){
			return true;
		}
		
		if(object == null){
			return false;
		}
		
		if(!(object instanceof ConfidentialityDegree)){
			return false;
		}
		
		ConfidentialityDegree other = (ConfidentialityDegree) object;
		
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
	
	public Byte getPrecedence() {
		return precedence;
	}

	public void setPrecedence(Byte precedence) {
		this.precedence = precedence;
	}

}
