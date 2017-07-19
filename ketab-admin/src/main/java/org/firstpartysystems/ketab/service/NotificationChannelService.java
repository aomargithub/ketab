package org.firstpartysystems.ketab.service;

import java.io.Serializable;
import java.util.List;

import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;

public interface NotificationChannelService extends Serializable{

	List<NotificationChannelDto> getAllActive() throws KetabException;

}
