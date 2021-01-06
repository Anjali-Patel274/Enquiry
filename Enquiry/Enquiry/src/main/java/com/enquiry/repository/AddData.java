package com.enquiry.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enquiry.entity.EnquiryType;

@Component
public class AddData implements CommandLineRunner{
	@Autowired
	private EnquiryTypeRepository etr;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		EnquiryType et1=new EnquiryType();
		et1.setId(1);
		et1.setEnquiry_name("Service Related Enquiry");
		etr.save(et1);
		
		EnquiryType et2=new EnquiryType();
		et2.setId(2);
		et2.setEnquiry_name("Price Related Enquiry");
		etr.save(et2);
		
		EnquiryType et3=new EnquiryType();
		et3.setId(3);
		et3.setEnquiry_name("Parts Related Enquiry");
		etr.save(et3);
		
		EnquiryType et4=new EnquiryType();
		et4.setId(4);
		et4.setEnquiry_name("Other Enquiry");
		etr.save(et4);
		
	}
	
	

}
