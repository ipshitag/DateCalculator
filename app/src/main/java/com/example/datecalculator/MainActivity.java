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
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    private TextView stDate;
    private TextView enDate;
    private TextView reDate;
    int endate,enyear,enmonth;
    int stdate,styear,stmonth;
    Calendar ecal = Calendar.getInstance();
    Calendar scal = Calendar.getInstance();

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
                int syear = scal.get(Calendar.YEAR);
                int smonth = scal.get(Calendar.MONTH);
                int sday = scal.get(Calendar.DAY_OF_MONTH);

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
                scal.set(Calendar.YEAR,year);
                scal.set(Calendar.MONTH,month);
                scal.set(Calendar.DAY_OF_MONTH,day);
            }
        };




        enDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int eyear = ecal.get(Calendar.YEAR);
                int emonth = ecal.get(Calendar.MONTH);
                int eday = ecal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog
                        (MainActivity.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                edateSetListener,
                                eyear,emonth,eday);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                ecal.set(Calendar.YEAR,eyear);
                ecal.set(Calendar.MONTH,emonth);
                ecal.set(Calendar.DAY_OF_MONTH,eday);
            }
        });

        edateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month++;
                String stdt = day + "/" + month + "/" + year;
                enDate.setText(stdt);
                ecal.set(Calendar.YEAR,year);
                ecal.set(Calendar.MONTH,month);
                ecal.set(Calendar.DAY_OF_MONTH,day);
            }
        };

    }

    public void calculate(View view)
    {
        long a = ecal.getTimeInMillis();
        long b = scal.getTimeInMillis();
        long diff = a-b;
        //long diff = ecal.getTimeInMillis() - scal.getTimeInMillis();
        reDate.setText("Days: " + (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
    }
}
