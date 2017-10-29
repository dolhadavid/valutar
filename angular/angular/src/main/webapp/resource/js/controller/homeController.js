app.controller("homeController", function($http, $scope, $location, $cookies,
		$mdDialog, loginService, todoService, userService, demandService) {
	var originatorEv;

	$scope.friends = [];

	$scope.friendsRequest = [];

	$scope.demands = [];

	$scope.usersByCriteria = [];
	
	$scope.myDemands = [];

	init();
	
	

	this.openMenu = function($mdOpenMenu, ev) {
		originatorEv = ev;
		$mdOpenMenu(ev);
	};

	this.openMyDemandDialog = function(ev) {
		$mdDialog.show({
			templateUrl : 'demandDialog.tmpl.html',
			controller : 'demandDialogController',
			controllerAs : 'demandDialog',
			scope : angular.extend($scope.$new(), {
				cancel : function() {
					$mdDialog.cancel();
				}
			}),
			parent : angular.element(document.body),
			targetEvent : ev,
			clickOutsideToClose : true,
			fullscreen : false
		});
	}

	this.openMyOfferDialog = function(ev) {
		$mdDialog.show({
			templateUrl : 'offerDialog.tmpl.html',
			controller : 'offerDialogController',
			controllerAs : 'offerDialog',
			scope : angular.extend($scope.$new(), {
				cancel : function() {
					$mdDialog.cancel();
				}
			}),
			parent : angular.element(document.body),
			targetEvent : ev,
			clickOutsideToClose : true,
			fullscreen : false
		});
	}

	function init() {
		if ($cookies.isLogged === 'true') {
			getFriends();
			
			getFriendsRequest();
			
			getAllDemands();
			
			getMyDemands();
		}
	}

	this.redirectToUserPage = function(username) {
		$location.path("/home/" + username);
	};

	this.search = function(username) {
		userService.getUsernameByCriteria(username).then(
				function success(response) {
					$scope.usersByCriteria = response.data;
				});

		return $scope.usersByCriteria;
	}

	function refreshData() {

		todoService.getAll().then(function success(response) {
			$scope.todos = response.data;
		});

	}
	;
	
	function getMyDemands() {
		demandService.getAllDemandsByUser().then(function success(response) {
			$scope.myDemands = response.data;
		});
	}

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