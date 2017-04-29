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
			dto.setDescription(entity.getDescription());
			dto.setLookupCode(entity.getLookupCode());
		}
		
		return dto;
	}

	@Override
	protected ConfidentialityDegree convertToEntity(ConfidentialityDegreeDto dto, boolean nullId) {
		ConfidentialityDegree entity = null;
		
		if(isConvertable(dto)){
			entity = new ConfidentialityDegree();
			entity.setId(nullId ? null : dto.getId());
			entity.setDescription(dto.getDescription());
			entity.setLookupCode(dto.getLookupCode());
		}
		
		return entity;
	}

}
