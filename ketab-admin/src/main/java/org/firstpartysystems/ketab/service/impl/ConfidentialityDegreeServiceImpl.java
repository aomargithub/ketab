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
import org.springframework.transaction.annotation.Transactional;

/**
 * Handles all of the business related to Confidentiality Degrees
 * 
 * 
 * @author Ahmad Omar
 *
 */

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
	
	/**
	 * Fetching all active {@link org.firstpartysystems.ketab.domain.ConfidentialityDegree} from the DB
	 * using isActive flag, then converting them to {@link org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto} using 
	 * {@link org.firstpartysystems.ketab.support.modelmapper.ConfidentialityDegreeMapper}
	 * 
	 * @return a {@link java.util.List} List of all of active {@link org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto}
	 * @throws {@link org.firstpartysystems.ketab.exception.KetabException} in case of any kind of processing failure
	 */
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ConfidentialityDegreeDto> getAllActive() throws KetabException{
		
		List<ConfidentialityDegreeDto> confidentialityDegreeDtos = null;
		List<ConfidentialityDegree> confidentialityDegrees = null;
		
		try{
			
			if(logger.isDebugEnabled()){
				logger.debug("Getting all active Confidentiality Degrees by querying the DB ... ");
			}
			
			confidentialityDegrees = confidentialityDegreeRepository.findByIsActive(true);
			
			if(logger.isDebugEnabled()){
				logger.debug("Got " + confidentialityDegrees.size() + " Confidentiality Degrees from the DB" );
				logger.debug("Converting the result to DTO ..." );
			}
			
			confidentialityDegreeDtos = confidentialityDegreeMapper.convertToDto(confidentialityDegrees);
			
			if(logger.isDebugEnabled()){
				logger.debug("Result converted." );
			}
			
			
		}catch(Exception e){
			throw new KetabInternalException(e);
		}
		
		return confidentialityDegreeDtos;
	}

}
