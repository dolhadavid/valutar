app.controller("userController", function($http, $scope, $location, $cookies,
		$mdDialog, loginService) {

	this.checkUser = function() {
		if (this.userInput.username != "" && this.userInput.password != "") {
			var user = {
				id : -1,
				username : this.userInput.username,
				password : this.userInput.password
			};
			loginService.checkUser(user).then(function success(response) {
				if (response.data) {
					$cookies.isLogged = response.data;
					$location.path('/home');
				} else {
					alert('Password or username is invalid!');
				}
			});
		}
	};

	this.openRegisterDialog = function(ev) {
		$mdDialog.show({
			templateUrl : 'registerDialog.tmpl.html',
			controller : 'registerController',
			controllerAs : 'register',
			windowClass: 'app-modal-window',
			parent : angular.element(document.body),
			targetEvent : ev,
			clickOutsideToClose : true,
			fullscreen : false
		});
	}
});