package com.currencyexchangeservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

	@Id
	private Long id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	@Column(name = "Conversion_Multiple")
	private BigDecimal conversionMultiple;

	private String environment;

	/*
	 * public ExchangeValue(Long id, String from, String to, BigDecimal
	 * conversionMultiple) { super(); this.id = id; this.from = from; this.to = to;
	 * this.conversionMultiple = conversionMultiple;
	 * 
	 * }
	 */

}
