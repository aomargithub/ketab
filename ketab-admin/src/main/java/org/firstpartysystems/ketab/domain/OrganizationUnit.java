package org.firstpartysystems.ketab.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "organization_unit")
public class OrganizationUnit extends LookupEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5368985918134006857L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private OrganizationUnit parent;
	
	
	@Column(name = "is_receiving_correspondences")
	private Boolean isReceivingCorrespondences;
	
	
	@Column(name = "is_sending_correspondences")
	private Boolean isSendingCorrespodences;
	
	@Column(name = "name")
	private String name;
	
	public boolean equals(Object object){
		
		if(object == this){
			return true;
		}
		
		if(object == null){
			return false;
		}
		
		if(!(object instanceof OrganizationUnit)){
			return false;
		}
		
		OrganizationUnit other  = (OrganizationUnit) object;
		
		return new EqualsBuilder().append(getCode(), other.getCode()).isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder().append(getCode()).hashCode();
	}
	
	public String toString(){
		return new ToStringBuilder(this).append(getId()).append(getCode()).append(getName()).toString();
	}


	public OrganizationUnit getParent() {
		return parent;
	}


	public void setParent(OrganizationUnit parent) {
		this.parent = parent;
	}


	public Boolean getIsReceivingCorrespondences() {
		return isReceivingCorrespondences;
	}


	public void setIsReceivingCorrespondences(Boolean isReceivingCorrespondences) {
		this.isReceivingCorrespondences = isReceivingCorrespondences;
	}


	public Boolean getIsSendingCorrespodences() {
		return isSendingCorrespodences;
	}


	public void setIsSendingCorrespodences(Boolean isSendingCorrespodences) {
		this.isSendingCorrespodences = isSendingCorrespodences;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
