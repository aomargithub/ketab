package org.firstpartysystems.ketab.admin.service;

import java.io.Serializable;
import java.util.List;

import org.firstpartysystems.ketab.admin.exception.KetabException;
import org.firstpartysystems.ketab.admin.rest.dto.ConfidentialityDegreeDto;


public interface ConfidentialityDegreeService extends Serializable{

	List<ConfidentialityDegreeDto> getAllActive() throws KetabException;

}
