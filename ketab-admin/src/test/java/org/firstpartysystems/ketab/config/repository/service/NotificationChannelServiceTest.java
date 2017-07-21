package org.firstpartysystems.ketab.config.repository.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.firstpartysystems.ketab.domain.NotificationChannel;
import org.firstpartysystems.ketab.domain.support.NotificationChannelBuilder;
import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.repository.NotificationChannelRepository;
import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;
import org.firstpartysystems.ketab.rest.dto.support.NotificationChannelDtoBuilder;
import org.firstpartysystems.ketab.service.NotificationChannelService;
import org.firstpartysystems.ketab.service.impl.NotificationChannelServiceImpl;
import org.firstpartysystems.ketab.support.modelmapper.ModelMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 
 * @author Ahmad Omar
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@WebAppConfiguration
@ActiveProfiles("test")
public class NotificationChannelServiceTest {
	
	private final static byte numberOfTestChannels = 2;
	
	@Mock
	private NotificationChannelRepository notificationChannelRepository;
	
	@Mock
	private ModelMapper<NotificationChannel, NotificationChannelDto> notificationChannelMapper;
	
	@InjectMocks
	private NotificationChannelService notificationChannelService = new NotificationChannelServiceImpl(notificationChannelRepository, notificationChannelMapper);
	
	@Before
	public void  setup(){
		 MockitoAnnotations.initMocks(this);
		 
		 NotificationChannel notificationChannel1 = new NotificationChannelBuilder("SMS", "", new Date()).build();
		 NotificationChannel notificationChannel2 = new NotificationChannelBuilder("EMAIL", "", new Date()).build();
		 
		 NotificationChannelDto notificationChannelDto1 = new NotificationChannelDtoBuilder("SMS").build();
		 NotificationChannelDto notificationChannelDto2 = new NotificationChannelDtoBuilder("EMAIL").build();
		 
		 List<NotificationChannel> notificationChannels = new ArrayList<NotificationChannel>();
		 List<NotificationChannelDto> notificationChannelDtos = new ArrayList<NotificationChannelDto>();
		 
		 notificationChannels.add(notificationChannel1);
		 notificationChannels.add(notificationChannel2);
		 
		 notificationChannelDtos.add(notificationChannelDto1);
		 notificationChannelDtos.add(notificationChannelDto2);
		 
		 Mockito.when(notificationChannelRepository.findByIsActive(true)).thenReturn(notificationChannels);
		 Mockito.when(notificationChannelMapper.convertToDto(notificationChannels)).thenReturn(notificationChannelDtos);
	}
	
	
	@Test
    public void getAllActive_success() throws KetabException {
		List<NotificationChannelDto> notificationChannelDtos = notificationChannelService.getAllActive();
		assertThat(notificationChannelDtos.size()).isEqualTo(numberOfTestChannels);
	}
}
