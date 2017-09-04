app.service('userService', [ '$http', function($http) {

	var baseUrl = 'http://localhost:8080/angular/rest/users';

	this.getFriends = function() {
		return $http.get(baseUrl + "/friends");
	};

	this.getFriendsRequest = function() {
		return $http.get(baseUrl + "/friendsRequest");
	};

} ]);