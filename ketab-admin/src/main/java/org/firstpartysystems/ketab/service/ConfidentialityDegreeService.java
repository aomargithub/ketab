package org.firstpartysystems.ketab.service;

import java.io.Serializable;
import java.util.List;

import org.firstpartysystems.ketab.exception.KetabException;
import org.firstpartysystems.ketab.rest.dto.ConfidentialityDegreeDto;


public interface ConfidentialityDegreeService extends Serializable{

	List<ConfidentialityDegreeDto> getAllActive() throws KetabException;

}
