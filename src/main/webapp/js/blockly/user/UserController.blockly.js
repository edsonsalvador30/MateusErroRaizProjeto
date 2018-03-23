window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.user = window.blockly.js.blockly.user || {};
window.blockly.js.blockly.user.UserController = window.blockly.js.blockly.user.UserController
		|| {};

var userToCopy, content2, modalId, user, skills;

/**
 * Describe this function...
 */
window.blockly.js.blockly.user.UserController.copyUser = function(userToCopy) {
	this.cronapi.myfunctions.setObjectValueNoReturn(this.cronapi.screen
			.getScopeVariable('users'), 'copy', this.cronapi.myfunctions
			.createCopy(userToCopy));
}

/**
 * Describe this function...
 */
window.blockly.js.blockly.user.UserController.upload = function(content2) {
	this.cronapi.myfunctions.setObjectValueNoReturn(this.cronapi.myfunctions
			.getRootScope(), 'valueTxt', content2);
}

/**
 * Describe this function...
 */
window.blockly.js.blockly.user.UserController.getLoggedUser = function() {
	return this.cronapi.util
			.callServerBlockly('blockly.user.UserController:getLoggedUser')[0];
}

/**
 * Describe this function...
 */
window.blockly.js.blockly.user.UserController.getUsers = function() {
	if (this.cronapi.logic
			.isNull(this.cronapi.screen.getScopeVariable('users'))) {
		this.cronapi.screen.createScopeVariable('users',
				this.cronapi.myfunctions.createEmptyObject());
	}
	this.cronapi.myfunctions.setObjectValueNoReturn(this.cronapi.screen
			.getScopeVariable('users'), 'data', this.cronapi.util
			.callServerBlockly('blockly.user.UserController:getUsers',
					this.cronapi.object.getProperty(this.cronapi.screen
							.getScopeVariable('users'), 'searchText')));
}

/**
 * UserController
 */
window.blockly.js.blockly.user.UserController.saveUser = function(user, skills,
		modalId) {
	if (this.cronapi.logic.isNull(this.cronapi.object.getProperty(user, 'id'))) {
		this.cronapi.myfunctions
				.setObjectValueNoReturn(
						user,
						'id',
						this.cronapi.util
								.callServerBlockly('blockly.utils.Utility:getUniversalId'));
	}
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.user.UserController:saveUser', user);
	this.cronapi.util
			.callServerBlocklyNoReturn(
					'blockly.userskill.UserSkillController:saveUserSkill',
					skills, user);
	this.cronapi.screen.hideModal(modalId);
	this.cronapi.screen.notify('success', 'User saved');
}

/**
 * Describe this function...
 */
window.blockly.js.blockly.user.UserController.getActiveSkillLevels = function() {
	this.cronapi.myfunctions
			.setObjectValueNoReturn(
					this.cronapi.screen.getScopeVariable('users'),
					'skillLevels',
					this.cronapi.util
							.callServerBlockly('blockly.skilllevel.SkillLevelController:getSkillLevels'));
}
