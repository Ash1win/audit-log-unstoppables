package com.hansen.auditlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansen.auditlog.dao.AuditlogDao;
import com.hansen.auditlog.model.Auditlog;

@Service
public class AuditlogService {
	
	@Autowired
	AuditlogDao auditlogDao;
	
	//create
	public Object create(Auditlog entity) {
		Auditlog auditlog = auditlogDao.save(entity);
		return auditlog;
	}
	
	//get all
	public Iterable<Auditlog> readAll() {
		Iterable<Auditlog> audList = auditlogDao.findAll();
		return audList;
	}
	
	//search by Operation Type
	public Iterable<Auditlog> searchByOperationType(String text) {
		Iterable<Auditlog> audList = auditlogDao.findByOperationTypeContaining(text);
		return audList;
	}
	
	//search by Entity Json
	public Iterable<Auditlog> searchByEntityJson(String text) {
		Iterable<Auditlog> audList = auditlogDao.findByEntityJsonContaining(text);
		return audList;
	}
	
	//search by Id
	public Iterable<Auditlog> searchById(String id) {
		String query = ""+id+",";
		Iterable<Auditlog> audList = auditlogDao.findByEntityJsonContaining(query);
		return audList;
	}
	
}
