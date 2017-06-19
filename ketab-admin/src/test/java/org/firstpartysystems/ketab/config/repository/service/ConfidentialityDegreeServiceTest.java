package org.firstpartysystems.ketab.config.repository.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.service.ConfidentialityDegreeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class ConfidentialityDegreeServiceTest {
	
	private final static byte numberOfBuiltInDegrees = 8;
	
	@Autowired
    private ConfidentialityDegreeService confidentialityDegreeService;
	
	
	@Test
    public void getAllActive_success() throws KetabException {
		
		
        List<ConfidentialityDegreeDto> confidentialityDegreeDtos = this.confidentialityDegreeService.getAllActive();
        
        assertThat(confidentialityDegreeDtos.size()).isEqualTo(numberOfBuiltInDegrees);
    }
}
