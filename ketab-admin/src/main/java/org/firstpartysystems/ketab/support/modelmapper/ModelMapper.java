package org.firstpartysystems.ketab.support.modelmapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.firstpartysystems.ketab.domain.DomainModel;
import org.firstpartysystems.ketab.rest.dto.UserModel;

/**
 * 
 * @author Ahmad Omar
 *
 */
public interface ModelMapper<E extends DomainModel<?>, D extends UserModel<?>> extends Serializable{
	
	
	D convertToDto(E entity);
	List<D> convertToDto(List<E> entities);
	Set<D> convertToDto(Set<E> entities);
	
	E convertToEntity(D dto);
	List<E> convertToEntity(List<D> dtos);
	Set<E> convertToEntity(Set<D> dtos);

	
	E convertToNewEntity(D dto);
	List<E> convertToNewEntity(List<D> dtos);
	Set<E> convertToNewEntity(Set<D> dtos);
}
