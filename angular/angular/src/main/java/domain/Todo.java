package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id")
	private Integer id;

	@Column(name = "text")
	private String text;

	@ManyToOne
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name = "user_fk")
	private User user;

	public Todo() {
	}

	public Todo(String text) {
		this.text = text;
	}

	public Todo(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Todo(String text, User user) {
		this.text = text;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
