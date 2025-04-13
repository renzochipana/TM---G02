package com.example.timepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    DatePicker datePicker;
    int hour, minute;
    static final int TIME_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(
                        this, mTimesetListener, hour, minute, true
                );
        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener mTimesetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
            hour = hourOfDay;
            minute = minuteOfHour;

            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
            Date date = new Date(0, 0, 0, hour, minute);
            String strDate = timeFormat.format(date);
            Toast.makeText(getBaseContext(), "You have selected: " + strDate, Toast.LENGTH_SHORT).show();
        }
    };

    public void onClick(View view) {
        String selectedTime = "Hora seleccionada: " + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth() + "/" +
                datePicker.getYear() + "\n" + "Tiempo seleccionado: " + timePicker.getHour() + ":" +
                (timePicker.getMinute() < 10 ? "0" + timePicker.getMinute() : timePicker.getMinute());

        Toast.makeText(getBaseContext(), selectedTime, Toast.LENGTH_SHORT).show();
    }
}