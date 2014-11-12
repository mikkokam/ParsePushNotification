var parsePushNotification = {
	initialize: function(param, successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, 'ParsePushNotification', 'initialize',[{
			App_ID: param.App_ID,
			Client_Key: param.Client_Key
		}]);
	},
    subscribe: function(param, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'ParsePushNotification', 'subscribe',[{
			'channel': param.channel
		}]);
    }
};

module.exports = parsePushNotification;