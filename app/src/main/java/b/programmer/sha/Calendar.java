package b.programmer.sha;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.applandeo.materialcalendarview.EventDay;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by alexanderrabau on 27.10.17.
 */

public class Calendar extends AppCompatActivity {


    boolean pressedNext = false;
    String     samba2, samba3;
    boolean addText = false;
    int year_x, month_x, day_x;
    String samba , diJaneiro, miJaneiro;
    String koko, moko;

    String hString;
    String workPlease;

    int increment;
    boolean value = true;

    boolean balance = true;
    String stringDate;

    String getStringDateD;

    String stringDate2;


    int i = 0;

    int c = 0;

    int a = 0;

    String reportDateYear;
    String reportDateMonth;
    String reportDateDay;
    boolean message2;

    boolean use;

    boolean come;

    boolean afterAddDate;

    static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        Intent intent = getIntent();


        message2 = intent.getBooleanExtra("output", false);

        use = intent.getBooleanExtra("use", false);

        come = intent.getBooleanExtra("come", false);

        Boolean checkin;


        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);




        System.out.println("huhu" + increment);


        c = sharedPref.getInt("nuevo", 0);

        System.out.println("C here    " + c);
        //   c++;

        //  sharedPref.edit().putInt("nuevo", c).apply();


        a = sharedPref.getInt("fuego", 0);


        value = sharedPref.getBoolean("keyo " + c, false);

        i = sharedPref.getInt("loud", 0);

        i++;

        // sharedPref.edit().putInt("loud", i).apply();  THIS WAS THE MISTAKE PLEASE LOOK AT!!

        String userText = "";

        final EditText input = new EditText(this);




        if (use == false) {


            MaterialCalendarView materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);




