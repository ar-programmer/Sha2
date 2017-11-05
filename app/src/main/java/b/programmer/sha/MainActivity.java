package b.programmer.sha;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {


    static final int DATE_PICKER_ID = 1111;


    CheckBox checkBox = null;
    String output = null;

    int c = 0;

    boolean value = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);


        c = sharedPref.getInt("nuevo", 0);  // get stored int Value

        c++;                                   // add one to the stored Value

        sharedPref.edit().putInt("nuevo", c).apply();   // save the new value

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        if (id == R.id.menu_calendar) {
            refresh();
        }


        if (id == R.id.menu_plus) {

            Intent j=new Intent(this, AddDate.class);

            startActivity(j);


       //     plus();

   //         showDatePickerDialog();

     /*       java.util.Calendar cal = java.util.Calendar.getInstance();
            int year = cal.get(java.util.Calendar.YEAR);
            int month = cal.get(java.util.Calendar.MONTH);
            int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
*/
          //  DatePicker datePicker = new DatePicker(this);

  /*          DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                    android.R.style.Theme_Holo_Light, mDateSetListener, 2017,11, 2);
            dialog.getWindow().setBackgroundDrawable((new ColorDrawable(Color.TRANSPARENT)));
            dialog.show(); */


        }




        return super.onOptionsItemSelected(item);
    }

 /*   public void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final java.util.Calendar c = java.util.Calendar.getInstance();
            int year = c.get(java.util.Calendar.YEAR);
            int month = c.get(java.util.Calendar.MONTH);
            int day = c.get(java.util.Calendar.DAY_OF_MONTH);


            @SuppressWarnings("ResourceType") DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                    AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);

            return datepickerdialog;

            // Create a new instance of DatePickerDialog and return it
           // return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }  */

   public void refresh(){
       Intent j=new Intent(this, Calendar.class);

       startActivity(j);

    }

    DatePickerDialog.OnDateSetListener mDateSetListener;


   /* public void plus(){

        Button button = (Button) findViewById(R.id.menu_plus);



    setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                java.util.Calendar cal = java.util.Calendar.getInstance();
                int year = cal.get(java.util.Calendar.YEAR);
                int month = cal.get(java.util.Calendar.MONTH);
                int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light, mDateSetListener, year,month, day);
                dialog.getWindow().setBackgroundDrawable((new ColorDrawable(Color.TRANSPARENT)));
                dialog.show();


            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            }
        };
    }  */

    public void onCheckBoxClick(View view) {

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked() == true) {


            iv.setImageResource(R.drawable.slightly_smiling_face_emoji);

            value = true;

            output = "congratulations, your on the right track!";


            String key = "keyo " + c;

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit()
                    .putBoolean(key, value)
                    .apply();



            String row5 = "row" + c;
            sharedPref.edit()
                    .putBoolean(row5, value)
                    .apply();



        }
        if (checkBox.isChecked() == false) {


            iv.setImageResource(0);


        }
    }


    public void onButtonNext(View view) {

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked() == false) {

            value = false;


            String key = "keyo" + c;   //WARUM IST HIER KEIN SPACE NACH DEM SCHLUESSEL??

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit()
                    .putBoolean(key, value)
                    .apply();



            String row5 = "row" + c;
            sharedPref.edit()
                    .putBoolean(row5, value)
                    .apply();


            iv.setImageResource(R.drawable.very_angry_emoji);

            output = "Damm";


        }

  /*      Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                // do something
            }
        }, 3000);

            Intent intent = new Intent(this, Calender.class);

            startActivity(intent);

*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {






               Intent j=new Intent(MainActivity.this, Calendar.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
         //       j.putExtra("output", newValue);
                startActivity(j);
            }
        }, 2500);
    }

}

