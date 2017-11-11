package b.programmer.sha;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

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

        }

        if (id == R.id.menu_trash) {


            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            boolean sharedPref = getSharedPreferences("sharePref", 0).edit().clear().commit();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to delete all data ?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();



        }




        return super.onOptionsItemSelected(item);
    }



   public void refresh(){


       Intent j=new Intent(this, Calendar.class);
        j.putExtra("use",false);

       startActivity(j);

    }

    DatePickerDialog.OnDateSetListener mDateSetListener;


    public void onCheckBoxClick(View view) {

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked() == true) {

            value = true;


            String key = "keyo " + c;   //WARUM IST HIER KEIN SPACE NACH DEM SCHLUESSEL??

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit().putBoolean(key, value).apply();





            iv.setImageResource(R.drawable.clementine_happy);

System.out.println("key und value    "   +  key + value);
/*
            System.out.println("key first site true  " +key);

            String row5 = "row" + c;
            sharedPref.edit().putBoolean(row5, value).apply();  */

        }

        if (checkBox.isChecked() == false) {

            iv.setImageResource(0); }
    }


    public void onButtonNext(View view) {

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked() == false) {


            System.out.println("R U TOUCHING");

            value = false;


            String key = "keyo " + c;   //WARUM IST HIER KEIN SPACE NACH DEM SCHLUESSEL??

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit().putBoolean(key, value).apply();



            String row5 = "row" + c;
            sharedPref.edit().putBoolean(row5, value).apply();


            iv.setImageResource(R.drawable.clementine_sad);

            output = "Damm";


        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {






               Intent j=new Intent(MainActivity.this, Calendar.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
         //       j.putExtra("output", newValue);


                j.putExtra("use",true);
                startActivity(j);
            }
        }, 2500);
    }

}

