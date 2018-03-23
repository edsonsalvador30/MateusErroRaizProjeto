(function() {
	'use strict';

	this.cronapi == null ? this.cronapi = {} : null;

	/**
	 * @categoryName MyUtility
	 */
	this.cronapi.myfunctions == null ? this.cronapi.myfunctions = {} : null;

	/**
	 * @type function
	 * @name createEmptyObject
	 * @description 
	 * @multilayer false
	 * @returns {ObjectType.STRING}
	 */
	this.cronapi.myfunctions.createEmptyObject = function() {
		var obj = {};
		return obj;
	};

	/**
	 * @type function
	 * @name Set Object Value
	 * @description Function Description
	 * @multilayer false
	 * @param {ObjectType.OBJECT} object Param Description
	 * @param {ObjectType.STRING} key Param Description
	 * @param {ObjectType.OBJECT} value Param Description
	 * @returns {ObjectType.OBJECT}
	 */
	this.cronapi.myfunctions.setObjectValue = function(/** @type {ObjectType.OBJECT} @description Object */	object, /** @type {ObjectType.STRING} @description Key */	key, /** @type {ObjectType.OBJECT} @description Value */	value) {
		object[key] = value;
		return object;
	};

	/**
	 * @type function
	 * @name Set Object Value
	 * @description Function Description
	 * @multilayer false
	 * @param {ObjectType.OBJECT} object Param Description
	 * @param {ObjectType.STRING} key Param Description
	 * @param {ObjectType.OBJECT} value Param Description
	 */
	this.cronapi.myfunctions.setObjectValueNoReturn = function(/** @type {ObjectType.OBJECT} @description Object */	object, /** @type {ObjectType.STRING} @description Key */	key, /** @type {ObjectType.OBJECT} @description Value */ value) {
		object[key] = value;
	};

	/**
	 * @type function
	 * @name Copy an Object
	 * @description Function Description
	 * @multilayer false
	 * @param {ObjectType.OBJECT} object Param Description
	 * @returns {ObjectType.OBJECT}
	 */
	this.cronapi.myfunctions.createCopy = function(/** @type {ObjectType.OBJECT} @description Object */	object) {
		var copy = {};
		angular.copy(object, copy);
		return copy;
	};
	
	/**
	 * @type function
	 * @name Get Root Scope
	 * @description Function Description
	 * @multilayer false
	 * @returns {ObjectType.OBJECT}
	 */
	this.cronapi.myfunctions.getRootScope = function() {
		return this.cronapi.$scope.$root;
	};
	
		/**
	 * @type function
	 * @name Set Object VAlue
	 * @description Function Description
	 * @multilayer false
	 * @param {ObjectType.OBJECT} object Param Description
	 * @param {ObjectType.OBJECT} value Param Description
	 * @returns {ObjectType.OBJECT}
	 */
	this.cronapi.myfunctions.getRootScope = function(/** @type {ObjectType.OBJECT} @description Object */	object, /** @type {ObjectType.OBJECT} @description Value */	value) {
		return this.cronapi.$scope.$root;
	};

}).bind(window)();