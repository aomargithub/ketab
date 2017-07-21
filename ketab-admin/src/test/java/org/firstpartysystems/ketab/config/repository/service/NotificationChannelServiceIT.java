package org.firstpartysystems.ketab.config.repository.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.rest.dto.NotificationChannelDto;
import org.firstpartysystems.ketab.service.NotificationChannelService;
import org.firstpartysystems.ketab.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
@Category(IntegrationTest.class)
public class NotificationChannelServiceIT {
	
	private final static byte numberOfTestChannels = 4;
	
	@Autowired
	private NotificationChannelService notificationChannelService;
	
	@Test
    public void getAllActive_success() throws KetabException {
		List<NotificationChannelDto> notificationChannelDtos = notificationChannelService.getAllActive();
		assertThat(notificationChannelDtos.size()).isEqualTo(numberOfTestChannels);
	}
	
}
