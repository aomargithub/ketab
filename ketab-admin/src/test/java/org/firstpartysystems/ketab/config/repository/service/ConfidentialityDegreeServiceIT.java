package org.firstpartysystems.ketab.config.repository.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.service.ConfidentialityDegreeService;
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
public class ConfidentialityDegreeServiceIT {
	
	private final static byte numberOfTestDegrees = 8;
	
	@Autowired
    private ConfidentialityDegreeService confidentialityDegreeService;	
	
	
	@Test
    public void getAllActive_success() throws KetabException {
		
		
        List<ConfidentialityDegreeDto> confidentialityDegreeDtos = this.confidentialityDegreeService.getAllActive();
        
        assertThat(confidentialityDegreeDtos.size()).isEqualTo(numberOfTestDegrees);
    }
	
}
