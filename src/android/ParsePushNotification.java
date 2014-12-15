package jerry.shen.plugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.parse.Parse;
import com.parse.ParsePush;
import com.parse.ParseInstallation;

public class ParsePushNotification extends CordovaPlugin {
	public static final String ACTION_INITIALIZE = "initialize";
	public static final String ACTION_SUBSCRIBE = "subscribe";
	public static final String ACTION_GET_INSTALLATION_ID = "getInstallationId";
	public static final String ACTION_GET_INSTALLATION_OBJECT_ID = "getInstallationObjectId";	
	public String CHANNEL = "";
    
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_INITIALIZE.equals(action)) { 
				this.initialize(callbackContext, args);
				return true;
            }
			if (ACTION_SUBSCRIBE.equals(action)) {
				this.subscribe(callbackContext, args);
				return true;
			}
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		ParsePush.unsubscribeInBackground(CHANNEL);
		super.onDestroy();
	}
	
	private void initialize(final CallbackContext callbackContext, final JSONArray args) {
        cordova.getThreadPool().execute(new Runnable() {
    	    @SuppressWarnings("deprecation")
    		public void run() {
                try {
					JSONObject arg_object = args.getJSONObject(0);
                    String appId = arg_object.getString("App_ID");
                    String clientKey = arg_object.getString("Client_Key");
                    Parse.initialize(cordova.getActivity(), appId, clientKey);
                    callbackContext.success();
                } catch (JSONException e) {
                    callbackContext.error("JSONException");
                }
        	}
        });
	}
		
	private void subscribe(final CallbackContext callbackContext, final JSONArray args) {
        cordova.getThreadPool().execute(new Runnable() {
		    @SuppressWarnings("deprecation")
		    public void run() {
                try {               
					JSONObject arg_object = args.getJSONObject(0);
			  		CHANNEL = arg_object.getString("channel");
					ParsePush.subscribeInBackground(CHANNEL);
                	callbackContext.success();
	                } catch (JSONException e) {
                	    callbackContext.error("JSONException");
                    }
        	    }
    	});
	}
	    
	private void getInstallationId(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
        	public void run() {
            	String installationId = ParseInstallation.getCurrentInstallation().getInstallationId();
            	callbackContext.success(installationId);
    	    }
        });
	}
	
	private void getInstallationObjectId(final CallbackContext callbackContext) {
    	cordova.getThreadPool().execute(new Runnable() {
    		public void run() {
            	String objectId = ParseInstallation.getCurrentInstallation().getObjectId();
            	callbackContext.success(objectId);
        	}
        });
	}
   
}
