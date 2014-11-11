var parsePushNotification = {
    subscribe: function(param, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'ParsePushNotification', 'subscribe',[{
			'channel': param.channel
		}]);
    }
};

module.exports = parsePushNotification;