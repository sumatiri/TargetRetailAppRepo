package com.retailapplication.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* Model class for Db current_price. Contains price specific information
 * 
 */
@Document(collection = "priceinfo")
public class PriceInfo {
	@Id
	private int id;
	private BigDecimal value;
	private String currencyCode;
	
	public PriceInfo(){
	}

	
	@JsonIgnore
	@JsonProperty(value = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrencycode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
