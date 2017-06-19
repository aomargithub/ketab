package org.firstpartysystems.ketab.admin.support.modelmapper;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.admin.domain.NotificationChannel;
import org.firstpartysystems.ketab.admin.rest.dto.NotificationChannelDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationChannelMapper extends AbstractModelMapper<NotificationChannel, NotificationChannelDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4287329172000925825L;
	private final static Logger logger = Logger.getLogger(NotificationChannelMapper.class);

	@Override
	public NotificationChannelDto convertToDto(NotificationChannel entity) {
		NotificationChannelDto dto = null;
		
		if(isConvertable(entity)){
			dto = new NotificationChannelDto();
			
			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
			dto.setDescription(entity.getDescription());
		}
		
		return dto;
	}

	@Override
	protected NotificationChannel convertToEntity(NotificationChannelDto dto, boolean nullId) {
		NotificationChannel entity = null;
		
		if(isConvertable(dto)){
			entity = new NotificationChannel();
			
			entity.setId(nullId ? null : dto.getId());
			entity.setCode(dto.getCode());
			entity.setDescription(dto.getDescription());
		}
		
		return entity;
	}

}
