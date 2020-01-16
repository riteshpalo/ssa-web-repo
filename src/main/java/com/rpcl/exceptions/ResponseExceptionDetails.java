package com.rpcl.exceptions;

import lombok.Data;

@Data
public class ResponseExceptionDetails {

	private String errorCode;
	private String errorDesc;
}
