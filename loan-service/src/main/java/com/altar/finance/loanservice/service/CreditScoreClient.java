package com.altar.finance.loanservice.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.altar.finance.loanservice.model.CreditScoreResponse;

//@FeignClient(name="credit-service", url = "weather.livedoor.com")
public interface CreditScoreClient {

//    @GetMapping("/credit-score/{id}")
	CreditScoreResponse getCreditScoreById(@PathVariable String id);


}
