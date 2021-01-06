package com.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enquiry.entity.Role;
import com.enquiry.service.RoleServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

@RestController 
@RequestMapping(value="/role")
public class RoleController {
	
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	private RoleServiceImpl rsi;

	// get roles   
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Role>> getAllRoles()
	{
		LOGGER.log(Level.INFO, "View All Roles");
		List<Role> roles=rsi.getAllRoles();
		return new ResponseEntity<List<Role>>(roles,HttpStatus.OK);
	}
	

}
