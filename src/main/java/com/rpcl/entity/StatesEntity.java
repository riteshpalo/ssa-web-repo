package com.rpcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE_MASTER")
public class StatesEntity {
	@Id
	@Column(name = "STATE_ID",length = 5)
	private Integer stateId;
	
	@Column(name = "STATE_CODE",length = 10)
	private String stateCode;
	
	@Column(name = "STATE_NAME",length = 20)
	private String stateName;

}
