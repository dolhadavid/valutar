app.controller("homeController", function($http, $scope, $location,
		loginService, todoService, userService, $mdDialog) {
	var originatorEv;

	$scope.friends = [];
	
	$scope.friendsRequest = [];

	getFriends();
	getFriendsRequest();

	this.openMenu = function($mdOpenMenu, ev) {
		originatorEv = ev;
		$mdOpenMenu(ev);
	};

	function refreshData() {

		todoService.getAll().then(function success(response) {
			$scope.todos = response.data;
		});

	}
	;

	this.logout = function() {
		loginService.logout();
	}

	this.createTodo = function() {

		if (this.newTodoText != "") {

			todoForm = {
				id : -1,
				text : this.newTodoText,
			};

			todoService.createTodo(todoForm).then(function success(response) {
				$scope.todos.push(response.data);
			});

			this.newTodoText = "";
		}
	};

	this.deleteTodo = function(todoId, index) {

		todoService.deleteTodo(todoId).then(function success(response) {
			$scope.todos.splice(index, 1);
		});
	};

	this.updateTodo = function(todoId, index) {
		if (this.newTodoText != "") {

			todoForm = {
				id : todoId,
				text : this.newTodoText
			};

			todoService.updateTodo(todoForm).then(function success(response) {
				$scope.todos[index] = todoForm;
			});

			this.newTodoText = "";
		}
	};

	function getFriends() {
		userService.getFriends().then(function success(response) {
			$scope.friends = response.data;
		});
	}
	
	function getFriendsRequest() {
		userService.getFriendsRequest().then(function success(response) {
			$scope.friendsRequest = response.data;
		});
	}
});