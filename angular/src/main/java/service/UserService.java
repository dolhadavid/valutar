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
import repository.UserDao;
import util.SessionUtil;

@Service
@Transactional
public class UserService {

	@Resource
	private UserDao userDao;

	public boolean checkUserIfExist(UserModel userModel) {
		User user = userDao.findUser(new User(userModel.getUsername(), userModel.getPassword()));
		// userModel.setId(user.getId());

		if (user != null) {
			return true;
		}
		return false;
	}

	public UserModel getUser(UserModel userModel) {
		User user = userDao.findUser(new User(userModel.getUsername(), userModel.getPassword()));

		return new UserModel(user.getId(), user.getUsername(), user.getPassword());
	}

	public List<UserModel> getUserFriends(UserModel userModel) {

		User user = userDao.findUser(new User(userModel.getUsername(), userModel.getPassword()));

		List<UserModel> usersModel = new LinkedList<>();
		for (User u : user.getFriends()) {
			usersModel.add(new UserModel(u.getUsername()));
		}

		return usersModel;
	}

	public List<UserModel> getUserFriendsRequest(UserModel userModel) {

		User user = userDao.findUser(new User(userModel.getUsername(), userModel.getPassword()));

		List<UserModel> usersModel = new LinkedList<>();
		for (User u : user.getBeFriends()) {
			usersModel.add(new UserModel(u.getId(), u.getUsername()));
		}

		return usersModel;
	}

	public void modify(User user) {
		this.userDao.update(user);
	}

	public User getUserd(UserModel userModel) {
		return userDao.findUser(new User(userModel.getUsername(), userModel.getPassword()));
	}

	public List<TodoModel> getTodosByUser(UserModel userModel) {
		if (userModel != null) {
			List<TodoModel> todosModel = new LinkedList<>();
			for (Todo todo : userDao.findUser(new User(userModel.getUsername(), userModel.getPassword())).getTodos()) {
				todosModel.add(new TodoModel(todo.getId(), todo.getText()));
			}

			return todosModel;
		}
		return null;
	}
}
