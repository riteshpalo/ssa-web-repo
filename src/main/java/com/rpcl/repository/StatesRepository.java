package com.rpcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rpcl.entity.StatesEntity;

public interface StatesRepository extends JpaRepository<StatesEntity, Integer> {
	
	@Query(value = "select stateName from StatesEntity")
	public List<String> findallStateNames();
	
	@Query(value = "select stateCode from StatesEntity where stateName=:stateName")
	public String findStateCodeByStateName(String stateName);

	
}
