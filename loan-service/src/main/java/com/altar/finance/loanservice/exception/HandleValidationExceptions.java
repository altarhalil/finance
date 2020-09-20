package com.altar.finance.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.altar.finance.loanservice.model.base.BaseResponse;
import com.altar.finance.loanservice.util.Constanst;

@RestControllerAdvice
public class HandleValidationExceptions {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public BaseResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
		return new BaseResponse(Constanst.BAD_REQUEST_INTERNAL_CODE,
				ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseResponse handleCustomException(Exception exception) {
		return new BaseResponse(Constanst.INTERNAL_ERROR_CODE, exception.getMessage());
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final BaseResponse handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
		return new BaseResponse(Constanst.SERVICE_EXCEPTION_CODE, ex.getMessage());

	}

	@ExceptionHandler(CreditScoreException.class)
	public final BaseResponse handleCreditScoreException(RecordNotFoundException ex, WebRequest request) {
		return new BaseResponse(Constanst.SERVICE_EXCEPTION_CODE, ex.getMessage());

	}
}
