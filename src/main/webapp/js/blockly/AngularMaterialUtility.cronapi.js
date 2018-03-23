(function() {
	'use strict';

	this.cronapi == null ? this.cronapi = {} : null;
	/**
	 * @categoryName AngularMaterial
	 */
	this.cronapi.myfunctions == null ? this.cronapi.myfunctions = {} : null;

	/**
	 * @type function
	 * @name showMdDialog
	 * @description Function Description
	 * @multilayer false
	 * @param {ObjectType.OBJECT} input Param Description
	 */
	this.cronapi.myfunctions.showMdDialog = function(/** @type {ObjectType.OBJECT} @description Parameter */config) {
	  this.cronapi.$scope.$root.$mdDialog.show(config);
	};

}).bind(window)();