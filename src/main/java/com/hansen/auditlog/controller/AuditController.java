package com.hansen.auditlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hansen.auditlog.model.Auditlog;
import com.hansen.auditlog.service.AuditlogService;


@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/ac")
public class AuditController {
	
	@Autowired
	AuditlogService adSrvc;
	
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Auditlog inputEntity) {
		
		ResponseEntity<Object> mpResponse;
		
		System.out.println(inputEntity.toString());
		
		Object auditLog = adSrvc.create(inputEntity);
		
		if(auditLog != null) {
			mpResponse = new ResponseEntity<Object>(auditLog, null, HttpStatus.OK);
		}else {
			mpResponse = new ResponseEntity<Object>(auditLog, null, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return mpResponse;
	}
	
	
	//GET ALL
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		ResponseEntity<Object> mpResponse;
		Iterable<Auditlog> audList = adSrvc.readAll();
		
		if(audList != null) {
			mpResponse = new ResponseEntity<Object>(audList, null, HttpStatus.OK);
		}else {
			mpResponse = new ResponseEntity<Object>(audList, null, HttpStatus.NOT_FOUND);
		}
		
		return mpResponse;
		
	}
	
	
	//GET BY ID, OPERATION, ENTITY
	@RequestMapping(method = RequestMethod.GET, path = "/search")
	public ResponseEntity<Object> searchBOT(@RequestParam String text, @RequestParam String type) {
		
		ResponseEntity<Object> mpResponse;
		
		Iterable<Auditlog> audList=null;
		
		System.out.println("type: "+type);
		
		if(type.equalsIgnoreCase("operation")) {
			audList = adSrvc.searchByOperationType(text);
			System.out.println(text);
			
		}else if(type.equalsIgnoreCase("entity")) {
			audList = adSrvc.searchByEntityJson(text);
			
		}else if(type.equalsIgnoreCase("id")){
			audList = adSrvc.searchById(text);
		}
		
		
		if(audList != null) {
			mpResponse = new ResponseEntity<Object>(audList, null, HttpStatus.OK);
		}else {
			mpResponse = new ResponseEntity<Object>(audList, null, HttpStatus.NOT_FOUND);
		}
		
		return mpResponse;
		
	}
	
	
}
