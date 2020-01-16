package com.rpcl.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Person {
	private Integer personSsn;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String state;
	private String stateCode;

}
