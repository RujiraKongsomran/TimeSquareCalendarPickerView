package com.rujirakongsomran.timesquarecalendarpickerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.calendarPickerView);
        datePicker.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calendarSelected = Calendar.getInstance();
                calendarSelected.setTime(date);

                String selectedDate = "" + calendarSelected.get(Calendar.DAY_OF_MONTH)
                        + " " + (calendarSelected.get(Calendar.MONTH) + 1)
                        + " " + calendarSelected.get(Calendar.YEAR);

                //Toast.makeText(MainActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
                SuperActivityToast.create(MainActivity.this, new Style())
                        .setText(selectedDate)
                        .setDuration(Style.DURATION_VERY_SHORT)
                        .setFrame(Style.FRAME_KITKAT)
                        .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE))
                        .setAnimations(Style.ANIMATIONS_POP).show();

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

    }
}