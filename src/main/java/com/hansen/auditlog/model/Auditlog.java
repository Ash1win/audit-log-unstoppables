package com.hansen.auditlog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Auditlog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String operationType;
	private String entityJson;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	
	//getter-setters
	
	//Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//operationType
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	//entityJson
	public String getEntityJson() {
		return entityJson;
	}
	public void setEntityJson(String entityJson) {
		this.entityJson = entityJson;
	}
	
	//modificationDate
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}	
	
}
