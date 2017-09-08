package model;

import java.util.Date;

import domain.User;

public class DemandModel {

	private Integer id;

	private Integer sum;

	private String Fromcurrency;

	private String Tocurrency;

	private UserModel user;

	private Date dataDemand;

	public DemandModel() {
	}

	public DemandModel(Integer id, Integer sum, String fromcurrency, String tocurrency, UserModel user,
			Date dataDemand) {
		this.id = id;
		this.sum = sum;
		Fromcurrency = fromcurrency;
		Tocurrency = tocurrency;
		this.user = user;
		this.dataDemand = dataDemand;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getFromcurrency() {
		return Fromcurrency;
	}

	public void setFromcurrency(String fromcurrency) {
		Fromcurrency = fromcurrency;
	}

	public String getTocurrency() {
		return Tocurrency;
	}

	public void setTocurrency(String tocurrency) {
		Tocurrency = tocurrency;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Date getDataDemand() {
		return dataDemand;
	}

	public void setDataDemand(Date dataDemand) {
		this.dataDemand = dataDemand;
	}
}
