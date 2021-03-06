package org.firstpartysystems.ketab.admin.support.modelmapper;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.admin.domain.ConfidentialityDegree;
import org.firstpartysystems.ketab.admin.rest.dto.ConfidentialityDegreeDto;
import org.springframework.stereotype.Component;

@Component
public class ConfidentialityDegreeMapper extends AbstractModelMapper<ConfidentialityDegree, ConfidentialityDegreeDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7456148934561042594L;
	private final static Logger logger = Logger.getLogger(ConfidentialityDegreeMapper.class);

	@Override
	public ConfidentialityDegreeDto convertToDto(ConfidentialityDegree entity) {
		ConfidentialityDegreeDto dto = null;
		
		if(isConvertable(entity)){
			dto = new ConfidentialityDegreeDto();
			
			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
			dto.setPrecedence(entity.getPrecedence());
			dto.setDescription(entity.getDescription());
		}
		
		return dto;
	}

	@Override
	protected ConfidentialityDegree convertToEntity(ConfidentialityDegreeDto dto, boolean nullId) {
		ConfidentialityDegree entity = null;
		
		if(isConvertable(dto)){
			entity = new ConfidentialityDegree();
			
			entity.setCode(dto.getCode());
			entity.setPrecedence(dto.getPrecedence());
			entity.setId(nullId ? null : dto.getId());
			entity.setDescription(dto.getDescription());
		}
		
		return entity;
	}

}
