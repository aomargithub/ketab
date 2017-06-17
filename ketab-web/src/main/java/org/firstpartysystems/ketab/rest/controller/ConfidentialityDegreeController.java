package org.firstpartysystems.ketab.rest.controller;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;
import org.firstpartysystems.ketab.rest.response.RestResponse;
import org.firstpartysystems.ketab.service.ConfidentialityDegreeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confidentialityDegrees")
public class ConfidentialityDegreeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9125253583416080391L;
	private final static Logger logger = Logger.getLogger(ConfidentialityDegreeController.class);

	
	private ConfidentialityDegreeService confidentialityDegreeService;
	
	
	public ConfidentialityDegreeController(ConfidentialityDegreeService confidentialityDegreeService){
		this.confidentialityDegreeService = confidentialityDegreeService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public RestResponse getAll() throws Exception {
		RestResponse restResponse = null;
		List<ConfidentialityDegreeDto> confidentialityDegreeDtos = null;
		
		confidentialityDegreeDtos = confidentialityDegreeService.getAllActive();
		restResponse = new RestResponse(confidentialityDegreeDtos);
		return restResponse;
	}
}
