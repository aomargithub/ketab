package org.firstpartysystems.ketab.admin.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.firstpartysystems.ketab.admin.exception.KetabException;
import org.firstpartysystems.ketab.admin.rest.dto.ConfidentialityDegreeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ConfidentialityDegreeServiceTest {
	
	private final static byte NumberOfBuiltInDegrees = 7;
	
	@Autowired
    private ConfidentialityDegreeService confidentialityDegreeService;
	
	
	@Test
    public void getAllActive_success() throws KetabException {
		
		
        List<ConfidentialityDegreeDto> confidentialityDegreeDtos = this.confidentialityDegreeService.getAllActive();
        
        assertThat(confidentialityDegreeDtos.size()).isEqualTo(NumberOfBuiltInDegrees);
    }
}
