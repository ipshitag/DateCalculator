package com.example.datecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    private TextView stDate;
    private TextView enDate;
    private TextView reDate;
    int endate,enyear,enmonth;
    int stdate,styear,stmonth;

    private DatePickerDialog.OnDateSetListener dateSetListener;
    private DatePickerDialog.OnDateSetListener edateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stDate = (TextView) findViewById(R.id.startDate);
        enDate = (TextView) findViewById(R.id.endDate);
        reDate = (TextView) findViewById(R.id.resultDate);

        stDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int syear = cal.get(Calendar.YEAR);
                int smonth = cal.get(Calendar.MONTH);
                int sday = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog
                        (MainActivity.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                dateSetListener,
                                syear,smonth,sday);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month++;
                String stdt = day + "/" + month + "/" + year;
                stDate.setText(stdt);
                styear = year;
                stmonth = month;
                stdate = day;
            }
        };




        enDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int eyear = cal.get(Calendar.YEAR);
                int emonth = cal.get(Calendar.MONTH);
                int eday = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog
                        (MainActivity.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                edateSetListener,
                                eyear,emonth,eday);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        edateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month++;
                String stdt = day + "/" + month + "/" + year;
                enDate.setText(stdt);
                endate = day;
                enmonth = month;
                enyear = year;
            }
        };
    }
}
