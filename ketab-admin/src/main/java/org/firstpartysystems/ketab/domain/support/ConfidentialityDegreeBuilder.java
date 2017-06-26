package org.firstpartysystems.ketab.domain.support;

import java.util.Date;

import org.firstpartysystems.ketab.domain.ConfidentialityDegree;

public class ConfidentialityDegreeBuilder extends DomainEntityBuilder<ConfidentialityDegree, Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 502409505185818378L;
	
	public ConfidentialityDegreeBuilder(String code, String createBy, Date createDate){
		entity = new ConfidentialityDegree();
		entity.setCode(code);
		this.createBy = createBy;
		this.createDate = createDate;
	}
	
	public ConfidentialityDegreeBuilder description(String description){
		entity.setDescription(description);
		return this;
	}
	
	public ConfidentialityDegreeBuilder precedence(Byte precedence){
		entity.setPrecedence(precedence);
		return this;
	}

}
