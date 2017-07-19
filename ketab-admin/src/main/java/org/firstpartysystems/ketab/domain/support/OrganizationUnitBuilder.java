package org.firstpartysystems.ketab.domain.support;

import java.util.Date;

import org.firstpartysystems.ketab.domain.OrganizationUnit;

/**
 * 
 * @author Ahmad Omar
 *
 */

public class OrganizationUnitBuilder extends LookupEntityBuilder<OrganizationUnit, Long>{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5651716292907895489L;

	public OrganizationUnitBuilder(String code, String createBy, Date createDate){
		entity = new OrganizationUnit();
		code(code);
		this.createBy = createBy;
		this.createDate = createDate;
		
	}
	
	public OrganizationUnitBuilder parent(OrganizationUnit parent){
		entity.setParent(parent);
		return this;
	} 
	
	public OrganizationUnitBuilder isReceivingCorrespondences(Boolean isReceivingCorrespondences){
		entity.setIsReceivingCorrespondences(isReceivingCorrespondences);
		return this;
	}
	
	public OrganizationUnitBuilder isSendingCorrespodences(Boolean isSendingCorrespodences){
		entity.setIsSendingCorrespodences(isSendingCorrespodences);
		return this;
	}
}
