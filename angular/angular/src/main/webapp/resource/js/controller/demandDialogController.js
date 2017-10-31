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
	
	this.openCreateOfferDialog = function(ev) {
		$mdDialog.show({
			templateUrl : 'offerDialog.tmpl.html',
			controller : 'offerController',
			controllerAs : 'offer',
			windowClass: 'app-modal-window',
			parent : angular.element(document.body),
			targetEvent : ev,
			clickOutsideToClose : true,
			fullscreen : false
		});
	}
} ]);
