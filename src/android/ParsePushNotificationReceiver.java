package jerry.shen.plugin;

import com.parse.ParsePushBroadcastReceiver;

import android.content.Context;
import android.content.Intent;

public class ParsePushNotificationReceiver extends ParsePushBroadcastReceiver {

    @Override
    public void onPushOpen(Context context, Intent intent) {
		String packageName = context.getPackageName();
		Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
		String className = launchIntent.getComponent().getClassName();
		try {
			Intent i;
			i = new Intent(context, Class.forName(className));
	        i.putExtras(intent.getExtras());
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        context.startActivity(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}