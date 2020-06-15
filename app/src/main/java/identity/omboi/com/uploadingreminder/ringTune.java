package identity.omboi.com.uploadingreminder;

/**
 * Created by pomboi on 10/20/2016.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

public class ringTune extends Activity{
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ring);
        m=MediaPlayer.create(getApplicationContext(), R.raw.firefly);

        m.start();

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(ringTune.this);
        dlgAlert.setTitle("Remainder !");
        dlgAlert.setMessage("Dear CSO, Please this is to remind you to upload your data! Thanks...");
        dlgAlert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                m.stop();
                dialog.cancel();
            }
        });
        dlgAlert.show();
    }
}