/*  materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
        TextView textView = (TextView)findViewById(R.id.showText);

        int increment =   sharedPref.getInt("increment", 0);





        if(increment == 1) {

             koko = String.valueOf(date);
            sharedPref.edit().putString("BeforeIncrementdate", koko).apply();
             samba = sharedPref.getString("BeforeIncrementdate", null);


            diJaneiro = sharedPref.getString("textBefore" + increment, null);



            System.out.println(samba + "     I am koko");
            System.out.println(diJaneiro + "     I am diJaneiro");

            textView.setText(diJaneiro);

        } else {
            textView.setText(null);
        }

        System.out.println(" String value of date        "     +String.valueOf(date));
        System.out.println(" koko jambo        "     + koko);

        if (String.valueOf(date).equals(koko)){
            System.out.println("HelloAgain");
            textView.setText(diJaneiro);
        }

        // YOU HAVE TO PROGRAMM   IF  A NEW DAY IS CLICKED THAT DOES NOT MATCH THE SAVED ONE INCREMENT


         addText = true;



        increment++;


        sharedPref.edit().putInt("increment", increment).apply();


        int intText = sharedPref.getInt("intText", 0);

        System.out.println(intText + "       what is it????????" );

         String toto   = String.valueOf(date);
       sharedPref.edit().putString("AfterIncrementdate" + increment, toto).apply();     // the date gets saved


        System.out.println("I am afterIncrement   " + toto);



   //     String dateToSaveText = sharedPref.getString("toto" + increment, null);
        //  System.out.println(dateToSaveText);

        System.out.println(increment);




//        HashSet<CalendarDay> day = new HashSet<CalendarDay>();

  //      day.add(date);

            //    if (intText == increment){

        String text = sharedPref.getString("text" + intText, null);         // you get the introduced text

        String pupu = sharedPref.getString("AfterIncrementdate" + increment, null);
        if (toto == pupu) {

            increment--;

                 // you have the date


      //      textView.setText(text);

        } else {
    //        textView.setText(null);
        }

if (increment == 4) {

    String mumu = sharedPref.getString("AfterIncrementdate" + increment, null);
    String text2 = sharedPref.getString("text" + intText, null);


 //   textView.setText(text2);

}


        // if you click on this date --- this text has to be show!!!



        //    System.out.println(pupu + "this is pupu  !! ");





           // date.equals(pupu);









            System.out.println(date + "this is pupu 222 !! ");



    }
                                                  });     */



            materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
                @Override
                public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                    SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
                    TextView textView = (TextView) findViewById(R.id.showText);

                    increment = sharedPref.getInt("increment", 0);
                    int j = sharedPref.getInt("increment", 0);
                    diJaneiro = sharedPref.getString("textBefore" + increment, null);


                    if (pressedNext == true){

                        System.out.println(increment);
                           sharedPref.edit().putString("BeforeIncrementdate" + increment, String.valueOf(date)).apply();

                            System.out.println("value date in addText"   +String.valueOf(date));

                            pressedNext = false;


                    }

                        System.out.println(diJaneiro + "     I am diJaneiro");

               //         textView.setText(diJaneiro);

           //      samba = sharedPref.getString("BeforeIncrementdate" + increment, null);  //samba is equal to all the increment




                    addText = true;


                  for(int increment = 0; increment <= j; increment++)  {


                      System.out.println(j);

                   //   increment = 1;


                  //    increment = sharedPref.getInt("increment", 0);


                      samba = sharedPref.getString("BeforeIncrementdate" + increment, null);
                      System.out.println("What is increment      " + increment);
                      System.out.println(increment);

                        if (String.valueOf(date).equals(samba)) {

                            System.out.println("did u get in here ???" + samba);
                            diJaneiro = sharedPref.getString("textBefore" + increment, null);
                            textView.setText(diJaneiro);
                            break;
                        } else {
                            textView.setText(null);
                        }

                    }




         /*           while (increment != 0) {

                        increment = 0;


                        samba = sharedPref.getString("BeforeIncrementdate" + increment, null);

                        if (String.valueOf(date).equals(samba)) {
                            System.out.println("did u get in here ???" + samba);
                            //       textView.setText(diJaneiro);
                        }

                        if (String.valueOf(date).equals(null)) {
                            increment = 0;
                            System.out.println("you see now it is null   ");
                        }

                    }    */

            /*        if (String.valueOf(date).equals(moko)) {
                        System.out.println("HelloAgain");
                        textView.setText(miJaneiro);
                    }  */
                    // YOU HAVE TO PROGRAMM   IF  A NEW DAY IS CLICKED THAT DOES NOT MATCH THE SAVED ONE INCREMENT










          //        increment = 0;
         //           samba = sharedPref.getString("BeforeIncrementdate" + increment, null);

           //         System.out.println("showuld be the first date    " + samba);
           //         System.out.println("is it 0???  " + increment);


                } });













                //     c--;
                i--;

                System.out.println("I for the second time reaching Calendar" + i);

                String stringDateY = sharedPref.getString("yearo" + i, null);
                String stringDateM = sharedPref.getString("montho" + i, null);
                String stringDateD = sharedPref.getString("tomato23" + i, null);
                checkin = sharedPref.getBoolean("keyo " + c, false);
                Boolean regenbogen = sharedPref.getBoolean("sol" + a, false);
                Boolean row5 = sharedPref.getBoolean("row" + c, false);


                HashSet<CalendarDay> dates = new HashSet<CalendarDay>();
                HashSet<CalendarDay> dates2 = new HashSet<CalendarDay>();

                while (stringDateD != null) {

                    regenbogen = sharedPref.getBoolean("sol" + a, false);

                    System.out.println(regenbogen);
                    checkin = sharedPref.getBoolean("keyo " + c, false);
                    regenbogen = sharedPref.getBoolean("sol" + a, false);//save wheather smiley or angry
                    stringDateD = sharedPref.getString("tomato23" + i, null);
                    stringDateY = sharedPref.getString("yearo" + i, null);
                    stringDateM = sharedPref.getString("montho" + i, null);
                    if (stringDateD == null) {

                    } else {

                        System.out.println(stringDateD);

                        int k = 0;  // not to sure if this has to be here???

                        if (checkin == true) {

                            int month = Integer.parseInt(stringDateM) - 1;
                            int year = Integer.parseInt(stringDateY);
                            int day = Integer.parseInt(stringDateD);
                            System.out.println("printing out day    " + day);
                            CalendarDay calendarDay = CalendarDay.from(year, month, day);
                            dates.add(calendarDay);


                            System.out.println(checkin);


                            EventDecorator2 eventDecorator = new EventDecorator2(getResources().getColor(R.color.colorGreen), dates, this);
                            materialCalendarView.addDecorator(eventDecorator);

                        } else {


                            int month = Integer.parseInt(stringDateM) - 1;
                            int year = Integer.parseInt(stringDateY);
                            int day = Integer.parseInt(stringDateD);
                            CalendarDay calendarDay2 = CalendarDay.from(year, month, day);
                            dates2.add(calendarDay2);

                            System.out.println(checkin);
                            EventDecorator eventDecorator2 = new EventDecorator(getResources().getColor(R.color.colorRed), dates2, this);
                            materialCalendarView.addDecorator(eventDecorator2);


                            //     materialCalendarView.addDecorator(new CurrentDateDecorator(this));


                        }


                        i--;
                        c--;
                        a--;


                        System.out.println("I for the third time end Schleife   " + i);
                    }

                }


                i--;


            }


            boolean value = true;

            boolean balance = true;
            String stringDate;

            String stringDate2;

            Date date = new Date();

            int i = 0;

            int c = 0;

            String reportDateYear;
            String reportDateMonth;
            String reportDateDay;
            boolean message2;


            if (use == true) {


     /*       Boolean goneBackToDate = sharedPref.getBoolean("goneBackToDate", false);

            if (goneBackToDate == true){


                System.out.println("just adede ii          "  +  i);

                i++;
                i++;

                System.out.println("just adede ii22          "  +  i);
                System.out.println("just adede cc          "  +  c);

                c++;
                c++;

                System.out.println("just adede cc 22         "  +  c);


                sharedPref.edit().putBoolean("goneBackToDate", false).apply();
            }   */


                message2 = intent.getBooleanExtra("output", false);


                i = sharedPref.getInt("loud", 0);


                Boolean setI = sharedPref.getBoolean("setI", false);


                //      if (setI == true) {
                i++;
                //      }

                System.out.println("i first time  " + i);
                afterAddDate = sharedPref.getBoolean("afterAddDate", false);

                if (afterAddDate == true) {
                    c++;   //  wenn nach dem einsetzen gedrückt wird.

                }
                c = sharedPref.getInt("nuevo", 0);

                value = sharedPref.getBoolean("keyo " + c, false);

                sharedPref.edit().putInt("loud", i).apply();


                DateFormat df = new SimpleDateFormat("yyyy");
                Date today = java.util.Calendar.getInstance().getTime();
                reportDateYear = df.format(today);
                sharedPref.edit().putString("yearo" + i, reportDateYear).apply();


                DateFormat dfm = new SimpleDateFormat("MM");
                Date todayM = java.util.Calendar.getInstance().getTime();
                reportDateMonth = dfm.format(todayM);
                sharedPref.edit().putString("montho" + i, reportDateMonth).apply();


                DateFormat dfd = new SimpleDateFormat("d");
                Date todayD = java.util.Calendar.getInstance().getTime();
                reportDateDay = dfd.format(todayD);
                sharedPref.edit().putString("tomato23" + i, reportDateDay).apply();


                String stringDateY = sharedPref.getString("yearo" + i, null);
                String stringDateM = sharedPref.getString("montho" + i, null);
                String stringDateD = sharedPref.getString("tomato23" + i, null);

                int year = Integer.parseInt(stringDateY);

                int month = Integer.parseInt(stringDateM) - 1;

                //   System.out.println(day);

                //  DateFormat format = new SimpleDateFormat("MMMM d, yyyy");

                checkin = sharedPref.getBoolean("keyo " + c, false);
                System.out.println("this is c    " + c);
                System.out.println("At this point    " + checkin);
                Boolean row5 = sharedPref.getBoolean("row" + c, false);


                MaterialCalendarView materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);


                HashSet<CalendarDay> dates = new HashSet<CalendarDay>();
                HashSet<CalendarDay> dates2 = new HashSet<CalendarDay>();


                sharedPref.edit().putString("dateAgain", stringDateD).apply();

                while (stringDateD != null) {


                    System.out.println("i second time  " + i);


                    System.out.println("stringDateIstringDateIstringDateI   " + stringDateD);


                    checkin = sharedPref.getBoolean("keyo " + c, false);  //save wheather smiley or angry
                    stringDateD = sharedPref.getString("tomato23" + i, null);
                    if (stringDateD == null) {

                    } else {

                        System.out.println(stringDateD);
                        int k = 0;


                        if (checkin == true) {


                            int day = Integer.parseInt(stringDateD);
                            CalendarDay calendarDay = CalendarDay.from(year, month, day);
                            dates.add(calendarDay);

                            System.out.println(checkin);


                            EventDecorator2 eventDecorator = new EventDecorator2(getResources().getColor(R.color.colorGreen), dates, this);
                            materialCalendarView.addDecorator(eventDecorator);

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //Do something after 20s
                                    // Write your code to display AlertDialog here

                                    AlertDialog.Builder builder = new AlertDialog.Builder(Calendar.this);
                                    builder.setMessage("Congratukations you Made it!")
                                            .setCancelable(false)
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    Intent j = new Intent(Calendar.this, FirstAcivity.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                                                    //       j.putExtra("output", newValue);


                                                    j.putExtra("use", true);
                                                    startActivity(j);
                                                }
                                            });
                                    AlertDialog alert = builder.create();
                                    alert.show();
                                }
                            }, 2000);
                 /*       new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {





                                Intent j=new Intent(Calendar.this, FirstAcivity.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                                //       j.putExtra("output", newValue);


                                j.putExtra("use",true);
                                startActivity(j);
                            }
                        }, 2500);  */


                        } else {


                            int day = Integer.parseInt(stringDateD);
                            CalendarDay calendarDay2 = CalendarDay.from(year, month, day);
                            dates2.add(calendarDay2);


                            System.out.println(checkin);
                            EventDecorator eventDecorator2 = new EventDecorator(getResources().getColor(R.color.colorRed), dates2, this);
                            materialCalendarView.addDecorator(eventDecorator2);


                            //     materialCalendarView.addDecorator(new CurrentDateDecorator(this));

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //Do something after 20s
                                    // Write your code to display AlertDialog here

                                    AlertDialog.Builder builder = new AlertDialog.Builder(Calendar.this);
                                    builder.setMessage("Marta te quiero!  Dont give up")
                                            .setCancelable(false)
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    Intent j = new Intent(Calendar.this, FirstAcivity.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                                                    //       j.putExtra("output", newValue);


                                                    j.putExtra("use", true);
                                                    startActivity(j);
                                                }
                                            });
                                    AlertDialog alert = builder.create();
                                    alert.show();
                                }
                            }, 2000);
                        }


                        i--;
                        c--;


                    }  /*
                    }  */


                }

      /*      if (setI == true && (reportDateDay.equals(stringDateD))) {

                i++;
                c++;
                stringDateD = null;
            }
*/


                //       checkin = sharedPref.getBoolean("keyo " + c, false);





    /*           int k = 0;
                if (row5 == true) {

                    System.out.println("BEFORE GETTING SHAREDPREF   " + k);
                    k = sharedPref.getInt("row", 0);

                    k++;

                    System.out.println("AFTER  " + k);


                    sharedPref.edit().putInt("row", k).apply();


                    if (k == 1) {
                        System.out.println("IF EQUAL 3    " + k);
                        System.out.println("You are fantastic");


                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                VideoView videoView = (VideoView) findViewById(R.id.videoView);




                                Intent j = new Intent(Calendar.this, Video.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                                //            j.putExtra("output", newValue);
                                startActivity(j);
                            }
                        }, 2500);





                    System.out.println("Y are u true ???  " + checkin);


                    // Y IS CHECKIN EVERTIME TRUE HERE EVEN WHEN IT IS FALSE???
                } else if (row5 == false) {
                    k = 0;
                    sharedPref.edit().putInt("row", k).apply();
                    System.out.println("When false   " + k);


                }


            }
        }   */


            }

        }


        @Override
        public void onBackPressed ()
        {
            // code here to show dialog
            super.onBackPressed();

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit().putBoolean("setI", true).apply();
            String stringDateD = sharedPref.getString("tomato23" + i, null);


            System.out.println(stringDateD);


            try {
                MainActivity.falsecheckBox.setChecked(false);
                MainActivity.checkBox.setChecked(false);
                MainActivity.falsecheckBox.setEnabled(true);
                MainActivity.checkBox.setEnabled(true);
            } catch (NullPointerException e) {
                System.out.println("Caught u too :)");
            }






  /*      int i = sharedPref.getInt("loud", 0);
        String stringDateD = sharedPref.getString("tomato23" + i, null);


        DateFormat dfd = new SimpleDateFormat("d");
        Date todayD = java.util.Calendar.getInstance().getTime();

        String reportDateDay = dfd.format(todayD);
        System.out.println("reportDateDay  " + reportDateDay);

        System.out.println("stringDateD  " + stringDateD);

        if (reportDateDay.equals(stringDateD)) {

            c--;
            i--;
             sharedPref.edit().putInt("nuevo", c).apply();
            sharedPref.edit().putInt("loud", i).apply();

           sharedPref.edit().putString("tomato23" + i, reportDateDay).apply();
            System.out.println("I Love you !!!Main   " + i);
        }

        System.out.println("I Love you !!!"   + i); // optional depending on your needs  */
        }



    //  Button button = (Button) findViewById(R.id.button);


    public void addTextClick(View view){


        if (addText == false){
            increment = 0;
            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
            sharedPref.edit().putInt("increment", increment).apply();
        }



        if (addText == true){

             pressedNext = true;

            SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

            increment++;
            sharedPref.edit().putInt("increment", increment).apply();

            System.out.println("Increment in addText"   +increment);





        //    String text = sharedPref.getString("text" + intText, null);         // text

         //   String pupu = sharedPref.getString("date" + increment, null);        // you have the date


            Intent intent = new Intent(this, AddText.class);

startActivity(intent);
}

        }

    static String increments(String s) {
        Matcher m = NUMBER_PATTERN.matcher(s);
        if (!m.find())
            throw new NumberFormatException();
        String num = m.group();
        int inc = Integer.parseInt(num) + 1;
        String incStr = String.format("%0" + num.length() + "d", inc);
        return  m.replaceFirst(incStr);
    }


    public void testIncrementString() {
        System.out.println(increments("ABC123"));  // -> ABC124
        System.out.println(increments("Z00000"));  // -> Z00001
        System.out.println(increments("AB05YZ"));  // -> AB06YZ
    }


}




