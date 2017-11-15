package b.programmer.sha;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import java.util.Calendar;

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


    DatePickerDialog.OnDateSetListener mDateSetListener;

    DatePicker.OnDateChangedListener onDateChangedListener;

    boolean value = true;

    Boolean checkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date);

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

        c = sharedPref.getInt("nuevo", 0);  // get stored int Value

        c++;
      // add one to the stored Value

        sharedPref.edit().putInt("nuevo", c).apply();   // save the new value


        i = sharedPref.getInt("loud", 0);


        System.out.println("After getting i value    " + i);

        i++;



        sharedPref.edit().putInt("loud", i).apply();

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

        sharedPref.edit().putBoolean("afterAddDate", true).apply();


        CheckBox  falsecheckBox = (CheckBox) findViewById(R.id.falseCheckBox);
        CheckBox  checkBox = (CheckBox) findViewById(R.id.checkBox);




        switch (view.getId()) {

            case R.id.checkBox:

                if (checkBox.isChecked()) {
                    falsecheckBox.setEnabled(false);





           /*         c = sharedPref.getInt("nuevo", 0);  // get stored int Value

                                      // add one to the stored Value

                    sharedPref.edit().putInt("nuevo", c).apply();   // save the new value */



                     key = "keyo " + c;

                    value = true;


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


                }else{
                    checkBox.setEnabled(true);
                    falsecheckBox.setEnabled(true);

                }
                break;

            case R.id.falseCheckBox:
                if(falsecheckBox.isChecked()) {
                    checkBox.setEnabled(false);





           /*         c = sharedPref.getInt("nuevo", 0);  // get stored int Value

                                       // add one to the stored Value

                    sharedPref.edit().putInt("nuevo", c).apply();   // save the new value  */



            /*        String key = "keyo " + c;
                    sharedPref.edit()
                            .putBoolean(key, false)
                            .apply();  */



                    value = false;

                   key = "keyo " + c;

                    sharedPref.edit()
                            .putBoolean(key, value)
                            .apply();


                    reportDateYear = Integer.toString(year_x);
                    sharedPref.edit().putString("yearo" + i, reportDateYear).apply();



                    reportDateMonth = Integer.toString(month_x +1);
                    sharedPref.edit().putString("montho" + i, reportDateMonth).apply();



                    reportDateDay =   Integer.toString(day_x);
                    sharedPref.edit().putString("tomato23" + i, reportDateDay).apply();


                    System.out.println("TEST " + i + "  " + reportDateDay + "   " +reportDateMonth + "    " + reportDateYear + "c" + c);




                } else {

                    checkBox.setEnabled(true);
                    falsecheckBox.setEnabled(true);


                }
                break;
        }




        System.out.println(key + value);


        }


    @Override
    public void onBackPressed()
    {
        CheckBox  falsecheckBox = (CheckBox) findViewById(R.id.falseCheckBox);
        CheckBox  checkBox = (CheckBox) findViewById(R.id.checkBox);
        // code here to show dialog
        super.onBackPressed();
        if (falsecheckBox.isChecked() == false && checkBox.isChecked() == false ) {
            i--;
            System.out.println("I Love you !!!");
            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit().putInt("loud", i).apply();

        }
     // optional depending on your needs
    }


    }
