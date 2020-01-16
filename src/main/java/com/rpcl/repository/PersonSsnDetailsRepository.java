package com.rpcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rpcl.entity.PersonSsnDetailsEntity;

public interface PersonSsnDetailsRepository extends JpaRepository<PersonSsnDetailsEntity, Integer> {

	@Query(value = "select stateCode from PersonSsnDetailsEntity where personSsn=:ssn")
	public String findStateCodeBySSN(Integer ssn);
	
}
