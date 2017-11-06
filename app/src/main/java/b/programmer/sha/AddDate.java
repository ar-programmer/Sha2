package b.programmer.sha;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.concurrent.RecursiveTask;

/**
 * Created by alexanderrabau on 04.11.17.
 */

public class AddDate extends AppCompatActivity {

    static final int DIALOG_ID = 0;

    int year_x, month_x, day_x;

    DatePicker myDatePicker;

    String reportDateDay;

    String reportDateYear;

    String reportDateMonth;

    int i = 0;

    int c = 0;

    DatePickerDialog.OnDateSetListener mDateSetListener;

    DatePicker.OnDateChangedListener onDateChangedListener;



//    int c = 0;

    Boolean checkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date);



        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
        i = sharedPref.getInt("loud", 0);

        i++;

        sharedPref.edit().putInt("loud", i).apply();

        //    SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
        //    checkin = sharedPref.getBoolean("keyo " + c, false);


        final java.util.Calendar c = java.util.Calendar.getInstance();
        int year = c.get(java.util.Calendar.YEAR);
        final int month = c.get(java.util.Calendar.MONTH);
        final int day = c.get(java.util.Calendar.DAY_OF_MONTH);


        DatePicker.OnDateChangedListener dateSetListener = new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                Calendar c = java.util.Calendar.getInstance();
                c.set(year, monthOfYear, dayOfMonth);


                year_x = year;
                month_x = monthOfYear;
                day_x = dayOfMonth;


            }
        };


        myDatePicker = (DatePicker) findViewById(R.id.date_picker);
        myDatePicker.init(year, month, day, dateSetListener);


    }


    public void clickButton(View view) {


        Button button = (Button) findViewById(R.id.button);

        System.out.println("TEST " + year_x + month_x + day_x);

    }




 /*   if (checkin == true) {
        EventDecorator2 eventDecorator = new EventDecorator2(getResources().getColor(R.color.colorPrimaryDark), dates, this);
        materialCalendarView.addDecorator(eventDecorator);

}
*/
/*
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
        if (view.isShown()) {
            myDatePicker.updateDate(year, monthOfYear, dayOfMonth);
            System.out.println("TEST " + year + monthOfYear + dayOfMonth);
        }
    }  */



    public void onCheckBoxClick(View view) {


        CheckBox  checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked() == true) {


        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);


        c = sharedPref.getInt("nuevo", 0);  // get stored int Value

        c++;                                   // add one to the stored Value

        sharedPref.edit().putInt("nuevo", c).apply();   // save the new value



        String key = "keyo " + c;
        sharedPref.edit()
                .putBoolean(key, true)
                .apply();



         //   DateFormat df = new SimpleDateFormat("yyyy");
         //   int today = year_x;
            reportDateYear = Integer.toString(year_x);
            sharedPref.edit().putString("yearo" + i, reportDateYear).apply();


           // DateFormat dfm = new SimpleDateFormat("MM");
          //  int todayM = month_x;
            reportDateMonth = Integer.toString(month_x);
            sharedPref.edit().putString("montho" + i, reportDateMonth).apply();


           // DateFormat dfd = new SimpleDateFormat("d");
          //  int todayD =
            reportDateDay =   Integer.toString(day_x);
            sharedPref.edit().putString("tomato23" + i, reportDateDay).apply();


            System.out.println("TEST " + i + "  " + reportDateDay + "   " +reportDateMonth + "    " + reportDateYear);
        }


    }
}
