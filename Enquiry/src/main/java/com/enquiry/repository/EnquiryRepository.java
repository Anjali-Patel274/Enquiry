package com.enquiry.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enquiry.entity.Enquiry;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry,Long> {

	
	List<Enquiry> findByMail(String mail);
	List<Enquiry> findByPhone(String phone);


}
