package org.firstpartysystems.ketab.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.domain.ConfidentialityDegree;
import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.exception.KetabInternalException;
import org.firstpartysystems.ketab.repository.ConfidentialityDegreeRepository;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.service.ConfidentialityDegreeService;
import org.firstpartysystems.ketab.support.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ConfidentialityDegreeServiceImpl implements ConfidentialityDegreeService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 176638106195488860L;
	private final static Logger logger = Logger.getLogger(ConfidentialityDegreeServiceImpl.class);
	
	
	private ConfidentialityDegreeRepository confidentialityDegreeRepository;
	private ModelMapper<ConfidentialityDegree, ConfidentialityDegreeDto> confidentialityDegreeMapper;
	
	public ConfidentialityDegreeServiceImpl(ConfidentialityDegreeRepository confidentialityDegreeRepository,
			
											ModelMapper<ConfidentialityDegree, ConfidentialityDegreeDto> confidentialityDegreeMapper){
		this.confidentialityDegreeRepository = confidentialityDegreeRepository;
		this.confidentialityDegreeMapper = confidentialityDegreeMapper;
	}
	
	@Override
	public List<ConfidentialityDegreeDto> getAllActive() throws KetabException{
		
		List<ConfidentialityDegreeDto> confidentialityDegreeDtos = null;
		List<ConfidentialityDegree> confidentialityDegrees = null;
		
		try{
			confidentialityDegrees = confidentialityDegreeRepository.findByIsActive(true);
			confidentialityDegreeDtos = confidentialityDegreeMapper.convertToDto(confidentialityDegrees);
		}catch(Exception e){
			throw new KetabInternalException(e);
		}
		
		return confidentialityDegreeDtos;
	}

}
