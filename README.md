DEPRECEATED.
============

DO NOT USE THIS ONE.
Try the other one below - managed to get that working with all the features.

https://github.com/mikkokam/parse-push-plugin



ParsePushNotification
============

Parse push notifications for PhoneGap. Android only for now.

**Works on Adobe PhoneGap Build.**

PGB does not have any Parse Push plugins in the directory yet.
Most of the plugins fail to upload either because of using a reserved namespace (cordova or phonegap).
Others can be uploaded, but PGB fails to add them.

Forked this as this was one of the only ones I managed to upload and use.

**Install**

Do not download anything from here. Copy the repo link and use it at "Your plugins" in Adobe PhoneGap Build. After uploading, you get the line (with the name):
`<gap:plugin name="**name**" version="0.1.0" />`
Add it to your config.xml.

In your javascript:

```
if(window.parsePushNotification){
    window.parsePushNotification.initialize(
        {
            App_ID: "**Your Parse app ID here**",
            Client_Key: "**Your Parse client key here**"
        },
        function(data){
            // SUCCESS
            console.log("PUSH initialize success");
            console.log(data); // data is the installation ID
        },
        function(data){
            // FAIL
            console.log("PUSH initialize error");
            console.log(data);
        }
    );
}
```

This will register your device.
  
  
Likewise / check the javascript - comments and examples later:

**TESTED (should be OK):**

window.parsePushNotification.getInstallationId

window.parsePushNotification.getInstallationObjectId

**UNTESTED (work in progress):**

window.parsePushNotification.subscribe

window.parsePushNotification.getSubscriptions

window.parsePushNotification.unsubscribe



The code needs a bit of modifications -  and missed some Parse Push functions / adding them here.

iOS is on the todo-list later.
