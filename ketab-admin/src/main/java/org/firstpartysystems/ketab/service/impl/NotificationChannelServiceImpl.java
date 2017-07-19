package org.firstpartysystems.ketab.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.domain.NotificationChannel;
import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.exception.KetabInternalException;
import org.firstpartysystems.ketab.repository.NotificationChannelRepository;
import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;
import org.firstpartysystems.ketab.service.NotificationChannelService;
import org.firstpartysystems.ketab.support.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Handles all of the business related to Notification Channels
 * 
 * 
 * @author Ahmad Omar
 *
 */

@Service
public class NotificationChannelServiceImpl implements NotificationChannelService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2514138584325432277L;
	private final static Logger logger = Logger.getLogger(NotificationChannelServiceImpl.class);
	
	private NotificationChannelRepository notificationChannelRepository; 
	private ModelMapper<NotificationChannel, NotificationChannelDto> notificationChannelMapper;
	
	public NotificationChannelServiceImpl(NotificationChannelRepository notificationChannelRepository, 
			   ModelMapper<NotificationChannel, NotificationChannelDto> notificationChannelMapper){
		this.notificationChannelRepository = notificationChannelRepository;
		this.notificationChannelMapper = notificationChannelMapper;
	}
	
	/**
	 * Fetching all active {@link org.firstpartysystems.ketab.domain.NotificationChannel} from the DB
	 * using isActive flag, then converting them to {@link org.firstpartysystems.ketab.rest.dto.NotificationChannelDto} using 
	 * {@link org.firstpartysystems.ketab.support.modelmapper.NotificationChannelMapper}
	 * 
	 * @return a {@link java.util.List} List of all of active {@link org.firstpartysystems.ketab.rest.dto.NotificationChannelDto}
	 * @throws {@link org.firstpartysystems.ketab.exception.KetabException} in case of any kind of processing failure
	 */
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<NotificationChannelDto> getAllActive()throws KetabException{
		
		List<NotificationChannelDto> notificationChannelDtos = null;
		List<NotificationChannel> notificationChannels = null;
		try{
			
			if(logger.isDebugEnabled()){
				logger.debug("Getting all active Notification Channels by querying the DB ... ");
			}
			
			notificationChannels = notificationChannelRepository.findByIsActive(true);
			
			if(logger.isDebugEnabled()){
				logger.debug("Got " + notificationChannels.size() + " Notification Channels from the DB" );
				logger.debug("Converting the result to DTO ..." );
			}
			
			notificationChannelDtos = notificationChannelMapper.convertToDto(notificationChannels);
			
			if(logger.isDebugEnabled()){
				logger.debug("Result converted." );
			}
			
		}catch(Exception e){
			throw new KetabInternalException(e);
		}
		return notificationChannelDtos;
	}
}
