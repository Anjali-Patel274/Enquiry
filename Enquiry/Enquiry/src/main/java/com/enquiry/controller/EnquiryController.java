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
import com.enquiry.exception.ResourceNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

@RestController 
@RequestMapping(value="/enquiry")
public class EnquiryController {
	
		@Autowired
		private EnquiryServiceImpl service;
		
		public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
		// get enquiry types   
		@GetMapping(value="/enquirytype")
		public ResponseEntity<List<EnquiryType>> getAllEnquiryTypes()
		{
			LOGGER.log(Level.INFO, "Enquiry Type Table:");
			List<EnquiryType> enquirytype=service.getAllEnquiryTypes();	
			return new ResponseEntity<List<EnquiryType>>(enquirytype,HttpStatus.OK);	
		}
		
		// add an enquiry
		@PostMapping(value="/add")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<String> save(@Valid @RequestBody Enquiry enquiry)
		{
			LOGGER.log(Level.INFO, "Adding an enquiry");
			Enquiry enq=service.addQuery(enquiry);
			return new ResponseEntity<String>("Query Added Successfully ",HttpStatus.OK);	
		}
		
		//view response/query
		@GetMapping(value="/viewAll")
		public ResponseEntity<List<Enquiry>> getAllQueries()
		{
			LOGGER.log(Level.INFO, "View All");
			List<Enquiry> enquiry=service.viewAll();	
			return new ResponseEntity<List<Enquiry>>(enquiry,HttpStatus.OK);	
		}
		
		// get details by email ID
		@RequestMapping(value = "/mail/{mail}")
		public ResponseEntity findByMail(@PathVariable String mail) 
		{
			LOGGER.log(Level.INFO, "Find user by email");
			List<Enquiry> enquiry = service.findByMail(mail);
			if(enquiry.isEmpty())
			{
				LOGGER.log(Level.INFO, "Unregistered email ID");
				throw new ResourceNotFoundException("Email Id "+mail+" is not registered or you have entered wrong details ");
				
			}
			return  ResponseEntity.ok(enquiry);
		}
		
		// get details by phone number
		@RequestMapping(value = "/phone/{phone}")
		public ResponseEntity findByPhone(@PathVariable String phone) 
		{
			LOGGER.log(Level.INFO, "Find user by phone");
			List<Enquiry> enquiry = service.findByPhone(phone);
			if(enquiry.isEmpty())
			{
				LOGGER.log(Level.INFO, "Unregistered phone");
				throw new ResourceNotFoundException("Phone number "+phone+" is not registered or you have entered wrong details ");
			}
			return  ResponseEntity.ok(enquiry);
		}
		
		//update response
		@PatchMapping(value="/update/{id}")
		@ResponseStatus(HttpStatus.ACCEPTED)
		public Enquiry update( @RequestBody Map<String,String> updateData, @PathVariable long id)
		{	
			LOGGER.log(Level.INFO, "Adding response");
			Enquiry enquiry = service.addResponse(updateData, id);
			return enquiry;
		}

}
