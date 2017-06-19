package org.firstpartysystems.ketab.config.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.domain.ConfidentialityDegree;
import org.firstpartysystems.ketab.repository.ConfidentialityDegreeRepository;
import org.junit.Before;
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
public class ConfidentialityDegreeRepositoryTest {
	
	private final static byte numberOfBuiltInDegrees = 8;
	
	
	@Autowired
    private ConfidentialityDegreeRepository repository;
	
	@Before
	public void setup(){
		
	}
	
	@Test
    public void findByIsActive_true_success() {
		
		
        List<ConfidentialityDegree> confidentialityDegrees = this.repository.findByIsActive(true);
        
        assertThat(confidentialityDegrees.size()).isEqualTo(numberOfBuiltInDegrees);
    }
	
	@Test
    public void findByIsActive_false_success() {
		
		
        List<ConfidentialityDegree> confidentialityDegrees = this.repository.findByIsActive(false);
        
        assertThat(confidentialityDegrees.size()).isEqualTo(1);
    }
	
}
