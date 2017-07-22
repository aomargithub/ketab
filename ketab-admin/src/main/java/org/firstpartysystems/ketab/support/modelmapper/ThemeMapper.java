package org.firstpartysystems.ketab.support.modelmapper;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.domain.Theme;
import org.firstpartysystems.ketab.rest.dto.ThemeDto;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Ahmad Omar
 *
 */
@Component
public class ThemeMapper extends AbstractModelMapper<Theme, ThemeDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5568135691376164132L;
	private final static Logger logger = Logger.getLogger(ThemeMapper.class);

	@Override
	public ThemeDto convertToDto(Theme entity) {
		ThemeDto dto = null;
		
		if(isConvertable(entity)){
			dto = new ThemeDto();
			
			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
			dto.setDescription(entity.getDescription());
		}
		
		return dto;
	}

	@Override
	protected Theme convertToEntity(ThemeDto dto, boolean nullId) {
		Theme entity = null;
		
		if(isConvertable(dto)){
			entity = new Theme();
			
			entity.setId(nullId ? null : dto.getId());
			entity.setCode(dto.getCode());
			entity.setDescription(dto.getDescription());
		}
		
		return entity;
	}

}
