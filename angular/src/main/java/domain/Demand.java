package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "demand")
public class Demand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demand_id")
	private Integer id;

	@Column(name = "sum")
	private Integer sum;

	@Column(name = "from_currency")
	private String Fromcurrency;

	@Column(name = "to_currency")
	private String Tocurrency;

	@OneToOne(mappedBy = "demand", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	private User user;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@BatchSize(size = 150)
	@JoinColumn(name = "demand_fk")
	private List<Offer> offers;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	

}
