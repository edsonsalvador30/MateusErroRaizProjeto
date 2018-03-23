window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.utils = window.blockly.js.blockly.utils || {};
window.blockly.js.blockly.utils.BlockUtility = window.blockly.js.blockly.utils.BlockUtility
		|| {};

var item, id;

/**
 * BlockUtility
 */
window.blockly.js.blockly.utils.BlockUtility.openMyDialog = function(id) {
	this.cronapi.screen.showModal(id);
}
