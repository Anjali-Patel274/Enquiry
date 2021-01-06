package com.enquiry.service;

import java.util.List;
import java.util.Map;

import com.enquiry.entity.Enquiry;
import com.enquiry.entity.EnquiryType;

public interface EnquiryService {

	public List<EnquiryType> getAllEnquiryTypes();
	public Enquiry addQuery(Enquiry enquiry);
	public List<Enquiry> viewAll();
	public List<Enquiry> findByMail(String mail);
	public List<Enquiry> findByPhone(String phone);
	public Enquiry addResponse(Map<String,String> updateData,long id);
	
}
