package org.firstpartysystems.ketab.config.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.domain.Theme;
import org.firstpartysystems.ketab.repository.ThemeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@WebAppConfiguration
@ActiveProfiles("test")
public class ThemeRepositoryTest {

	private final static byte numberOfBuiltInThemes = 3;
	
	@Autowired
    private ThemeRepository repository;
	
	@Test
    public void findByIsActive_true_success() {
		
		
        List<Theme> themes = this.repository.findByIsActive(true);
        
        assertThat(themes.size()).isEqualTo(numberOfBuiltInThemes);
    }
	
	@Test
    public void findByIsActive_false_success() {
		
		
        List<Theme> themes = this.repository.findByIsActive(false);
        
        assertThat(themes.size()).isEqualTo(1);
    }
}
