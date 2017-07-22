package org.firstpartysystems.ketab.rest.dto.support;

import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;

public class NotificationChannelDtoBuilder extends LookupDtoBuilder<NotificationChannelDtoBuilder, NotificationChannelDto, Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 739808821023391709L;
	
	public NotificationChannelDtoBuilder(String code){
		entity = new NotificationChannelDto();
		code(code);
	}
	
	public NotificationChannelDtoBuilder description(String description){
		entity.setDescription(description);
		return this;
	}

}
