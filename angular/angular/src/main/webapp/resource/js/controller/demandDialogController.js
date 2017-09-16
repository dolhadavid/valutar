app.controller("demandDialogController", [ '$routeParams', function() {

	this.cancel = function() {
		$mdDialog.cancel();
	};
} ]);
