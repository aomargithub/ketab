package org.firstpartysystems.ketab.support.modelmapper;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.firstpartysystems.ketab.domain.ConfidentialityDegree;
import org.firstpartysystems.ketab.domain.support.ConfidentialityDegreeBuilder;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.rest.dto.support.ConfidentialityDegreeDtoBuilder;
import org.junit.Before;
import org.junit.Test;
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
public class ConfidentialityDegreeMapperTest {
	
	@Autowired
	private ModelMapper<ConfidentialityDegree, ConfidentialityDegreeDto> confidentialityDegreeMapper;
	
	private ConfidentialityDegree singleConfidentialityDegree;
	private List<ConfidentialityDegree> confidentialityDegreeList;
	private Set<ConfidentialityDegree> confidentialityDegreeSet;
	
	private ConfidentialityDegreeDto singleConfidentialityDegreeDto;
	private List<ConfidentialityDegreeDto> confidentialityDegreeDtoList;
	private Set<ConfidentialityDegreeDto> confidentialityDegreeDtoSet;
	
	@Before
	public void setup(){
		
		singleConfidentialityDegree = new ConfidentialityDegreeBuilder("TSEC", "Test", new Date()).id((byte) 1).precedence((byte) 0).description("Top Secret").build();
		singleConfidentialityDegreeDto = new ConfidentialityDegreeDtoBuilder("TSEC").id((byte) 1).precedence((byte) 0).description("Top Secret").build();
		
		ConfidentialityDegree confidentialityDegree1 = new ConfidentialityDegreeBuilder("SEC", "Test", new Date()).id((byte) 2).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegree confidentialityDegree2 = new ConfidentialityDegreeBuilder("CONF", "Test", new Date()).id((byte) 3).precedence((byte) 0).description("Confidential").build();
		
		ConfidentialityDegreeDto confidentialityDegreeDto1 = new ConfidentialityDegreeDtoBuilder("SEC").id((byte) 2).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegreeDto confidentialityDegreeDto2 = new ConfidentialityDegreeDtoBuilder("CONF").id((byte) 3).precedence((byte) 0).description("Confidential").build();
		
		confidentialityDegreeList = new ArrayList<ConfidentialityDegree>();
		
		confidentialityDegreeList.add(confidentialityDegree1);
		confidentialityDegreeList.add(confidentialityDegree2);
		
		confidentialityDegreeSet = new HashSet<ConfidentialityDegree>();
		
		confidentialityDegreeSet.add(confidentialityDegree1);
		confidentialityDegreeSet.add(confidentialityDegree2);
		
		confidentialityDegreeDtoList = new ArrayList<ConfidentialityDegreeDto>();
		
		confidentialityDegreeDtoList.add(confidentialityDegreeDto1);
		confidentialityDegreeDtoList.add(confidentialityDegreeDto2);
		
		confidentialityDegreeDtoSet = new HashSet<ConfidentialityDegreeDto>();
		
		confidentialityDegreeDtoSet.add(confidentialityDegreeDto1);
		confidentialityDegreeDtoSet.add(confidentialityDegreeDto2);
	}
	
	@Test
	public void convertSingleToDto_success(){
		
		ConfidentialityDegreeDto confidentialityDegreeDto = confidentialityDegreeMapper.convertToDto(singleConfidentialityDegree);
		
		assertThat(confidentialityDegreeDto.getId()).isEqualTo((byte) 1);
		assertThat(confidentialityDegreeDto.getCode()).isEqualTo("TSEC");
		assertThat(confidentialityDegreeDto.getPrecedence()).isEqualTo((byte) 0);
		assertThat(confidentialityDegreeDto.getDescription()).isEqualTo("Top Secret");
		
	}
	
	@Test
	public void convertListToDto_success(){
		
		ConfidentialityDegreeDto confidentialityDegreeDto1 = new ConfidentialityDegreeDtoBuilder("SEC").id((byte) 2).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegreeDto confidentialityDegreeDto2 = new ConfidentialityDegreeDtoBuilder("CONF").id((byte) 3).precedence((byte) 0).description("Confidential").build();
		
		List<ConfidentialityDegreeDto> expectedConfidentialityDegreeDtos = new ArrayList<ConfidentialityDegreeDto>();
		
		expectedConfidentialityDegreeDtos.add(confidentialityDegreeDto1);
		expectedConfidentialityDegreeDtos.add(confidentialityDegreeDto2);
		
		List<ConfidentialityDegreeDto> confidentialityDegreeDtos = confidentialityDegreeMapper.convertToDto(confidentialityDegreeList);
		
		assertThat(confidentialityDegreeDtos).isEqualTo(expectedConfidentialityDegreeDtos);
		
	}
	
