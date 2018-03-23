window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.skill = window.blockly.js.blockly.skill || {};
window.blockly.js.blockly.skill.SkillController = window.blockly.js.blockly.skill.SkillController
		|| {};

var item, addedChips, currentChip, finalChip, flag, i, myClickEvent, searchedSkill;

/**
 * Describe this function...
 */
window.blockly.js.blockly.skill.SkillController.openMdDialog = function(
		myClickEvent) {
	finalChip = this.cronapi.myfunctions.createEmptyObject();
	this.cronapi.myfunctions.setObjectValueNoReturn(finalChip,
			'contentElement', '#myDialog');
	this.cronapi.myfunctions.setObjectValueNoReturn(finalChip, 'targetEvent',
			myClickEvent);
	this.cronapi.myfunctions.setObjectValueNoReturn(finalChip,
			'clickOutsideToClose', true);
	this.cronapi.myfunctions.setObjectValueNoReturn(finalChip, 'title', 'User');
	this.cronapi.myfunctions.showMdDialog(finalChip);
}

/**
 * SkillController
 */
window.blockly.js.blockly.skill.SkillController.getSkills = function(
		searchedSkill) {
	return this.cronapi.util.callServerBlockly(
			'blockly.userskill.UserSkillController:getSkills', searchedSkill);
}

/**
 * Describe this function...
 */
window.blockly.js.blockly.skill.SkillController.addSkillChip = function(
		currentChip, addedChips) {
	flag = false;
	for ( var i_index in addedChips) {
		i = addedChips[i_index];
		if (this.cronapi.object.getProperty(this.cronapi.object.getProperty(i,
				'skill'), 'id') == this.cronapi.object.getProperty(
				this.cronapi.object.getProperty(currentChip, 'skill'), 'id')) {
			flag = true;
		}
	}
	if (flag) {
		return null;
	}
	return currentChip;
}
