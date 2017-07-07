package com.rifat.vnoticeboard.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<ID> {
	
	@Version
	private Long version;
	
	@Column(name="created_date" ,nullable= false)
	private Date createDate;
	
	@Column(name="last_modified_date" ,nullable= false)
	private Date lastmodifiedDate;
	
	public abstract ID getID();

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastmodifiedDate() {
		return lastmodifiedDate;
	}

	public void setLastmodifiedDate(Date lastmodifiedDate) {
		this.lastmodifiedDate = lastmodifiedDate;
	}
	
	@PrePersist
	public void prePersist () 
	{
		this.createDate=new Date();
		this.lastmodifiedDate=new Date();
		
	}
	@PreUpdate
	public void preUpdate()
	{
		this.lastmodifiedDate=new Date();
	}

}
