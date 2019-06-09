package com.example.tranquil;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.media.TimedMetaData;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class Reminder extends AppCompatActivity {
    ToggleButton toggleButton;
    Button button;
    TimePicker time1;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static Reminder inst;
    private TextView alarmTextView;

    public static Reminder instance() {
        return inst;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton2);
        button = (Button) findViewById(R.id.set_button);
        time1 = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        time1.setEnabled(false);

        button.setEnabled(false);

        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (toggleButton.isChecked()) {
                    //Enabling button on toggle button on.
                    button.setEnabled(true);
                    time1.setEnabled(true);
                } else {
                    //Disabling button on toggle button off.
                    button.setEnabled(false);
                    time1.setEnabled(false);
                }
            }
        });

    }

    public void setTime(View v) {

        Log.d("Reminder", "Alarm On");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
        Intent myIntent = new Intent(Reminder.this, AlarmReciever.class);
        pendingIntent = PendingIntent.getBroadcast(Reminder.this, 0, myIntent, 0);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

    }
}


