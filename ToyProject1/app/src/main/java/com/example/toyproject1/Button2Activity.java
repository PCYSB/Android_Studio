package com.example.toyproject1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker; //타임피커 스피너 텍스트연동

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Button2Activity extends AppCompatActivity {
    private TextView textView;
    private TimePicker timePicker;
    private TimePicker timePicker2;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);

        textView = findViewById(R.id.textView);
        timePicker = findViewById(R.id.timePicker);

        timePicker2 = (TimePicker) findViewById(R.id.timePicker);
        save = (Button) findViewById(R.id.save);  //알람 매니져 변수

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textView.setText(hourOfDay + "시" + minute + "분");
            }
        });    //스피너와 텍스트 연동
       // @RequiresApi(api = Build.VERSION_CODES.M)

        save.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int hour = timePicker2.getHour();
            int minute = timePicker2.getMinute();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }


            AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            if (alarmManager != null) {
                Intent intent = new Intent(this, AlarmReceiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, alarmIntent);

                Toast.makeText(Button2Activity.this, "알람이 저장되었습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }
}