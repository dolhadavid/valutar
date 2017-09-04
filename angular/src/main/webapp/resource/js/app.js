var app = angular.module("appModule", [ 'ngRoute', 'ngMaterial' ]);

app.config(function($routeProvider, $locationProvider) {
	// $locationProvider.html5Mode({
	// enabled : true
	// });

	$routeProvider.when('/', {
		templateUrl : 'login.html',
		resolve : {
			"check" : function($location, loginService) {
				if (sessionStorage.isLogged != null) {
					if (JSON.parse(sessionStorage.isLogged) === true) {
						$location.path('/home');
					} else {
						$location.path('/');
					}
				} else {
					$location.path('/');
				}
			}
		},
		controller : 'userController',
		controllerAs : 'user'
	}).when('/home', {
		templateUrl : 'home.html',
		resolve : {
			"check" : function($location, loginService) {
				if (sessionStorage.isLogged != null) {
					if (JSON.parse(sessionStorage.isLogged) === true) {
						$location.path('/home');
					} else {
						$location.path('/');
					}
				} else {
					$location.path('/');
				}
			}
		},
		controller : 'homeController',
		controllerAs : 'home'
	}).when('/register', {
		templateUrl : 'register.html',
		controller : 'registerController',
		controllerAs : 'register'
	}).when('/home/:user', {
		templateUrl : 'userinfo.html',
		resolve : {
			"check" : function($location, loginService, $routeParams) {
				if (JSON.parse(sessionStorage.isLogged) === true) {
					console.log($routeParams);
					$location.path('/home/' + $routeParams.user);
				} else {
					$location.path('/');
				}
			}
		},
		controller : 'userInfoController',
		controllerAs : 'userInfo'
	}).otherwise({
		redirectTo : '/'
	});

});