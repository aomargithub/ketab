package org.firstpartysystems.ketab.config.repository.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.firstpartysystems.ketab.domain.ConfidentialityDegree;
import org.firstpartysystems.ketab.domain.support.ConfidentialityDegreeBuilder;
import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.repository.ConfidentialityDegreeRepository;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.rest.dto.support.ConfidentialityDegreeDtoBuilder;
import org.firstpartysystems.ketab.service.ConfidentialityDegreeService;
import org.firstpartysystems.ketab.service.impl.ConfidentialityDegreeServiceImpl;
import org.firstpartysystems.ketab.support.modelmapper.ModelMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@WebAppConfiguration
@ActiveProfiles("test")
public class ConfidentialityDegreeServiceTest {
	
	private final static byte numberOfTestDegrees = 2;
	
	
	@Mock
	private ConfidentialityDegreeRepository confidentialityDegreeRepository;
	
	@Mock
	private ModelMapper<ConfidentialityDegree, ConfidentialityDegreeDto> confidentialityDegreeMapper;
	
	@InjectMocks
    private ConfidentialityDegreeService confidentialityDegreeService = new ConfidentialityDegreeServiceImpl(confidentialityDegreeRepository, confidentialityDegreeMapper);
	
	
	@Before
	public void setup(){
		
		 MockitoAnnotations.initMocks(this);
		
		ConfidentialityDegree confidentialityDegree1 = new ConfidentialityDegreeBuilder("SEC", "Test", new Date()).build();
		ConfidentialityDegree confidentialityDegree2 = new ConfidentialityDegreeBuilder("TSEC", "Test", new Date()).build();
		
		ConfidentialityDegreeDto confidentialityDegreeDto1 = new ConfidentialityDegreeDtoBuilder("SEC").build();
		ConfidentialityDegreeDto confidentialityDegreeDto2 = new ConfidentialityDegreeDtoBuilder("TSEC").build();
		
		List<ConfidentialityDegree> confidentialityDegrees = new ArrayList<ConfidentialityDegree>();
		List<ConfidentialityDegreeDto> confidentialityDegreeDtos = new ArrayList<ConfidentialityDegreeDto>();
		
		
		confidentialityDegrees.add(confidentialityDegree1);
		confidentialityDegrees.add(confidentialityDegree2);
		
		confidentialityDegreeDtos.add(confidentialityDegreeDto1);
		confidentialityDegreeDtos.add(confidentialityDegreeDto2);
		
		Mockito.when(confidentialityDegreeRepository.findByIsActive(true)).thenReturn(confidentialityDegrees);
		Mockito.when(confidentialityDegreeMapper.convertToDto(confidentialityDegrees)).thenReturn(confidentialityDegreeDtos);
	}
	
	@Test
    public void getAllActive_success() throws KetabException {
		
		
        List<ConfidentialityDegreeDto> confidentialityDegreeDtos = this.confidentialityDegreeService.getAllActive();
        
        assertThat(confidentialityDegreeDtos.size()).isEqualTo(numberOfTestDegrees);
    }
}
