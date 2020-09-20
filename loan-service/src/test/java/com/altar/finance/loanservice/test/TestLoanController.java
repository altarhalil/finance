package com.altar.finance.loanservice.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.altar.finance.loanservice.model.CreditScoreResponse;
import com.altar.finance.loanservice.model.LoanRequest;
import com.altar.finance.loanservice.model.LoanResponse;
import com.altar.finance.loanservice.service.CreditScoreClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestLoanController {
	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private CreditScoreClient score;

	@Test
	public void testForBadRequest() throws Exception {
		// phone format is wrong
		LoanRequest request = new LoanRequest("12345678912", "Halil", "Altar", "542561495", new BigDecimal(40000));
		LoanResponse responseEntity = restTemplate.postForObject("/loans/apply", request, LoanResponse.class);
		int result = responseEntity.getCode();
		assertEquals(-1, result);
	}

	@Test
	public void testForBadRequest2() throws Exception {
		// id format is wrong
		LoanRequest request = new LoanRequest("123456789", "Halil", "Altar", "5425614935", new BigDecimal(40000));
		LoanResponse responseEntity = restTemplate.postForObject("/loans/apply", request, LoanResponse.class);
		String result = responseEntity.getMessage();
		assertEquals("Identidy number must be 11 digits.", result);
	}

	@Test
	public void testForSuccess() throws Exception {
		// id format is wrong
		LoanRequest request = new LoanRequest("12345678912", "Halil", "Altar", "5425614935", new BigDecimal(40000));

		CreditScoreResponse response = new CreditScoreResponse();
		response.setScore(50000);
		response.setCode(100);
		given(this.score.getCreditScoreById("12345678912")).willReturn(response);

		LoanResponse responseEntity = restTemplate.postForObject("/loans/apply", request, LoanResponse.class);
		System.out.println(responseEntity);
		BigDecimal limit = responseEntity.getLimit();
		assertEquals(new BigDecimal(40000 * 4), limit);
	}

}