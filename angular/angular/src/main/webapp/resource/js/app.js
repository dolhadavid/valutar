var app = angular.module("appModule", [ 'ngRoute', 'ngMaterial', 'ngCookies' ]);

app.config(function($routeProvider, $locationProvider) {
	// $locationProvider.html5Mode({
	// enabled : true
	// });

	$routeProvider.when('/', {
		templateUrl : 'login.html',
		resolve : {
			"check" : function($location, loginService, $cookies) {
				if ($cookies.isLogged != null) {
					if (JSON.parse($cookies.isLogged) === true) {
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
			"check" : function($location, loginService, $cookies) {
				if ($cookies.isLogged != null) {
					if (JSON.parse($cookies.isLogged) === true) {
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
	}).when(
			'/home/:user',
			{
				templateUrl : 'userinfo.html',
				resolve : {
					"check" : function($location, loginService, $routeParams,
							$cookies) {
						if (JSON.parse($cookies.isLogged) === null) {
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