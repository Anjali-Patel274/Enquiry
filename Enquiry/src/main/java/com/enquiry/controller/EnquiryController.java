package com.enquiry.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enquiry.entity.Enquiry;
import com.enquiry.entity.EnquiryType;
import com.enquiry.service.EnquiryServiceImpl;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*; 



import com.enquiry.exception.ResourceNotFoundException;

@RestController 
@RequestMapping(value="/enquiry")
public class EnquiryController {
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	
	
		@Autowired
		private EnquiryServiceImpl service;
	
		
		// get enquiry types   
		@GetMapping(value="/enquirytype")
		public ResponseEntity<List<EnquiryType>> getAllEnquiryTypes()
		{
			LOGGER.log(Level.INFO, "EnquiryType"); 
			List<EnquiryType> enquirytype=service.getAllEnquiryTypes();	
			return new ResponseEntity<List<EnquiryType>>(enquirytype,HttpStatus.OK);	
		}
		
		// add an enquiry
		@PostMapping(value="/add")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<String> save(@Valid @RequestBody Enquiry enquiry)
		{
			Enquiry enq=service.addQuery(enquiry);
			return new ResponseEntity<String>("Query Added Successfully ",HttpStatus.OK);	
		}
		
		//view response/query
		@GetMapping(value="/viewAll")
		public ResponseEntity<List<Enquiry>> getAllQueries()
		{
			List<Enquiry> enquiry=service.viewAll();	
			return new ResponseEntity<List<Enquiry>>(enquiry,HttpStatus.OK);	
		}
		
		// get details by email ID
		@RequestMapping(value = "/mail/{mail}")
		public ResponseEntity findByMail(@PathVariable String mail) 
		{
			List<Enquiry> enquiry = service.findByMail(mail);
			if(enquiry.isEmpty())
			{
				throw new ResourceNotFoundException("Email Id "+mail+" is not registered or you have entered wrong details ");
			}
			return  ResponseEntity.ok(enquiry);
		}
		
		// get details by phone number
		@RequestMapping(value = "/phone/{phone}")
		public ResponseEntity findByPhone(@PathVariable String phone) 
		{
			List<Enquiry> enquiry = service.findByPhone(phone);
			if(enquiry.isEmpty())
			{
				throw new ResourceNotFoundException("Phone number "+phone+" is not registered or you have entered wrong details ");
			}
			
			
			
			return  ResponseEntity.ok(enquiry);
		}
		
		//update response
		@PatchMapping(value="/update/{id}")
		@ResponseStatus(HttpStatus.ACCEPTED)
		public Enquiry update( @RequestBody Map<String,String> updateData, @PathVariable long id)
		{	
			Enquiry enquiry = service.addResponse(updateData, id);
		
			return enquiry;
		}

}
