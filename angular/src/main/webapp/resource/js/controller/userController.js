app.controller("userController", function($http, $scope, $location, $window,
		loginService) {

	this.checkUser = function() {
		if (this.userInput.username != "" && this.userInput.password != "") {
			var user = {
				id : -1,
				username : this.userInput.username,
				password : this.userInput.password
			};
			loginService.checkUser(user).then(function success(response) {
				if (response.data) {
					sessionStorage.isLogged = response.data;
					$location.path('/home');
				} else {
					alert('Password or username is invalid!');
				}
			});
		}
	};
});