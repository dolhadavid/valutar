app.controller("homeController", function($http, $scope, $location, $cookies,
		$mdDialog, loginService, todoService, userService, demandService) {
	var originatorEv;

	$scope.friends = [];

	$scope.friendsRequest = [];

	$scope.demands = [];

	$scope.usersByCriteria = [];

	init();

	this.openMenu = function($mdOpenMenu, ev) {
		originatorEv = ev;
		$mdOpenMenu(ev);
	};

	function init() {
		if ($cookies.isLogged === 'true') {
			getFriends();
			getFriendsRequest();
			getAllDemands();
		}
	}

	this.search = function() {
		userService.getUsernameByCriteria(this.userInput.username).then(
				function success(response) {
					$scope.usersByCriteria = response.data;
					console.log($scope.usersByCriteria);
				});
	}

	this.showUserDemand = function($event) {
		$mdDialog.show({
			controller : DialogController,
			templateUrl : 'dialog1.tmpl.html',
			parent : angular.element(document.body),
			targetEvent : ev,
			clickOutsideToClose : true,
			fullscreen : $scope.customFullscreen
		// Only for -xs, -sm breakpoints.
		}).then(function(answer) {
			$scope.status = 'You said the information was "' + answer + '".';
		}, function() {
			$scope.status = 'You cancelled the dialog.';
		});
	};

	function refreshData() {

		todoService.getAll().then(function success(response) {
			$scope.todos = response.data;
		});

	}
	;

	function getAllDemands() {
		demandService.getAllDemands().then(function success(response) {
			$scope.demands = response.data;
		});
	}

	this.logout = function() {
		loginService.logout();
		$cookies.isLogged = null;
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