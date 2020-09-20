package com.altar.finance.loanservice.model;

import java.math.BigDecimal;

import com.altar.finance.loanservice.model.base.BaseResponse;
import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;

public class LoanResponse extends BaseResponse {

	private LoanApplicationStatus status;
	private BigDecimal limit;

	public LoanResponse(int code, String message) {
		super(code, message);
	}

	public LoanApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(LoanApplicationStatus status) {
		this.status = status;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "LoanResponse [status=" + status + ", limit=" + limit + ", getStatus()=" + getStatus() + ", getLimit()="
				+ getLimit() + ", getCode()=" + getCode() + ", getMessage()=" + getMessage() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

}