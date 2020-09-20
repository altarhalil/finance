package com.altar.finance.loanservice.configuration;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "app")
@Configuration
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppProperties {
	
	private int creditMultiplier;
	private int highestCreditScore;
	private BigDecimal montlyIncomeLimit;
	private int lowestCreditScore;
	private BigDecimal defaultMediumSegmentLimit;
	private String smsDescription;


}