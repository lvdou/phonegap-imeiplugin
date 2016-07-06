var cordova = require('cordova');
var androidIMEI = {
    	
  function IMEIPlugin() {
	this.getImei = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "androidIMEI", "getImei", []);
	}
  }
}

module.exports = androidIMEI;
