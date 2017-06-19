package org.firstpartysystems.ketab.support.modelmapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnitUtil;

import org.apache.log4j.Logger;
import org.firstpartysystems.ketab.domain.AbstractDomainModel;
import org.firstpartysystems.ketab.rest.dto.AbstractUserModel;
import org.hibernate.proxy.HibernateProxy;

public abstract class AbstractModelMapper<E extends AbstractDomainModel<?>, D extends AbstractUserModel<?>> implements ModelMapper<E, D>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5171542953876089724L;
	private final static Logger logger = Logger.getLogger(AbstractModelMapper.class);
	
	
	@PersistenceUnit
	private EntityManagerFactory entityMangerFactory;
	
	protected abstract E convertToEntity(D dto, boolean nullId);
	
	public boolean isConvertable(Collection<?> collection){
		return collection != null && !collection.isEmpty();
	}
	
	public boolean isConvertable(D dto){
		return dto != null;
	}
	
	public boolean isConvertable(E entity){
		if (entity != null) {
			if(HibernateProxy.class.isInstance(entity)){
				HibernateProxy proxy = HibernateProxy.class.cast(entity);				
				if (!proxy.getHibernateLazyInitializer().isUninitialized()) {
					return true;
				}
			}else{
				return true;
			}
		}
		return false;
	}
	
	protected  boolean isConvertable(Object entity, String attributeName){
		PersistenceUnitUtil unitUtil = entityMangerFactory.getPersistenceUnitUtil();
		return unitUtil.isLoaded(entity, attributeName);
	}
	
	@Override
	public List<D> convertToDto(List<E> entities){
		List<D> dtos = null;
		
		if(isConvertable(entities)){
			dtos = new ArrayList<D>();
			
			for(E e : entities){
				dtos.add(convertToDto(e));
			}
		}
		return dtos;
	}
	
	@Override
	public Set<D> convertToDto(Set<E> entities){
		Set<D> dtos = null;
		
		if(isConvertable(entities)){
			dtos = new HashSet<D>();
			
			for(E e : entities){
				dtos.add(convertToDto(e));
			}
		}
		return dtos;
	}
	
	
	
	@Override
	public E convertToEntity(D dto){
		return convertToEntity(dto, false);
	}
	
	@Override
	public List<E> convertToEntity(List<D> dtos){
		List<E> entities = null;
		
		if(isConvertable(dtos)){
			entities = new ArrayList<E>();
			
			for(D dto : dtos){
				entities.add(convertToEntity(dto));
			}
		}
		
		return entities;
	}
	
	@Override
	public Set<E> convertToEntity(Set<D> dtos){
		Set<E> entities = null;
		
		if(isConvertable(dtos)){
			entities = new HashSet<E>();
			
			for(D dto : dtos){
				entities.add(convertToEntity(dto));
			}
		}
		
		return entities;
	}
	
	@Override
	public E convertToNewEntity(D dto){
		return convertToEntity(dto, true);
	}
	
	@Override
	public List<E> convertToNewEntity(List<D> dtos){
		List<E> entities = null;
		
		if(isConvertable(dtos)){
			entities = new ArrayList<E>();
			
			for(D dto : dtos){
				entities.add(convertToNewEntity(dto));
			}
		}
		
		return entities;
	}
	
	@Override
	public Set<E> convertToNewEntity(Set<D> dtos){
		Set<E> entities = null;
		
		if(isConvertable(dtos)){
			entities = new HashSet<E>();
			
			for(D dto : dtos){
				entities.add(convertToNewEntity(dto));
			}
		}
		
		return entities;
	}
}
