package org.firstpartysystems.ketab.admin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.admin.domain.ConfidentialityDegree;
import org.firstpartysystems.ketab.admin.exception.KetabException;
import org.firstpartysystems.ketab.admin.exception.KetabInternalException;
import org.firstpartysystems.ketab.admin.repository.ConfidentialityDegreeRepository;
import org.firstpartysystems.ketab.admin.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.admin.service.ConfidentialityDegreeService;
import org.firstpartysystems.ketab.admin.support.modelmapper.ModelMapper;
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
