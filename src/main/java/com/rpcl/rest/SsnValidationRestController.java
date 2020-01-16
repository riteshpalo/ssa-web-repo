package com.rpcl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rpcl.exceptions.SsnNotFoundException;
import com.rpcl.service.SsnMgmtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "This represents validation for SSN")
public class SsnValidationRestController {

	@Autowired
	private SsnMgmtService ssnMgmtService;
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 400,message = "Bad Request"),
			@ApiResponse(code = 500,message = "Server problem")
	})
	@ApiOperation(value = "This is Used to Get State Code By SSN ")
	@GetMapping(value = "/getStateCodeBySSN/{ssn}",produces = "application/json")
	public ResponseEntity<String> getStateCodeBySSN(@ApiParam(value = "It Represents the SSN ",required = true)@PathVariable("ssn")Integer ssn){
		String stateCode = ssnMgmtService.fetchStateCodeBySSN(ssn);
		if(stateCode!=null && !stateCode.isEmpty()) {
			return new ResponseEntity<String>(stateCode, HttpStatus.OK);
		}else {
			throw new SsnNotFoundException();
		}
	}
}
