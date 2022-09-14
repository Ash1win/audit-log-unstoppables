package com.hansen.auditlog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hansen.auditlog.model.Auditlog;

public interface AuditlogDao extends PagingAndSortingRepository<Auditlog, Long>  {
	public Iterable<Auditlog> findByOperationTypeContaining(String text);
	public Iterable<Auditlog> findByEntityJsonContaining(String text);
}
