package org.firstpartysystems.ketab.rest.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author Ahmad Omar
 *
 */
public class NotificationChannelDto extends LookupDto<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1953687407623218328L;
	
	private String description;
	
	
	public boolean equals(Object object){
		
		if(object == null){
			return false;
		}
		
		if(!(object instanceof NotificationChannelDto)){
			return false;
		}
		
		NotificationChannelDto other = (NotificationChannelDto) object;
		
		return new EqualsBuilder().append(getCode(), other.getCode()).isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder().append(getCode()).hashCode();
	}
	
	public String toString(){
		return new ToStringBuilder(this).append(getId()).append(getCode()).append(getDescription()).toString();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
