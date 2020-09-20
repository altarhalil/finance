package com.altar.finance.loanservice.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altar.finance.loanservice.component.CustomerProfileValidation;
import com.altar.finance.loanservice.configuration.AppProperties;
import com.altar.finance.loanservice.exception.CreditScoreException;
import com.altar.finance.loanservice.exception.RecordNotFoundException;
import com.altar.finance.loanservice.model.CreditScoreResponse;
import com.altar.finance.loanservice.model.LoanApplication;
import com.altar.finance.loanservice.model.LoanRequest;
import com.altar.finance.loanservice.model.LoanResponse;
import com.altar.finance.loanservice.model.enums.LoanApplicationStatus;
import com.altar.finance.loanservice.repository.LoanRepository;
import com.altar.finance.loanservice.service.CreditScoreClient;
import com.altar.finance.loanservice.service.LoanService;
import com.altar.finance.loanservice.service.SmsService;
import com.altar.finance.loanservice.util.Constanst;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanServiceImp implements LoanService {

	@Autowired
	CreditScoreClient creditScoreService;

	@Autowired
	AppProperties properties;

	@Autowired
	CustomerProfileValidation profile;

	@Autowired
	SmsService smsService;

	@Autowired
	LoanRepository repository;
	
	@Override
	public LoanResponse applyForLoan(LoanRequest request) {
		log.info("Incoming request for appyForLoan service :{}", request);

		int score = getCreditScoreService(request);

		LoanApplication loanApplication = createLoanApplication(request, score);
		log.info("Loan Application is with credit score : {}", loanApplication);

		 loanApplication = profile.validate(loanApplication);

		if (loanApplication.getStatus() == LoanApplicationStatus.ONAY) {
     		repository.save(loanApplication);
			sendSms(loanApplication);
		}

		LoanResponse response = createResponse(loanApplication);
		log.info("Response for appyForLoan service : {}", response);

		return response;
	}

	private int getCreditScoreService(LoanRequest request) {
		try {
			CreditScoreResponse creditScore = creditScoreService.getCreditScoreById(request.getIdNumber());

			if (creditScore.getCode() != 100) {
				log.warn("Kullanıcıya ait kredi skoru bulunamadi.");
				throw new RecordNotFoundException("Kullanıcıya ait kredi skoru bulunamadi");
			}
			return creditScore.getScore();

		} catch (Exception ex) {
			log.error("CreditScore Service exception.");
			throw new CreditScoreException("Daha sonra tekrar deneyiniz.");
		}
	}

	private LoanResponse createResponse(LoanApplication loanApplication) {
		LoanResponse response = new LoanResponse(100, "İşlem Başarılı");
		response.setLimit(loanApplication.getCredit());
		response.setStatus(loanApplication.getStatus());

		return response;
	}

	private LoanApplication createLoanApplication(LoanRequest request, int creditScore) {
		LoanApplication application = new LoanApplication();

		application.setCreditScore(creditScore);
		application.setMonthlyIncome(request.getMonthlyIncome());
		application.setIdNumber(request.getIdNumber());
		application.setMsisdn(request.getMsisdn());
		application.setName(request.getName());
		application.setSurName(request.getSurName());

		return application;
	}

	private void sendSms(LoanApplication application) {
		try {
			this.smsService.send(Constanst.SMS_FROM, application.getMsisdn(), properties.getSmsDescription(),
					Locale.ENGLISH, new Object[] { application.getName(), application.getMonthlyIncome() });

		} catch (Exception ex) {
			log.warn("Error occured when sendin sms.");
		}

	}

}
