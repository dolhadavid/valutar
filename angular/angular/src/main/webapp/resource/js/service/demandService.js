app.service('demandService', [ '$http', function($http) {

	var baseUrl = 'http://localhost:8080/angular/rest/demands';

	this.getAllDemands = function() {
		return $http.get(baseUrl);
	};

	this.getAllDemandsByUser = function() {
		return $http.get(baseUrl + "/userDemands");
	};
} ]);