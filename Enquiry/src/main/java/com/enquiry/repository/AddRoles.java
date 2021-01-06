package com.enquiry.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enquiry.entity.Role;

@Component
public class AddRoles implements CommandLineRunner{
	@Autowired
	private RoleRepository rr;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role role1=new Role();
	    role1.setId(1);
		role1.setRole_name("Customer");
		rr.save(role1);
		
		Role role2=new Role();
	    role2.setId(2);
		role2.setRole_name("Admin");
		rr.save(role2);
				
	}
	
	

}
