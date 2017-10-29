package model;

import java.util.Date;

public class TransactionModel {

	private Integer id;
	private Date data;
	private String fromCurrency;
	private String toCurrency;
	private String username;
	private Integer sum;

	public TransactionModel() {
	}

	public TransactionModel(Date data, String fromCurrency, String toCurrency, String username, Integer sum) {
		this.data = data;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.username = username;
		this.sum = sum;
	}

	public TransactionModel(Integer id, Date data, String fromCurrency, String toCurrency, String username,
			Integer sum) {
		this.id = id;
		this.data = data;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.username = username;
		this.sum = sum;
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

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
}
