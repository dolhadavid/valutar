package service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Todo;
import domain.User;
import model.TodoModel;
import model.UserModel;
import repository.TodoDao;

@Service
@Transactional
public class TodoService {

	@Resource
	private TodoDao todoDao;

	@Resource
	private UserService userService;

	public TodoModel create(TodoModel todoModel, UserModel userModel) {

		User user = userService.getUserd(userModel);
		Todo todo = new Todo(todoModel.getText());
		user.getTodos().add(todo);

		userService.modify(user);
		todoModel.setId(todo.getId());
		return todoModel;
	}

	public boolean delete(Integer id) {
		return this.todoDao.delete(id);
	}

	public void update(TodoModel todoModel) {
		this.todoDao.update(new Todo(todoModel.getId(), todoModel.getText()));
	}

	public List<TodoModel> getAll(UserModel userModel) {
		List<TodoModel> todos = new LinkedList<TodoModel>();

		return userService.getTodosByUser(userModel);
	}
}
