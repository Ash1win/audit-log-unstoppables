package com.hansen.auditlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansen.auditlog.dao.AuditlogDao;
import com.hansen.auditlog.model.Auditlog;

@Service
public class AuditlogService {
	
	@Autowired
	AuditlogDao auditlogDao;
	
	public Object create(Auditlog entity) {
		Auditlog auditlog = auditlogDao.save(entity);
		return auditlog;
	}
	
	public Iterable<Auditlog> readAll() {
		Iterable<Auditlog> audList = auditlogDao.findAll();
		return audList;
	}
	
	public Iterable<Auditlog> searchByOperationType(String text) {
		Iterable<Auditlog> audList = auditlogDao.findByOperationTypeContaining(text);
		return audList;
	}
	
	public Iterable<Auditlog> searchByEntityJson(String text) {
		Iterable<Auditlog> audList = auditlogDao.findByEntityJsonContaining(text);
		return audList;
	}
	
	public Iterable<Auditlog> searchById(String id) {
		String query = ""+id+",";
		Iterable<Auditlog> audList = auditlogDao.findByEntityJsonContaining(query);
		return audList;
	}
	
}
