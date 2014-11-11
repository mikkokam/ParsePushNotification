var parsePushNotification = {
	initialize: function(param, successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, 'ParsePushNotification', 'subscribe',[{
		}]);
	},
    subscribe: function(param, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'ParsePushNotification', 'subscribe',[{
			'channel': param.channel
		}]);
    }
};

module.exports = parsePushNotification;