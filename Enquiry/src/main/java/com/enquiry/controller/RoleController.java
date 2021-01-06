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

@RestController 
@RequestMapping(value="/role")
public class RoleController {
	
	@Autowired
	private RoleServiceImpl rsi;

	// get roles   
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Role>> getAllRoles()
	{
		List<Role> roles=rsi.getAllRoles();	
		return new ResponseEntity<List<Role>>(roles,HttpStatus.OK);	
	}
	

}
