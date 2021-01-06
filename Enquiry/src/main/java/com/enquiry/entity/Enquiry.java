package com.enquiry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Enquiry {

	@Id
	@Column(name="Enquiry_Id")
	private long id;
	
	@Column(name="EnquiryTypeName")
	private String enquirytype; 

	@NotBlank(message="Email Id is mandatory")
	@Email
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+",message = "enter email in valid format")
	@Column(name = "EmailID")
	private String mail;

	@NotBlank(message="Phone number is mandatory")
	@Pattern(regexp="^[7-9][0-9]{9}$",message = "enter phone in valid format")
	@Column(name = "Phone")
	private String phone;
	
	@NotNull
	@Size(min=4, message="Please enter query")
	@Column(name="Query")
	private String query;
	
	@Size(min=4)
	@Column(name="Response")
	private String response;
	
		

	public Enquiry() {
		super();
	}

	public Enquiry(long id, String enquirytype,
			@NotBlank(message = "Email Id is mandatory") @Email @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+", message = "enter email in valid format") String mail,
			@NotBlank(message = "Phone number is mandatory") @Pattern(regexp = "^[7-9][0-9]{9}$", message = "enter phone in valid format") String phone,
			@NotNull @Size(min = 4, message = "Please enter query") String query,
			@Size(min = 4) String response) {
		super();
		this.id = id;
		this.enquirytype = enquirytype;
		this.mail = mail;
		this.phone = phone;
		this.query = query;
		this.response = response;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnquirytype() {
		return enquirytype;
	}

	public void setEnquirytype(String enquirytype) {
		this.enquirytype = enquirytype;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Enquiry \nid;" + id + "\n Enquiry Type:" + enquirytype + "\nEmail ID:"
				+ mail + "\n Phone:" + phone + "\n Customer Query:"
				+ query + "\n Customer Response:" + response;
	}
	
}
