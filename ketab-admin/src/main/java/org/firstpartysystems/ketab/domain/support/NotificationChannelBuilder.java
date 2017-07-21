package org.firstpartysystems.ketab.domain.support;

import java.util.Date;

import org.firstpartysystems.ketab.domain.NotificationChannel;

/**
 * 
 * @author Ahmad Omar
 *
 */
public class NotificationChannelBuilder extends LookupEntityBuilder<NotificationChannelBuilder, NotificationChannel, Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3873322146714067699L;
	
	public NotificationChannelBuilder(String code, String createBy, Date createDate){
		entity = new NotificationChannel();
		code(code);
		this.createBy = createBy;
		this.createDate = createDate;
	}
	
	public NotificationChannelBuilder description(String description){
		entity.setDescription(description);
		return this;
	}
}
