app.service('registerService', [ '$http', function($http) {

	var baseUrl = 'http://localhost:8080/angular/rest/users';

	this.checkUser = function(user) {
		return $http.post(baseUrl, JSON.stringify(user));
	};

	this.addUser = function(user) {

	};
} ]);