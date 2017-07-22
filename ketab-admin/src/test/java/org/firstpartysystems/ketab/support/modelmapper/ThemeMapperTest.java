package org.firstpartysystems.ketab.support.modelmapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.firstpartysystems.ketab.domain.Theme;
import org.firstpartysystems.ketab.domain.support.ThemeBuilder;
import org.firstpartysystems.ketab.rest.dto.ThemeDto;
import org.firstpartysystems.ketab.rest.dto.support.ThemeDtoBuilder;
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
public class ThemeMapperTest {

	
	@Autowired
	private ModelMapper<Theme, ThemeDto> themeMapper;
	
	
	private Theme singleTheme;
	private List<Theme> themeList;
	private Set<Theme> themeSet;
	
	private ThemeDto singleThemeDto;
	private List<ThemeDto> themeDtoList;
	private Set<ThemeDto> themeDtoSet;
	
	@Before
	public void setup(){
		
		singleTheme = new ThemeBuilder("RED", "Test", new Date()).id((byte) 1).description("Red").build();
		singleThemeDto = new ThemeDtoBuilder("RED").id((byte) 1).description("Red").build();
		
		Theme theme1 = new ThemeBuilder("BLUE", "Test", new Date()).id((byte) 2).description("Blue").build();
		Theme theme2 = new ThemeBuilder("GREEN", "Test", new Date()).id((byte) 3).description("Green").build();
		
		ThemeDto themeDto1 = new ThemeDtoBuilder("BLUE").id((byte) 2).description("Blue").build();
		ThemeDto themeDto2 = new ThemeDtoBuilder("GREEN").id((byte) 3).description("Green").build();
		
		themeList = new ArrayList<Theme>();
		
		themeList.add(theme1);
		themeList.add(theme2);
		
		themeSet = new HashSet<Theme>();
		
		themeSet.add(theme1);
		themeSet.add(theme2);
		
		themeDtoList = new ArrayList<ThemeDto>();
		
		themeDtoList.add(themeDto1);
		themeDtoList.add(themeDto2);
		
		themeDtoSet = new HashSet<ThemeDto>();
		
		themeDtoSet.add(themeDto1);
		themeDtoSet.add(themeDto2);
	}
	
	@Test
	public void convertSingleToDto_success(){
		
		ThemeDto themeDto = themeMapper.convertToDto(singleTheme);
		
		assertThat(themeDto.getId()).isEqualTo((byte) 1);
		assertThat(themeDto.getCode()).isEqualTo("RED");
		assertThat(themeDto.getDescription()).isEqualTo("Red");
		
	}
	
	@Test
	public void convertListToDto_success(){
		
		ThemeDto themeDto1 = new ThemeDtoBuilder("BLUE").id((byte) 2).description("Blue").build();
		ThemeDto themeDto2 = new ThemeDtoBuilder("GREEN").id((byte) 3).description("Green").build();
		
		List<ThemeDto> expectedThemeDtos = new ArrayList<ThemeDto>();
		
		expectedThemeDtos.add(themeDto1);
		expectedThemeDtos.add(themeDto2);
		
		List<ThemeDto> themeDtos = themeMapper.convertToDto(themeList);
		
		assertThat(themeDtos).isEqualTo(expectedThemeDtos);
		
	}
	
	@Test
	public void convertSetToDto_success(){
		
		ThemeDto themeDto1 = new ThemeDtoBuilder("BLUE").id((byte) 2).description("Blue").build();
		ThemeDto themeDto2 = new ThemeDtoBuilder("GREEN").id((byte) 3).description("Green").build();
		
		Set<ThemeDto> expectedThemeDtos = new HashSet<ThemeDto>();
		
		expectedThemeDtos.add(themeDto1);
		expectedThemeDtos.add(themeDto2);
		
		Set<ThemeDto> ThemeDtos = themeMapper.convertToDto(themeSet);
		
		assertThat(ThemeDtos).isEqualTo(expectedThemeDtos);
		
	}
	
	
	@Test
	public void convertSingleToEntity_success(){
		
		Theme theme = themeMapper.convertToEntity(singleThemeDto);
		
		assertThat(theme.getId()).isEqualTo((byte) 1);
		assertThat(theme.getCode()).isEqualTo("RED");
		assertThat(theme.getDescription()).isEqualTo("Red");
		
	}
	
	@Test
	public void convertListToEntity_success(){
		
		Theme theme1 = new ThemeBuilder("BLUE", "Test", new Date()).id((byte) 2).description("Blue").build();
		Theme theme2 = new ThemeBuilder("GREEN", "Test", new Date()).id((byte) 3).description("Green").build();
		
		List<Theme> expectedThemeChannels = new ArrayList<Theme>();
		
		expectedThemeChannels.add(theme1);
		expectedThemeChannels.add(theme2);
		
		List<Theme> themeChannels = themeMapper.convertToEntity(themeDtoList);
		
		assertThat(themeChannels).isEqualTo(expectedThemeChannels);
		
	}
	
	@Test
	public void convertSetToEntity_success(){
		
		Theme theme1 = new ThemeBuilder("BLUE", "Test", new Date()).id((byte) 2).description("Blue").build();
		Theme theme2 = new ThemeBuilder("GREEN", "Test", new Date()).id((byte) 3).description("Green").build();
		
		Set<Theme> expectedThemeChannels = new HashSet<Theme>();
		
		expectedThemeChannels.add(theme1);
		expectedThemeChannels.add(theme2);
		
		Set<Theme> themeChannels = themeMapper.convertToEntity(themeDtoSet);
		
		assertThat(themeChannels).isEqualTo(expectedThemeChannels);
		
	}
	
	@Test
	public void convertSingleToNewEntity_success(){
		
		Theme theme = themeMapper.convertToNewEntity(singleThemeDto);
		
		assertThat(theme.getId()).isEqualTo(null);
		assertThat(theme.getCode()).isEqualTo("RED");
		assertThat(theme.getDescription()).isEqualTo("Red");
		
	}
	
	@Test
	public void convertListToNewEntity_success(){
		
		Theme theme1 = new ThemeBuilder("BLUE", "Test", new Date()).id(null).description("Blue").build();
		Theme theme2 = new ThemeBuilder("GREEN", "Test", new Date()).id(null).description("Green").build();
		
		List<Theme> expectedThemeChannels = new ArrayList<Theme>();
		
		expectedThemeChannels.add(theme1);
		expectedThemeChannels.add(theme2);
		
		List<Theme> themeChannels = themeMapper.convertToEntity(themeDtoList);
		
		assertThat(themeChannels).isEqualTo(expectedThemeChannels);
		
	}
	
	@Test
	public void convertSetToNewEntity_success(){
		
		Theme theme1 = new ThemeBuilder("BLUE", "Test", new Date()).id(null).description("Blue").build();
		Theme theme2 = new ThemeBuilder("GREEN", "Test", new Date()).id(null).description("Green").build();
		
		Set<Theme> expectedThemeChannels = new HashSet<Theme>();
		
		expectedThemeChannels.add(theme1);
		expectedThemeChannels.add(theme2);
		
		Set<Theme> themeChannels = themeMapper.convertToEntity(themeDtoSet);
		
		assertThat(themeChannels).isEqualTo(expectedThemeChannels);
		assertThat(themeChannels).allMatch(themeChannel -> themeChannel.getId() == null);
		
	}
}
