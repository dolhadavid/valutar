app.controller("demandDialogController", ['$scope','demandService', function($scope,demandService) {

	$scope.myDemands = [];

	init();

	function init() {
		getMyDemands();
	}

	function getMyDemands() {
		demandService.getAllDemandsByUser().then(function success(response) {
			$scope.myDemands = response.data;
		});
	}
} ]);