	@Test
	public void convertSetToDto_success(){
		ConfidentialityDegreeDto confidentialityDegreeDto1 = new ConfidentialityDegreeDtoBuilder("SEC").id((byte) 2).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegreeDto confidentialityDegreeDto2 = new ConfidentialityDegreeDtoBuilder("CONF").id((byte) 3).precedence((byte) 0).description("Confidential").build();
		
		Set<ConfidentialityDegreeDto> expectedConfidentialityDegreeDtos = new HashSet<ConfidentialityDegreeDto>();
		
		expectedConfidentialityDegreeDtos.add(confidentialityDegreeDto1);
		expectedConfidentialityDegreeDtos.add(confidentialityDegreeDto2);
		
		Set<ConfidentialityDegreeDto> confidentialityDegreeDtos = confidentialityDegreeMapper.convertToDto(confidentialityDegreeSet);
		
		assertThat(confidentialityDegreeDtos).isEqualTo(expectedConfidentialityDegreeDtos);		
		
	}
	
	
	@Test
	public void convertSingleToEntity_success(){
		
		ConfidentialityDegree confidentialityDegree = confidentialityDegreeMapper.convertToEntity(singleConfidentialityDegreeDto);
		
		assertThat(confidentialityDegree.getId()).isEqualTo((byte) 1);
		assertThat(confidentialityDegree.getCode()).isEqualTo("TSEC");
		assertThat(confidentialityDegree.getPrecedence()).isEqualTo((byte) 0);
		assertThat(confidentialityDegree.getDescription()).isEqualTo("Top Secret");
		
	}
	
	@Test
	public void convertListToEntity_success(){
		
		ConfidentialityDegree confidentialityDegree1 = new ConfidentialityDegreeBuilder("SEC", "Test", new Date()).id((byte) 2).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegree confidentialityDegree2 = new ConfidentialityDegreeBuilder("CONF", "Test", new Date()).id((byte) 3).precedence((byte) 0).description("Confidential").build();
		
		List<ConfidentialityDegree> expectedConfidentialityDegrees = new ArrayList<ConfidentialityDegree>();
		
		expectedConfidentialityDegrees.add(confidentialityDegree1);
		expectedConfidentialityDegrees.add(confidentialityDegree2);
		
		List<ConfidentialityDegree> confidentialityDegrees = confidentialityDegreeMapper.convertToEntity(confidentialityDegreeDtoList);
		
		assertThat(confidentialityDegrees).isEqualTo(expectedConfidentialityDegrees);
		
	}
	
	@Test
	public void convertSetToEntity_success(){
		ConfidentialityDegree confidentialityDegree1 = new ConfidentialityDegreeBuilder("SEC", "Test", new Date()).id((byte) 2).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegree confidentialityDegree2 = new ConfidentialityDegreeBuilder("CONF", "Test", new Date()).id((byte) 3).precedence((byte) 0).description("Confidential").build();
		
		Set<ConfidentialityDegree> expectedConfidentialityDegrees = new HashSet<ConfidentialityDegree>();
		
		expectedConfidentialityDegrees.add(confidentialityDegree1);
		expectedConfidentialityDegrees.add(confidentialityDegree2);
		
		Set<ConfidentialityDegree> confidentialityDegrees = confidentialityDegreeMapper.convertToEntity(confidentialityDegreeDtoSet);
		
		assertThat(confidentialityDegrees).isEqualTo(expectedConfidentialityDegrees);		
		
	}
	
	@Test
	public void convertSingleToNewEntity_success(){
		
		ConfidentialityDegree confidentialityDegree = confidentialityDegreeMapper.convertToNewEntity(singleConfidentialityDegreeDto);
		
		assertThat(confidentialityDegree.getId()).isEqualTo(null);
		assertThat(confidentialityDegree.getCode()).isEqualTo("TSEC");
		assertThat(confidentialityDegree.getPrecedence()).isEqualTo((byte) 0);
		assertThat(confidentialityDegree.getDescription()).isEqualTo("Top Secret");
		
	}
	
	@Test
	public void convertListToNewEntity_success(){
		
		ConfidentialityDegree confidentialityDegree1 = new ConfidentialityDegreeBuilder("SEC", "Test", new Date()).id(null).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegree confidentialityDegree2 = new ConfidentialityDegreeBuilder("CONF", "Test", new Date()).id(null).precedence((byte) 0).description("Confidential").build();
		
		List<ConfidentialityDegree> expectedConfidentialityDegrees = new ArrayList<ConfidentialityDegree>();
		
		expectedConfidentialityDegrees.add(confidentialityDegree1);
		expectedConfidentialityDegrees.add(confidentialityDegree2);
		
		List<ConfidentialityDegree> confidentialityDegrees = confidentialityDegreeMapper.convertToNewEntity(confidentialityDegreeDtoList);
		
		assertThat(confidentialityDegrees).isEqualTo(expectedConfidentialityDegrees);
		
	}
	
	@Test
	public void convertSetToNewEntity_success(){
		
		ConfidentialityDegree confidentialityDegree1 = new ConfidentialityDegreeBuilder("SEC", "Test", new Date()).id(null).precedence((byte) 0).description("Secret").build();
		ConfidentialityDegree confidentialityDegree2 = new ConfidentialityDegreeBuilder("CONF", "Test", new Date()).id(null).precedence((byte) 0).description("Confidential").build();
		
		Set<ConfidentialityDegree> expectedConfidentialityDegrees = new HashSet<ConfidentialityDegree>();
		
		expectedConfidentialityDegrees.add(confidentialityDegree1);
		expectedConfidentialityDegrees.add(confidentialityDegree2);
		
		Set<ConfidentialityDegree> confidentialityDegrees = confidentialityDegreeMapper.convertToNewEntity(confidentialityDegreeDtoSet);
		
		assertThat(confidentialityDegrees).isEqualTo(expectedConfidentialityDegrees);		
		
	}

}
