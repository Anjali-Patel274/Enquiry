package com.enquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.entity.Role;
import com.enquiry.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository rr;

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		List<Role> role=(List<Role>) rr.findAll();
		return role;
		
	}


}
