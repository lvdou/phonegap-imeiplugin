function IMEIPlugin() {
	this.getImei = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "imeiplugin", "getImei", []);
	}
}

if(!window.plugins) {
	window.plugins = {}
}

window.plugins.imeiplugin = new IMEIPlugin();
