package org.firstpartysystems.ketab.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "notification_channel")
public class NotificationChannel extends LookupEntity<Byte>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1786261377930171546L;
	
	@Column(name = "description")
	private String description;
	
	public boolean equals(Object object){
		
		if(object == null){
			return false;
		}
		
		if(!(object instanceof NotificationChannel)){
			return false;
		}
		
		NotificationChannel other = (NotificationChannel) object;
		
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
