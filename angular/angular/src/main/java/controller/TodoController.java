package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.TodoModel;
import model.UserModel;
import service.TodoService;
import service.UserService;
import util.SessionUtil;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Resource
	private TodoService todoService;

	@Resource
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoModel> getTodos() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		return this.todoService.getAll(userModel);
	}

	@RequestMapping(method = RequestMethod.POST)
	public TodoModel addTodo(@RequestBody TodoModel todoModel) {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		return this.todoService.create(todoModel, userModel);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public TodoModel updateTodo(@RequestBody TodoModel todoModel) {
		this.todoService.update(todoModel);

		return todoModel;
	}

	@RequestMapping(value = "/{todoId}", method = RequestMethod.DELETE)
	public boolean deleteTodo(@PathVariable Integer todoId) {
		return this.todoService.delete(todoId);
	}
}
