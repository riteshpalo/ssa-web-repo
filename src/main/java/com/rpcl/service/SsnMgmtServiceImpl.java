package com.rpcl.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpcl.domain.Person;
import com.rpcl.entity.PersonSsnDetailsEntity;
import com.rpcl.repository.PersonSsnDetailsRepository;
import com.rpcl.repository.StatesRepository;
@Service
public class SsnMgmtServiceImpl implements SsnMgmtService {

	@Autowired
	private StatesRepository statesRepo;
	@Autowired
	private PersonSsnDetailsRepository personSssRepo;
	
	@Override
	public List<String> fetchAllStates() {
		return statesRepo.findallStateNames();
	}

	@Override
	public Person savePersonSsnDetails(Person person) {
		PersonSsnDetailsEntity personEntity=new PersonSsnDetailsEntity();
		BeanUtils.copyProperties(person, personEntity);
		String stateCode = statesRepo.findStateCodeByStateName(person.getState());
		if(stateCode!=null) {
			personEntity.setStateCode(stateCode);
		}
		personEntity=personSssRepo.save(personEntity);
		if(personEntity!=null) {
			BeanUtils.copyProperties(personEntity, person);
		}
		
		return person;
	}

	@Override
	public String fetchStateCodeBySSN(Integer ssn) {
		return personSssRepo.findStateCodeBySSN(ssn);
	}

}
