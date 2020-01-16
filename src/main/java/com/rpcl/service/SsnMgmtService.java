package com.rpcl.service;

import java.util.List;

import com.rpcl.domain.Person;


public interface SsnMgmtService {
	public List<String> fetchAllStates();
	public Person savePersonSsnDetails(Person person);
	public String fetchStateCodeBySSN(Integer ssn);
}
