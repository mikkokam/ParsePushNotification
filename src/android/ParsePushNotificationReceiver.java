package jerry.shen.plugin;

import com.parse.ParsePushBroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ParsePushNotificationReceiver extends ParsePushBroadcastReceiver {

    @Override
    public void onPushOpen(Context context, Intent intent) {
        Log.e("Push", "Clicked");
        Log.e("TEST", intent.getClass().toString());
        Log.e("TEST", intent.getPackage());
		Log.e("TEST",  this.getClass().toString());
        Intent i = new Intent(context, this.getClass());
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}