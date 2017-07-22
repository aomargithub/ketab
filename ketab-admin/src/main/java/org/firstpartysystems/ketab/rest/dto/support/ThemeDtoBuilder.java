package org.firstpartysystems.ketab.rest.dto.support;

import org.firstpartysystems.ketab.rest.dto.ThemeDto;

public class ThemeDtoBuilder extends LookupDtoBuilder<ThemeDtoBuilder, ThemeDto, Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 410600130386885113L;

	public ThemeDtoBuilder(String code){
		entity = new ThemeDto();
		code(code);
	}
	
	public ThemeDtoBuilder description(String description){
		entity.setDescription(description);
		return this;
	}
}
