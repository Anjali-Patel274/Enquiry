package com.enquiry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Role {


	@Id
	@Column(name="Role_Id")
	private long id;

	@NotNull
	@Size(min=4)
	@Column(name="Role_Name")
	private String role_name;

	
	public Role() {
		super();
	}

	public Role(long id, @NotNull @Size(min = 4) String role_name) {
		super();
		this.id = id;
		this.role_name = role_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + "]";
	}

	
}
