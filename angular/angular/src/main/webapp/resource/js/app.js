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
						if (JSON.parse($cookies.isLogged) === false) {
							$location.path('/');
						}
					}
				},
				controller : 'userInfoController',
				controllerAs : 'userInfo'
			}).otherwise({
		redirectTo : '/'
	});

	// $mdThemingProvider.definePalette('paletamea', {
	// '50': 'fde0e0',
	// '100': 'fab3b3',
	// '200': 'f78080',
	// '300': 'f34d4d',
	// '400': 'f12626',
	// '500': 'ee0000',
	// '600': 'ec0000',
	// '700': 'e90000',
	// '800': 'e70000',
	// '900': 'e20000',
	// 'A100': '818181',
	// 'A200': 'ffd6d6',
	// 'A400': 'ffa3a3',
	// 'A700': 'ff8a8a',
	// 'contrastDefaultColor': 'light',
	// 'contrastDarkColors': [
	// '50',
	// '100',
	// '200',
	// 'A100',
	// 'A200',
	// 'A400',
	// 'A700'
	// ],
	// 'contrastLightColors': [
	// '300',
	// '400',
	// '500',
	// '600',
	// '700',
	// '800',
	// '900'
	// ]
	// });
	//
	//	
	// $mdThemingProvider.theme('default').primaryPalette('paletamea');

});