package com.rpcl.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
@Table(name="PERSON_SSN_MASTER")
public class PersonSsnDetailsEntity {
	@Id
	   @GeneratedValue(generator = "sequence-generator")
	   @GenericGenerator(
	     name = "sequence-generator",
	     strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	     parameters = {
	       @Parameter(name = "sequence_name", value = "person_ssn_sequence"),
	       @Parameter(name = "initial_value", value = "122533225"),
	       @Parameter(name = "increment_size", value = "1")
	     }
	)
	@Column(name = "PERSON_SSN",length = 9)
	private Integer personSsn;
	@Column(name = "FIRST_NAME",length = 15)
	private String firstName;
	@Column(name = "LAST_NAME",length = 10)
	private String lastName;
	@Column(name = "GENDER",length = 10)
	private String gender;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "STATE_CODE",length = 5)
	private String stateCode;

}
