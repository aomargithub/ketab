package org.firstpartysystems.ketab.domain.support;

import java.util.Date;

import org.firstpartysystems.ketab.domain.Theme;

/**
 * 
 * @author Ahmad Omar
 *
 */
public class ThemeBuilder extends LookupEntityBuilder<ThemeBuilder, Theme, Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -406211807662109926L;

	
	public ThemeBuilder(String code, String createBy, Date createDate){
		entity = new Theme();
		code(code);
		this.createBy = createBy;
		this.createDate = createDate;
	}
	
	public ThemeBuilder description(String description){
		entity.setDescription(description);
		return this;
	}
}
