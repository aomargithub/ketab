package org.firstpartysystems.ketab.admin.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.admin.domain.Theme;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ThemeRepositoryTest {

	private final static byte NumberOfBuiltInThemes = 3;
	
	@Autowired
    private ThemeRepository repository;
	
	@Test
    public void findByIsActive_true_success() {
		
		
        List<Theme> themes = this.repository.findByIsActive(true);
        
        assertThat(themes.size()).isEqualTo(NumberOfBuiltInThemes);
    }
	
	@Test
    public void findByIsActive_false_success() {
		
		
        List<Theme> themes = this.repository.findByIsActive(false);
        
        assertThat(themes.size()).isEqualTo(1);
    }
}
