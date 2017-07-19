package org.firstpartysystems.ketab.config.repository.service;

import org.firstpartysystems.ketab.domain.NotificationChannel;
import org.firstpartysystems.ketab.repository.NotificationChannelRepository;
import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;
import org.firstpartysystems.ketab.service.NotificationChannelService;
import org.firstpartysystems.ketab.service.impl.NotificationChannelServiceImpl;
import org.firstpartysystems.ketab.support.modelmapper.ModelMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@WebAppConfiguration
@ActiveProfiles("test")
public class NotificationChannelServiceTest {
	private final static byte numberOfTestDegrees = 2;
	
	@Mock
	private NotificationChannelRepository notificationChannelRepository;
	
	@Mock
	private ModelMapper<NotificationChannel, NotificationChannelDto> notificationChannelMapper;
	
	@InjectMocks
	private NotificationChannelService notificationChannelService = new NotificationChannelServiceImpl(notificationChannelRepository, notificationChannelMapper);
	
	@Before
	public void  setup(){
		 MockitoAnnotations.initMocks(this);
	}
}
