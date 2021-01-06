package com.enquiry.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.enquiry.*;
import com.enquiry.entity.Enquiry;
import com.enquiry.entity.EnquiryType;
import com.enquiry.repository.EnquiryRepository;
import com.enquiry.repository.EnquiryTypeRepository;
import com.enquiry.service.EnquiryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class EnquiryTest {
    @Autowired
	private EnquiryServiceImpl service;
    @MockBean
    private EnquiryRepository repo;
    
    @MockBean
    private EnquiryTypeRepository etr;
    
    // View Enquiry Types
    @Test
    public void getEnquiryTypesTest() {
    	
    	when(etr.findAll()).thenReturn(Stream.of(new EnquiryType(1, "new enquiry type")).collect(Collectors.toList()));
    	assertEquals(1,service.getAllEnquiryTypes().size());
    }
    
    //Add query 
    @Test
    public void addQueryTest() {
    	Enquiry enquiry= new Enquiry(9, "5", "dhvani123@gmail.com", "9876598765", "this is a query", " ");
    	when(repo.save(enquiry)).thenReturn(enquiry);
    	assertEquals(enquiry,service.addQuery(enquiry));
    }
    
    //Add response
    @Test
    public void addResponseTest() {
    	Enquiry enquiry= new Enquiry(9, "5", "dhvani123@gmail.com", "9876598765", "this is a query", "I gave response");
    	when(repo.save(enquiry)).thenReturn(enquiry);
    	assertEquals(enquiry,service.addQuery(enquiry));
    }
    
    // Search by email
    @Test
    public void getEnquiryByEmailTest() {
    	String email="dhvani123@gmail.com";
    	when(repo.findByMail(email)).thenReturn(Stream.of(new Enquiry(10, "3","dhvani123@gmail.com","9876598765","query", "response")).collect(Collectors.toList()));
    	assertEquals(1,service.findByMail(email).size());
    	
    }
    
    //Search by phone
    @Test
    public void getEnquiryByPhoneTest() {
    	String phone="9876598765";
    	when(repo.findByPhone(phone)).thenReturn(Stream.of(new Enquiry(10, "3","dhvani123@gmail.com","9876598765","query", "response")).collect(Collectors.toList()));
    	assertEquals(1,service.findByPhone(phone).size());
    	
    }
    
    
    
    
}