package identity.omboi.com.uploadingreminder;

/**
 * Created by pomboi on 10/20/2016.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DeviceBootReceiver extends BroadcastReceiver {

    private PendingIntent pendingIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                // Set the alarm here.
                Intent i = new Intent(context, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

                /***** For start Service  ****/
                Intent myIntent = new Intent(context, service.class);
                context.startService(myIntent);
            }

        }

    }
