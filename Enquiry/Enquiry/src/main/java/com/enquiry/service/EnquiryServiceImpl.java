package com.enquiry.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.enquiry.entity.Enquiry;
import com.enquiry.entity.EnquiryType;
import com.enquiry.repository.EnquiryRepository;
import com.enquiry.repository.EnquiryTypeRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	private EnquiryTypeRepository etr;
	@Autowired
	private EnquiryRepository er;
	
	@Override
	public List<EnquiryType> getAllEnquiryTypes() {
		List<EnquiryType> enquirytype=(List<EnquiryType>) etr.findAll();
		return enquirytype;
	}


	@Override
	public Enquiry addQuery(Enquiry enquiry) {
		// TODO Auto-generated method stub
		return er.save(enquiry);
	}
	

	@Override
	public List<Enquiry> viewAll() {
		// TODO Auto-generated method stub
		List<Enquiry> enquiry=(List<Enquiry>) er.findAll();
		return enquiry;
	}
	
	
	@Override
	public List<Enquiry> findByMail(String mail) {
		// TODO Auto-generated method stub
		List<Enquiry> enquiry=(List<Enquiry>) er.findByMail(mail);
		return enquiry;
	}

	@Override
	public List<Enquiry> findByPhone(String phone) {
		// TODO Auto-generated method stub
		List<Enquiry> enquiry=(List<Enquiry>) er.findByPhone(phone);
		return enquiry;
	}

	@Override
	public Enquiry addResponse(Map<String, String> updateData, long id) {
		// TODO Auto-generated method stub
		String updatedEnquiryType=updateData.get("enquirytype");
		String updatedEmailID=updateData.get("mail");
		String updatedPhone=updateData.get("phone");
		String updatedQuery=updateData.get("query");
		String updatedResponse=updateData.get("response");
		return er.findById(id).map(enquiry->
		{
			if(!StringUtils.isEmpty(updatedEnquiryType))
			{	
				enquiry.setEnquirytype(updatedEnquiryType);
			}
			if(!StringUtils.isEmpty(updatedEmailID))
			{	
				enquiry.setMail(updatedEmailID);
			}
			if(!StringUtils.isEmpty(updatedPhone))
			{
				enquiry.setPhone(updatedPhone);
			}
			if(!StringUtils.isEmpty(updatedQuery))
			{
				enquiry.setQuery(updatedQuery);
			}
			if(!StringUtils.isEmpty(updatedResponse))
			{
				enquiry.setResponse(updatedResponse);
			}
			er.save(enquiry);
			return enquiry;
		}).orElseThrow();	
	}



}
