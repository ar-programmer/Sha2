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
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static final int DATE_PICKER_ID = 1111;

   static CheckBox checkBox = null;
   static CheckBox falsecheckBox = null;

    ImageView iv;
    String output = null;

    int c = 0;

    boolean value = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     /*   SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);


        c = sharedPref.getInt("nuevo", 0);  // get stored int Value

        c++;                                   // add one to the stored Value

        sharedPref.edit().putInt("nuevo", c).apply();   // save the new value   */




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

/*
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

            System.out.println("key first site true  " +key);

            String row5 = "row" + c;
            sharedPref.edit().putBoolean(row5, value).apply();

       }

       if (checkBox.isChecked() == false) {

            iv.setImageResource(0); }
    }



*/


/*  @Override
public void onResume() {
    super.onResume();

    SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
    Boolean setI = sharedPref.getBoolean("setI", false);
      String dateAgain = sharedPref.getString("dateAgain", null);


    if (setI == true) {


// iv.setImageResource(0);


   int i = sharedPref.getInt("loud", 0);
        String stringDateD = sharedPref.getString("tomato23" + i, null);


        DateFormat dfd = new SimpleDateFormat("d");
        Date todayD = java.util.Calendar.getInstance().getTime();

        String reportDateDay = dfd.format(todayD);
        System.out.println("reportDateDay  " + reportDateDay);

        System.out.println("stringDateD  " + stringDateD);

        if (reportDateDay.equals(stringDateD)) {


            // sharedPref.edit().putInt("loud", 0).apply();


            System.out.println("I Love you !!!Main   " + i);
        }

try {
    if (dateAgain.equals(reportDateDay)) {

        System.out.println("hallelujah");
        System.out.println(dateAgain);
        System.out.println(reportDateDay);
        c--;
        sharedPref.edit().putInt("nuevo", c).apply();
        i--;
        sharedPref.edit().putInt("loud", i).apply();


    }
} catch (NullPointerException e){
    System.out.println("CAUGHT U ");
}

        System.out.println(dateAgain);
        System.out.println(reportDateDay);

    }
}
*/


// On checkBoxClick wird beim zweiten Mal 2 Mal durchlaufen beim ersten aber nur einmal oder ????

    // Ich meine der erste Klick wird noch registriet es muss ausgecklickt werden zum ende der Methde!?





    // if Date afterwards added w

    public void onCheckBoxClick(View view) {


        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

        Boolean setI = sharedPref.getBoolean("setI", false);
        String dateAgain = sharedPref.getString("dateAgain", null);


    //    if (setI == true) {


// iv.setImageResource(0);


            int i = sharedPref.getInt("loud", 0);
            String stringDateD = sharedPref.getString("tomato23" + i, null);


            DateFormat dfd = new SimpleDateFormat("d");
            Date todayD = java.util.Calendar.getInstance().getTime();

            String reportDateDay = dfd.format(todayD);
            System.out.println("reportDateDay  " + reportDateDay);

            System.out.println("dateAgain  " + dateAgain);

            if (reportDateDay.equals(stringDateD)) {


                // sharedPref.edit().putInt("loud", 0).apply();


                System.out.println("I Love you !!!Main   " + i);
            }

            try {
                if (dateAgain.equals(reportDateDay)) {

                    System.out.println("hallelujah");
                    System.out.println(dateAgain);
                    System.out.println(reportDateDay);
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

            System.out.println(dateAgain);
            System.out.println(reportDateDay);

      //  }

        c = sharedPref.getInt("nuevo", 0);  // get stored int Value

      c++;                                   // add one to the stored Value

        sharedPref.edit().putInt("nuevo", c).apply();   // save the new valu



System.out.println("C MAIN ACT   " + c);








       iv = (ImageView) findViewById(R.id.imageView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        falsecheckBox = (CheckBox) findViewById(R.id.falseCheckBox);


        switch (view.getId()) {

            case R.id.checkBox:

                if (checkBox.isChecked()) {
                    falsecheckBox.setEnabled(false);




          /*          if (setI == true) {


                        // iv.setImageResource(0);


                        int i = sharedPref.getInt("loud", 0);
                        String stringDateD = sharedPref.getString("tomato23" + i, null);


                        DateFormat dfd = new SimpleDateFormat("d");
                        Date todayD = java.util.Calendar.getInstance().getTime();

                        String reportDateDay = dfd.format(todayD);
                        System.out.println("reportDateDay  " + reportDateDay);

                        System.out.println("stringDateD  " + stringDateD);

                        if (!reportDateDay.equals(stringDateD)) {

                            falsecheckBox.setEnabled(false);
                            checkBox.setEnabled(false);
                            // sharedPref.edit().putInt("loud", 0).apply();


                            Toast.makeText(this, "You have already added this date",
                                    Toast.LENGTH_LONG).show();
                        }

                    } */

                    value = true;


                    String key = "keyo " + c;   //WARUM IST HIER KEIN SPACE NACH DEM SCHLUESSEL??

                    sharedPref.edit().putBoolean(key, value).apply();





                    iv.setImageResource(R.drawable.clementine_happy);

                    System.out.println("key und value    "   +  key + value);


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {






                            Intent j=new Intent(MainActivity.this, Calendar.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                            //       j.putExtra("output", newValue);


                            j.putExtra("use",true);
                            startActivity(j);
                        }
                    }, 2500);





                }else{
                    checkBox.setEnabled(true);
                    falsecheckBox.setEnabled(true);

                }
                break;

            case R.id.falseCheckBox:
                if(falsecheckBox.isChecked()) {
                    checkBox.setEnabled(false);

                    value = false;


                    String key = "keyo " + c;   //WARUM IST HIER KEIN SPACE NACH DEM SCHLUESSEL??


                    sharedPref.edit().putBoolean(key, value).apply();



                    String row5 = "row" + c;
                    sharedPref.edit().putBoolean(row5, value).apply();


                    iv.setImageResource(R.drawable.clementine_sad);

                    output = "Damm";




                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {





                        Intent j=new Intent(MainActivity.this, Calendar.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                        //       j.putExtra("output", newValue);


                        j.putExtra("use",true);
                        startActivity(j);
                    }
                }, 2500);








                } else {

                    checkBox.setEnabled(true);
                    falsecheckBox.setEnabled(true);


                }
                break;
        }



        System.out.println("C here MainActivity   "  +c);

    }



}














/*
    public void onButtonNext(View view) {



        ImageView iv = (ImageView) findViewById(R.id.imageView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        if (checkBox.isChecked() == false) {

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            System.out.println("R U TOUCHING");

            value = false;


            String key = "keyo " + c;   //WARUM IST HIER KEIN SPACE NACH DEM SCHLUESSEL??


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

} */

