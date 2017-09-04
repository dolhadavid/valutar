package repository;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import domain.Todo;

@Repository
public class TodoDao {

	@Resource
	private SessionFactory factory;

	private Session getSession() {
		return this.factory.getCurrentSession();
	}

	public Todo findById(Integer id) {
		return this.getSession().get(Todo.class, id);
	}

	public Todo save(Todo todo) {
		this.getSession().save(todo);
		this.getSession().flush();

		return todo;
	}

	public void saveAll(Collection<Todo> todos) {
		this.getSession().save(todos);
		this.getSession().flush();
	}

	public void update(Todo todo) {
		Todo todoForUpdate = this.findById(todo.getId());

		if (todoForUpdate != null) {
			todoForUpdate.setText(todo.getText());
			this.getSession().update(todoForUpdate);
			this.getSession().flush();
		}
	}

	public boolean delete(Integer id) {
		Todo todo = this.findById(id);

		if (todo != null) {
			todo.setUser(null);
			this.getSession().delete(todo);
			this.getSession().flush();

			return true;
		}

		return false;
	}

	public void deleteAll() {
		this.getSession().createQuery("delete from Todo").executeUpdate();
		this.getSession().flush();
	}

	@SuppressWarnings("unchecked")
	public List<Todo> getAll() {
		List<Todo> todos = this.getSession().createQuery("FROM Todo").list();
		this.getSession().flush();
		return todos;
	}
}
