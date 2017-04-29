package org.firstpartysystems.ketab.admin.support.modelmapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.firstpartysystems.ketab.admin.domain.DomainModel;
import org.firstpartysystems.ketab.admin.rest.dto.UserModel;

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
