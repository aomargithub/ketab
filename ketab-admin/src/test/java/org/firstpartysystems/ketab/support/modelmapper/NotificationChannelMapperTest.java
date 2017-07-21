package org.firstpartysystems.ketab.support.modelmapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.firstpartysystems.ketab.domain.NotificationChannel;
import org.firstpartysystems.ketab.domain.support.NotificationChannelBuilder;
import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;
import org.firstpartysystems.ketab.rest.dto.support.NotificationChannelDtoBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NotificationChannelMapperTest {
	
	@Autowired
	private ModelMapper<NotificationChannel, NotificationChannelDto> notificationChannelMapper;
	
	
	private NotificationChannel singleNotificationChannel;
	private List<NotificationChannel> notificationChannelList;
	private Set<NotificationChannel> notificationChannelSet;
	
	private NotificationChannelDto singleNotificationChannelDto;
	private List<NotificationChannelDto> notificationChannelDtoList;
	private Set<NotificationChannelDto> notificationChannelDtoSet;
	
	@Before
	public void setup(){
		
		singleNotificationChannel = new NotificationChannelBuilder("SMS", "Test", new Date()).id((byte) 1).description("SMS").build();
		singleNotificationChannelDto = new NotificationChannelDtoBuilder("SMS").id((byte) 1).description("SMS").build();
		
		NotificationChannel notificationChannel1 = new NotificationChannelBuilder("EMAIL", "Test", new Date()).id((byte) 2).description("e-mail").build();
		NotificationChannel notificationChannel2 = new NotificationChannelBuilder("SMS_E_MAIL", "Test", new Date()).id((byte) 3).description("SMS & e-mail").build();
		
		NotificationChannelDto notificationChannelDto1 = new NotificationChannelDtoBuilder("EMAIL").id((byte) 2).description("e-mail").build();
		NotificationChannelDto notificationChannelDto2 = new NotificationChannelDtoBuilder("SMS_E_MAIL").id((byte) 3).description("SMS & e-mail").build();
		
		notificationChannelList = new ArrayList<NotificationChannel>();
		
		notificationChannelList.add(notificationChannel1);
		notificationChannelList.add(notificationChannel2);
		
		notificationChannelSet = new HashSet<NotificationChannel>();
		
		notificationChannelSet.add(notificationChannel1);
		notificationChannelSet.add(notificationChannel2);
		
		notificationChannelDtoList = new ArrayList<NotificationChannelDto>();
		
		notificationChannelDtoList.add(notificationChannelDto1);
		notificationChannelDtoList.add(notificationChannelDto2);
		
		notificationChannelDtoSet = new HashSet<NotificationChannelDto>();
		
		notificationChannelDtoSet.add(notificationChannelDto1);
		notificationChannelDtoSet.add(notificationChannelDto2);
	}
	
	@Test
	public void convertSingleToDto_success(){
		
		NotificationChannelDto notificationChannelDto = notificationChannelMapper.convertToDto(singleNotificationChannel);
		
		assertThat(notificationChannelDto.getId()).isEqualTo((byte) 1);
		assertThat(notificationChannelDto.getCode()).isEqualTo("SMS");
		assertThat(notificationChannelDto.getDescription()).isEqualTo("SMS");
		
	}
	
	@Test
	public void convertListToDto_success(){
		
		NotificationChannelDto notificationChannelDto1 = new NotificationChannelDtoBuilder("EMAIL").id((byte) 2).description("e-mail").build();
		NotificationChannelDto notificationChannelDto2 = new NotificationChannelDtoBuilder("SMS_E_MAIL").id((byte) 3).description("SMS & e-mail").build();
		
		List<NotificationChannelDto> expectedNotificationChannelDtos = new ArrayList<NotificationChannelDto>();
		
		expectedNotificationChannelDtos.add(notificationChannelDto1);
		expectedNotificationChannelDtos.add(notificationChannelDto2);
		
		List<NotificationChannelDto> notificationChannelDtos = notificationChannelMapper.convertToDto(notificationChannelList);
		
		assertThat(notificationChannelDtos).isEqualTo(expectedNotificationChannelDtos);
		
	}
	
	@Test
	public void convertSetToDto_success(){
		
		NotificationChannelDto notificationChannelDto1 = new NotificationChannelDtoBuilder("EMAIL").id((byte) 2).description("e-mail").build();
		NotificationChannelDto notificationChannelDto2 = new NotificationChannelDtoBuilder("SMS_E_MAIL").id((byte) 3).description("SMS & e-mail").build();
		
		Set<NotificationChannelDto> expectedNotificationChannelDtos = new HashSet<NotificationChannelDto>();
		
		expectedNotificationChannelDtos.add(notificationChannelDto1);
		expectedNotificationChannelDtos.add(notificationChannelDto2);
		
		Set<NotificationChannelDto> notificationChannelDtos = notificationChannelMapper.convertToDto(notificationChannelSet);
		
		assertThat(notificationChannelDtos).isEqualTo(expectedNotificationChannelDtos);
		
	}
	
	
	@Test
	public void convertSingleToEntity_success(){
		
		NotificationChannel notificationChannel = notificationChannelMapper.convertToEntity(singleNotificationChannelDto);
		
		assertThat(notificationChannel.getId()).isEqualTo((byte) 1);
		assertThat(notificationChannel.getCode()).isEqualTo("SMS");
		assertThat(notificationChannel.getDescription()).isEqualTo("SMS");
		
	}
	
	@Test
	public void convertListToEntity_success(){
		
		NotificationChannel notificationChannel1 = new NotificationChannelBuilder("EMAIL", "Test", new Date()).id((byte) 2).description("e-mail").build();
		NotificationChannel notificationChannel2 = new NotificationChannelBuilder("SMS_E_MAIL", "Test", new Date()).id((byte) 3).description("SMS & e-mail").build();
		
		List<NotificationChannel> expectedNotificationChannels = new ArrayList<NotificationChannel>();
		
		expectedNotificationChannels.add(notificationChannel1);
		expectedNotificationChannels.add(notificationChannel2);
		
		List<NotificationChannel> notificationChannels = notificationChannelMapper.convertToEntity(notificationChannelDtoList);
		
		assertThat(notificationChannels).isEqualTo(expectedNotificationChannels);
		
	}
	
	@Test
	public void convertSetToEntity_success(){
		
		NotificationChannel notificationChannel1 = new NotificationChannelBuilder("EMAIL", "Test", new Date()).id((byte) 2).description("e-mail").build();
		NotificationChannel notificationChannel2 = new NotificationChannelBuilder("SMS_E_MAIL", "Test", new Date()).id((byte) 3).description("SMS & e-mail").build();
		
		Set<NotificationChannel> expectedNotificationChannels = new HashSet<NotificationChannel>();
		
		expectedNotificationChannels.add(notificationChannel1);
		expectedNotificationChannels.add(notificationChannel2);
		
		Set<NotificationChannel> notificationChannels = notificationChannelMapper.convertToEntity(notificationChannelDtoSet);
		
		assertThat(notificationChannels).isEqualTo(expectedNotificationChannels);
		
	}
	
	@Test
	public void convertSingleToNewEntity_success(){
		
		NotificationChannel notificationChannel = notificationChannelMapper.convertToNewEntity(singleNotificationChannelDto);
		
		assertThat(notificationChannel.getId()).isEqualTo(null);
		assertThat(notificationChannel.getCode()).isEqualTo("SMS");
		assertThat(notificationChannel.getDescription()).isEqualTo("SMS");
		
	}
	
	@Test
	public void convertListToNewEntity_success(){
		
		NotificationChannel notificationChannel1 = new NotificationChannelBuilder("EMAIL", "Test", new Date()).id(null).description("e-mail").build();
		NotificationChannel notificationChannel2 = new NotificationChannelBuilder("SMS_E_MAIL", "Test", new Date()).id(null).description("SMS & e-mail").build();
		
		List<NotificationChannel> expectedNotificationChannels = new ArrayList<NotificationChannel>();
		
		expectedNotificationChannels.add(notificationChannel1);
		expectedNotificationChannels.add(notificationChannel2);
		
		List<NotificationChannel> notificationChannels = notificationChannelMapper.convertToEntity(notificationChannelDtoList);
		
		assertThat(notificationChannels).isEqualTo(expectedNotificationChannels);
		
	}
	
	@Test
	public void convertSetToNewEntity_success(){
		
		NotificationChannel notificationChannel1 = new NotificationChannelBuilder("EMAIL", "Test", new Date()).id(null).description("e-mail").build();
		NotificationChannel notificationChannel2 = new NotificationChannelBuilder("SMS_E_MAIL", "Test", new Date()).id(null).description("SMS & e-mail").build();
		
		Set<NotificationChannel> expectedNotificationChannels = new HashSet<NotificationChannel>();
		
		expectedNotificationChannels.add(notificationChannel1);
		expectedNotificationChannels.add(notificationChannel2);
		
		Set<NotificationChannel> notificationChannels = notificationChannelMapper.convertToEntity(notificationChannelDtoSet);
		
		assertThat(notificationChannels).isEqualTo(expectedNotificationChannels);		
		
	}
}
