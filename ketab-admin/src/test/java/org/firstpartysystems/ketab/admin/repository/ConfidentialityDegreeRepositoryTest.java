package org.firstpartysystems.ketab.admin.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.admin.domain.ConfidentialityDegree;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ConfidentialityDegreeRepositoryTest {
	
	private final static byte NumberOfBuiltInDegrees = 7;
	
	
	@Autowired
    private ConfidentialityDegreeRepository repository;
	
	@Before
	public void setup(){
		
	}
	
	@Test
    public void findByIsActive_true_success() {
		
		
        List<ConfidentialityDegree> confidentialityDegrees = this.repository.findByIsActive(true);
        
        assertThat(confidentialityDegrees.size()).isEqualTo(NumberOfBuiltInDegrees);
    }
	
	@Test
    public void findByIsActive_false_success() {
		
		
        List<ConfidentialityDegree> confidentialityDegrees = this.repository.findByIsActive(false);
        
        assertThat(confidentialityDegrees.size()).isEqualTo(1);
    }
	
}
