package repository;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import domain.Todo;
import domain.User;

@Repository
public class UserDao {

	@Resource
	private SessionFactory factory;

	private Session getSession() {
		return this.factory.getCurrentSession();
	}

	public void save(User user) {
		this.getSession().save(user);
		this.getSession().flush();
	}

	public User findbyId(Integer id) {
		User user = this.getSession().get(User.class, id);
		this.getSession().flush();

		return user;
	}

	public void update(User user) {
		User userForUpdate = this.findbyId(user.getId());

		if (userForUpdate != null) {
			userForUpdate.setPassword(user.getPassword());
			userForUpdate.setTodos(user.getTodos());
			this.getSession().update(userForUpdate);
			this.getSession().flush();
		}
	}

	@SuppressWarnings("unchecked")
	public User findUser(User user) {
		Query query = this.getSession()
				.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password LIKE :password");
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());

		List<User> users = query.getResultList();

		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}
}
