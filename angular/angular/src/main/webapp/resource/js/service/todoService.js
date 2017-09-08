app.service('todoService', ['$http', function($http) {

	var baseUrl = 'http://localhost:8080/angular/rest/todos';
	
	this.getAll=function() {
		return $http.get(baseUrl);
	};

	this.createTodo = function(todoForm) {
		return $http.post(baseUrl,JSON.stringify(todoForm));
	};

	this.deleteTodo = function(id) {
		return $http.delete(baseUrl + '/' + id);
	};

	this.updateTodo = function(todoForm) {
		return $http.put(baseUrl,JSON.stringify(todoForm));
	};

} ]);