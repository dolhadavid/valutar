package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@BatchSize(size = 150)
	@JoinColumn(name = "user_fk")
	@Fetch(FetchMode.SELECT)
	private List<Todo> todos;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"), uniqueConstraints = @UniqueConstraint(name = "uq_userfriends", columnNames = {
			"user_id", "friend_id" }))
	@Fetch(FetchMode.SELECT)
	private List<User> friends;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_be_friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"), uniqueConstraints = @UniqueConstraint(name = "uq_userfriends", columnNames = {
			"user_id", "friend_id" }))
	@Fetch(FetchMode.SELECT)
	private List<User> beFriends;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@Fetch(FetchMode.SELECT)
	private Offer offer;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@BatchSize(size = 150)
	@JoinColumn(name = "user_fk")
	@Fetch(FetchMode.SELECT)
	private List<Demand> demand;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getBeFriends() {
		return beFriends;
	}

	public void setBeFriends(List<User> beFriends) {
		this.beFriends = beFriends;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public List<Demand> getDemand() {
		return demand;
	}

	public void setDemand(List<Demand> demand) {
		this.demand = demand;
	}

}
