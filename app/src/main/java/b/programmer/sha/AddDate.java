package b.programmer.sha;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDate extends AppCompatActivity {

    static final int DIALOG_ID = 0;

    int year_x, month_x, day_x;

    DatePicker myDatePicker;

    String reportDateDay;

    String reportDateYear;

    String reportDateMonth;

    String key;

    int i = 0;

    int a = 0;

    int c = 0;

    boolean afterAddDate;
     CheckBox checkBox = null;
     CheckBox falsecheckBox = null;


    DatePickerDialog.OnDateSetListener mDateSetListener;

    DatePicker.OnDateChangedListener onDateChangedListener;

    boolean value = true;

    Boolean checkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date);


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


    public void onCheckBoxClick(View view) {

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

        c = sharedPref.getInt("nuevo", 0);  // get stored int Value

        c++;
        // add one to the stored Value

        sharedPref.edit().putInt("nuevo", c).apply();   // save the new value

        i = sharedPref.getInt("loud", 0);


        System.out.println("After getting i value    " + i);

        i++;

        sharedPref.edit().putInt("loud", i).apply();



        falsecheckBox = (CheckBox) findViewById(R.id.falseCheckBox);
        checkBox = (CheckBox) findViewById(R.id.checkBox);



        sharedPref.edit().putBoolean("afterAddDate", true).apply();




        switch (view.getId()) {

            case R.id.checkBox:

                if (checkBox.isChecked()) {
                    falsecheckBox.setEnabled(false);


                     key = "keyo " + c;

                    value = true;




                }else{
                    checkBox.setEnabled(true);
                    falsecheckBox.setEnabled(true);

                }
                break;

            case R.id.falseCheckBox:
                if(falsecheckBox.isChecked()) {
                    checkBox.setEnabled(false);

                    value = false;

                   key = "keyo " + c;



                } else {

                    checkBox.setEnabled(true);
                    falsecheckBox.setEnabled(true);


                }
                break;

        }


        }


    public void onConfirmButtonClick(View view) {


        System.out.println(reportDateDay + "    der berüchtigte tag");

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

/*
        i--;
        sharedPref.edit().putInt("loud", i).apply();
        String reportDate = sharedPref.getString("tomato23" + i, null);

        System.out.println(reportDate + "    der berüchtigte tag");


        try {

            if (reportDateDay.equals(reportDate)) {

                System.out.println("hallelujah");
                System.out.println(reportDateDay);
                System.out.println(reportDate);
                c--;
                sharedPref.edit().putInt("nuevo", c).apply();
                i--;
                sharedPref.edit().putInt("loud", i).apply();


                //     sharedPref.edit().putBoolean("goneBackToDate", true).apply();

            }

            else {
                Toast.makeText(this, "You can not introduce a lalala",
                        Toast.LENGTH_LONG).show();
            }


        } catch (NullPointerException e){

            Toast.makeText(this, "You can not introduce a lalala",
                    Toast.LENGTH_LONG).show();
            System.out.println("CAUGHT U ");
        }




        i++;
        sharedPref.edit().putInt("loud", i).apply();


*/






        falsecheckBox.setChecked(false);
        checkBox.setChecked(false);
        falsecheckBox.setEnabled(true);
        checkBox.setEnabled(true);

    //    SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);








        sharedPref.edit()
                            .putBoolean(key, value)
                            .apply();


                 reportDateYear = Integer.toString(year_x);
                    sharedPref.edit().putString("yearo" + i, reportDateYear).apply();


                    reportDateMonth = Integer.toString(month_x + 1);
                    sharedPref.edit().putString("montho" + i, reportDateMonth).apply();


                    reportDateDay =   Integer.toString(day_x);
                    sharedPref.edit().putString("tomato23" + i, reportDateDay).apply();


                    System.out.println("TEST " + i + "  " + reportDateDay + "   " +reportDateMonth + "    " + reportDateYear);




 System.out.println(reportDateDay + "    der berüchtigte tag");






/*




        String stringDateD = sharedPref.getString("tomato23" + i, null);

        i = sharedPref.getInt("loud", 0);


        System.out.println("After getting i value    " + i);

        i--;



        sharedPref.edit().putInt("loud", i).apply();


        String reportDate = sharedPref.getString("tomato23" + i, null);





        //    DateFormat dfd = new SimpleDateFormat("d");
        //  Date todayD = java.util.Calendar.getInstance().getTime();

        //  String reportDateDay = dfd.format(todayD);
        //   System.out.println("reportDateDay  " + reportDateDay);

        System.out.println("StringDate  " + stringDateD);


        try {

            if (stringDateD.equals(reportDate)) {

                System.out.println("hallelujah");
                System.out.println(dateAgain);
                System.out.println(reportDate);
                c--;
                sharedPref.edit().putInt("nuevo", c).apply();
                i--;
                sharedPref.edit().putInt("loud", i).apply();


                //     sharedPref.edit().putBoolean("goneBackToDate", true).apply();

            }

            else {
                Toast.makeText(this, "You can not introduce a lalala",
                        Toast.LENGTH_LONG).show();
            }


        } catch (NullPointerException e){

            Toast.makeText(this, "You can not introduce a lalala",
                    Toast.LENGTH_LONG).show();
            System.out.println("CAUGHT U ");
        }





*/





    }







    @Override
    public void onBackPressed()
    {
        CheckBox  falsecheckBox = (CheckBox) findViewById(R.id.falseCheckBox);
        CheckBox  checkBox = (CheckBox) findViewById(R.id.checkBox);
        // code here to show dialog
        super.onBackPressed();
        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

        sharedPref.edit().putBoolean("goneBackToDate", true).apply();
        Boolean setI = sharedPref.getBoolean("setI", false);
        String dateAgain = sharedPref.getString("dateAgain", null);
        if (setI == true) {

                DateFormat dfd = new SimpleDateFormat("d");
                Date todayD = java.util.Calendar.getInstance().getTime();

                String reportDateDay = dfd.format(todayD);
                System.out.println("reportDateDay  " + reportDateDay);

                System.out.println("dateAgain  " + dateAgain);


                try {
                    if (dateAgain.equals(reportDateDay)) {


                Toast.makeText(this, "YOU CAN NOT CHANGE A VALUE AFTER HAVING ADDED A NEW DATE",
                        Toast.LENGTH_LONG).show();
                MainActivity.falsecheckBox.setChecked(false);
                MainActivity.checkBox.setChecked(false);
                MainActivity.falsecheckBox.setEnabled(false);
                MainActivity.checkBox.setEnabled(false);
            } }catch (NullPointerException e){
                System.out.println("Caught u too :)");
            }
        }


    }


    }
