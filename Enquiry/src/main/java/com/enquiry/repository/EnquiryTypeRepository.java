package com.enquiry.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enquiry.entity.EnquiryType;

@Repository
public interface EnquiryTypeRepository extends CrudRepository<EnquiryType,Long> {

}
