package org.firstpartysystems.ketab.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreateUpdateLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243886518617254306L;
	
	@Column(name = "create_by", updatable = false)
	private String createBy;
	
	@Column(name = "create_date", updatable = false)
	private Date createDate;
	
	@Column(name = "update_by", insertable = false)
	private String updateBy;
	
	@Column(name = "update_date", insertable = false)
	private Date updateDate;
	
	public CreateUpdateLog(){
		
	}
	
	
	public CreateUpdateLog(String createBy, Date createDate){
		this.createBy = createBy;
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
