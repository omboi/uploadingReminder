package identity.omboi.com.uploadingreminder;
/**
 * Created by pomboi on 10/20/2016.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends Activity {

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);

        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);

        manager.cancel(pendingIntent);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear=calendar.get(Calendar.YEAR);
        calendar.set(Calendar.MONTH, currentMonth);



        if (currentMonth == Calendar.JANUARY || currentMonth == Calendar.MARCH || currentMonth == Calendar.MAY || currentMonth == Calendar.JULY
                || currentMonth == Calendar.AUGUST || currentMonth == Calendar.OCTOBER || currentMonth == Calendar.DECEMBER) {
            // calendar.add(Calendar.DAY_OF_MONTH,31);
            calendar.set(Calendar.HOUR_OF_DAY, 12);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 31);

            manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }

        if (currentMonth == Calendar.APRIL || currentMonth == Calendar.JUNE || currentMonth == Calendar.SEPTEMBER
                || currentMonth == Calendar.NOVEMBER) {
            //  calendar.add(Calendar.DAY_OF_MONTH,30);
            calendar.set(Calendar.HOUR_OF_DAY, 12);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 30);

            manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        }

        if (currentMonth == Calendar.FEBRUARY) {//for feburary month)
            GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
            if (cal.isLeapYear(currentYear)) {//for leap year feburary month
                //calendar.add(Calendar.DAY_OF_MONTH,29);
                calendar.set(Calendar.HOUR_OF_DAY, 12);
                calendar.set(Calendar.MINUTE, 30);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.DAY_OF_MONTH, 29);
                manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

            } else { //for non leap year feburary month
                // calendar.add(Calendar.DAY_OF_MONTH,28);
                calendar.set(Calendar.HOUR_OF_DAY, 12);
                calendar.set(Calendar.MINUTE, 30);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.DAY_OF_MONTH, 28);
                manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        }

        Toast.makeText(this, "will start at 12:30am", Toast.LENGTH_SHORT).show();

        finish();
    }

}