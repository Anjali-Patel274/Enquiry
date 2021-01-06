package com.enquiry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EnquiryType {


	@Id
	@Column(name="EnquiryType_Id")
	private long id;

	@NotNull
	@Size(min=4, message="Name should have atleast 4 characters")
	@Column(name="EnquiryType_Name")
	private String enquiry_name;

	
	
	public EnquiryType() {
		super();
	}

	public EnquiryType(long id,
			@NotNull @Size(min = 4, message = "Name should have atleast 4 characters") String enquiry_name) {
		super();
		this.id = id;
		this.enquiry_name = enquiry_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnquiry_name() {
		return enquiry_name;
	}

	public void setEnquiry_name(String enquiry_name) {
		this.enquiry_name = enquiry_name;
	}

	@Override
	public String toString() {
		return "EnquiryType \n ID:=" + id + "\n  Enquiry Name:" + enquiry_name;
	}
	
	


}
