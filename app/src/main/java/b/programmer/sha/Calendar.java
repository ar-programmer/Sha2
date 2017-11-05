package b.programmer.sha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;


/**
 * Created by alexanderrabau on 27.10.17.
 */

public class Calendar extends AppCompatActivity {

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        Intent intent = getIntent();


        message2 = intent.getBooleanExtra("output", false);


        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);

        c = sharedPref.getInt("nuevo", 0);

        value = sharedPref.getBoolean("keyo " + c, false);

        i = sharedPref.getInt("loud", 0);

        i++;

        sharedPref.edit().putInt("loud", i).apply();





        DateFormat df = new SimpleDateFormat("yyyy");
        Date today = java.util.Calendar.getInstance().getTime();
        reportDateYear = df.format(today);
        sharedPref.edit().putString("tomato5" + i, reportDateYear).apply();


        DateFormat dfm = new SimpleDateFormat("MM");
        Date todayM = java.util.Calendar.getInstance().getTime();
        reportDateMonth = dfm.format(todayM);
        sharedPref.edit().putString("tomato6" + i, reportDateMonth).apply();


        DateFormat dfd = new SimpleDateFormat("d");
        Date todayD = java.util.Calendar.getInstance().getTime();
        reportDateDay = dfd.format(todayD);
        sharedPref.edit().putString("tomato21" + i, reportDateDay).apply();


        String stringDateY = sharedPref.getString("tomato5" + i, null);
        String stringDateM = sharedPref.getString("tomato6" + i, null);
        String stringDateD = sharedPref.getString("tomato21" + i, null);

        int year = Integer.parseInt(stringDateY);

        System.out.println(year);

        int month = Integer.parseInt(stringDateM) - 1;

        System.out.println(month);


        //   System.out.println(day);


        //  DateFormat format = new SimpleDateFormat("MMMM d, yyyy");


        Boolean checkin = sharedPref.getBoolean("keyo " + c, false);
        Boolean row5 = sharedPref.getBoolean("row" + c, false);

        MaterialCalendarView materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);


        HashSet<CalendarDay> dates = new HashSet<CalendarDay>();
        HashSet<CalendarDay> dates2 = new HashSet<CalendarDay>();

        while (stringDateD != null) {
            checkin = sharedPref.getBoolean("keyo " + c, false);  //save wheather smiley or angry
            stringDateD = sharedPref.getString("tomato21" + i, null);
            if (stringDateD == null) {

            } else {

                System.out.println(stringDateD);
                int k = 0;


                if (checkin == true) {


                    int day = Integer.parseInt(stringDateD);
                    CalendarDay calendarDay = CalendarDay.from(year, month, day);
                    dates.add(calendarDay);

                    System.out.println(checkin);


                    EventDecorator2 eventDecorator = new EventDecorator2(getResources().getColor(R.color.colorPrimaryDark), dates, this);
                    materialCalendarView.addDecorator(eventDecorator);


                } else {



                    int day = Integer.parseInt(stringDateD);
                CalendarDay calendarDay2 = CalendarDay.from(year, month, day);
                    dates2.add(calendarDay2);


                    System.out.println(checkin);
                    EventDecorator eventDecorator2 = new EventDecorator(getResources().getColor(R.color.colorAccent), dates2, this);
                    materialCalendarView.addDecorator(eventDecorator2);


              //     materialCalendarView.addDecorator(new CurrentDateDecorator(this));


                }


                i--;
                c--;


            }

        }

 //       checkin = sharedPref.getBoolean("keyo " + c, false);
        int k = 0;
        if (row5 == true) {

            System.out.println("BEFORE GETTING SHAREDPREF   " + k);
            k =  sharedPref.getInt("row", 0);

            k++;

            System.out.println("AFTER  " + k);


            sharedPref.edit().putInt("row", k).apply();



            if (k == 1){
                System.out.println("IF EQUAL 3    " + k);
                System.out.println("You are fantastic");



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {



                  VideoView      videoView = (VideoView) findViewById(R.id.videoView);


                  /*      String videopath = "android.resource://b.programmer.sha/"+R.raw.baloon;

                        Uri uri = Uri.parse(videopath);



                        videoView.setVideoURI(uri);
                        videoView.start(); */

                        Intent j=new Intent(Calendar.this, Video.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
                   //            j.putExtra("output", newValue);
                        startActivity(j);
                    }
                }, 2500);



       /*         AlertDialog.Builder builder = new AlertDialog.Builder(this);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();   */
            }


            System.out.println("Y are u true ???  "  +checkin);


 // Y IS CHECKIN EVERTIME TRUE HERE EVEN WHEN IT IS FALSE???
                     } else


    if (row5 == false){
            k = 0;
            sharedPref.edit().putInt("row", k).apply();
            System.out.println("When false   " + k);



        }




    }}







     /*   try {


            String stringDate = sharedPref.getString("tomato5" + i, null);
           Boolean checkin  = sharedPref.getBoolean("keyo " + c, false);

            while (stringDate != null) {
                stringDate = sharedPref.getString("tomato5" + i, null);
                checkin  = sharedPref.getBoolean("keyo " + c, false);


                if (stringDate == null) {

                } else {




                    Date date = new Date();

                    date = format.parse(stringDate);
                   MaterialCalendarView materialCalendar = (MaterialCalendarView) findViewById(R.id.materialCalenderView);


                    MaterialCalendarView materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);








                   if (checkin == true) {
                        System.out.println(checkin);
                    //    materialCalendar.setDateSelected(date, true);


               //      materialCalendar.setSelectionColor(Color.parseColor("#04B431"));


               //         datePicker.getSolidColor(new ColorDrawable(Color.BLUE));

                  //      materialCalendar.setTextColorForDate(int textColorRes, date);
                   //     materialCalendar.addDecorator(new CurrentDateDecorator(this));

              //         materialCalendar.getSelectionColor();


    /*                 }
                    else {
                        System.out.println(checkin);    */
        //materialCalendar.setDateSelected(date, true);


        // materialCalendar.setSelectionColor(Color.parseColor("#FF0000"));
//                        materialCalendar.getSelectionColor();

    /*                }
                }
                c--;
                i--;


            }
                System.out.println(String.valueOf(entry.getValue()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }




 */