app.service('loginService', [ '$http', function($http) {

	var baseUrl = 'http://localhost:8080/angular/rest/users';

	this.checkUser = function(user) {
		return $http.post(baseUrl, JSON.stringify(user));
	};

	this.logout = function() {
		$http.get(baseUrl + "/logout");
	}
} ]);