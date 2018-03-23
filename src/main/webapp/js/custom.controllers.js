var myMainapp = angular.module('MyApp');

myMainapp.requires.push('ngMaterial');
myMainapp.requires.push('ngMessages');
myMainapp.requires.push('ngStorage');

app.controller('AfterLoginController', function($scope) {
	//
	console.log('AfterLoginController');
});

app.controller('AfterHomeController', function($scope, $mdDialog, $rootScope) {
	//
	$rootScope.$mdDialog = $mdDialog;
});

app.controller('AfterPageController', function($scope) {
	//
	console.log('AfterPageController');
});

myMainapp.controller('TestController', function($scope) {

	$scope.addChip = function(chip) {
		UserSkillsGrid.startInserting();
		console.log('item: ');
		UserSkillsGrid.active.skill = chip;
		console.log(UserSkillsGrid.active.skill);
		UserSkillsGrid.post();
		return UserSkillsGrid.active;
	}
	//
});
