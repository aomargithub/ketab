package org.firstpartysystems.ketab.rest.dto.support;

import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;

/**
 * 
 * @author Ahmad Omar
 *
 */
public class ConfidentialityDegreeDtoBuilder extends LookupDtoBuilder<ConfidentialityDegreeDtoBuilder, ConfidentialityDegreeDto, Byte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5837428553211935215L;
	
	
	public ConfidentialityDegreeDtoBuilder(String code){
		entity = new ConfidentialityDegreeDto();
		code(code);
	}
	
	public ConfidentialityDegreeDtoBuilder description(String description){
		entity.setDescription(description);
		return this;
	}
	
	public ConfidentialityDegreeDtoBuilder precedence(Byte precedence){
		entity.setPrecedence(precedence);
		return this;
	}

}
