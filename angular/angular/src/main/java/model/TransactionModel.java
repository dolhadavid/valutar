package model;

import java.util.Date;

public class TransactionModel {

	private Integer id;
	private Date data;
	private String fromCurrency;
	private String toCurrency;
	private String username;
	private Integer sumFrom;
	private Integer sumTo;

	public TransactionModel() {
	}
	
	public TransactionModel(Date data, String fromCurrency, String toCurrency, String username, Integer sumFrom,
			Integer sumTo) {
		this.data = data;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.username = username;
		this.sumFrom = sumFrom;
		this.sumTo = sumTo;
	}

	public TransactionModel(Integer id, Date data, String fromCurrency, String toCurrency, String username,
			Integer sumFrom, Integer sumTo) {
		this.id = id;
		this.data = data;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.username = username;
		this.sumFrom = sumFrom;
		this.sumTo = sumTo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSumFrom() {
		return sumFrom;
	}

	public void setSumFrom(Integer sumFrom) {
		this.sumFrom = sumFrom;
	}

	public Integer getSumTo() {
		return sumTo;
	}

	public void setSumTo(Integer sumTo) {
		this.sumTo = sumTo;
	}
}
