package identity.omboi.com.uploadingreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by pomboi on 10/20/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        // For our recurring task, we'll just display a message
        Toast.makeText(context, "I'm running end month happy", Toast.LENGTH_SHORT).show();

        Intent songIntent = new Intent(context, ringTune.class);  //song class contain media song
        songIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(songIntent);
    }
}
