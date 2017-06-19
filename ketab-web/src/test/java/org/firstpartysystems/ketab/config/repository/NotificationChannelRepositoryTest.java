package org.firstpartysystems.ketab.config.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.domain.NotificationChannel;
import org.firstpartysystems.ketab.repository.NotificationChannelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class NotificationChannelRepositoryTest {

	private final static byte numberOfBuiltInChannels = 4;
	
	
	@Autowired
    private NotificationChannelRepository repository;
	
	@Before
	public void setup(){
		
	}
	
	@Test
    public void findByIsActive_true_success() {
		
		
        List<NotificationChannel> notificationChannels = this.repository.findByIsActive(true);
        
        assertThat(notificationChannels.size()).isEqualTo(numberOfBuiltInChannels);
    }
	
	@Test
    public void findByIsActive_false_success() {
		
		
        List<NotificationChannel> notificationChannels = this.repository.findByIsActive(false);
        
        assertThat(notificationChannels.size()).isEqualTo(1);
    }
}
