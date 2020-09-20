package com.altar.finance.loanservice.service.impl;

import org.springframework.stereotype.Service;

import com.altar.finance.loanservice.model.CreditScoreResponse;
import com.altar.finance.loanservice.service.CreditScoreClient;

@Service
public class CreditScoreClientImp implements CreditScoreClient {

	@Override
	public CreditScoreResponse getCreditScoreById(String id) {
		CreditScoreResponse score = new CreditScoreResponse();
		return score;
	}

}
