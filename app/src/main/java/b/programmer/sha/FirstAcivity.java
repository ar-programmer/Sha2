package b.programmer.sha;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by alexanderrabau on 19.11.17.
 */

public class FirstAcivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ImageView iv = (ImageView) findViewById(R.id.imageView);

        iv.setImageResource(R.drawable.calendar_icon);

        ImageView arrow = (ImageView) findViewById(R.id.arrow);

        arrow.setImageResource(R.drawable.arrow);


        ImageView plusIcon = (ImageView) findViewById(R.id.addNote);

        plusIcon.setImageResource(R.drawable.plus_icon);

    }


    public void onArrowClick(View view) {

        Intent j = new Intent(this, MainActivity.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
        //       j.putExtra("output", newValue);

        startActivity(j);
    }


    public void onCalendarClick(View view) {

        Intent j = new Intent(this, Calendar.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
        //       j.putExtra("output", newValue);

        startActivity(j);

    }

    public void onAddNoteClick(View view) {

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
     int   i = sharedPref.getInt("IAddText", 0);  // get stored int Value

        i++;                                   // add one to the stored Value

        Intent j = new Intent(this, AddNoteActivity.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
        //       j.putExtra("output", newValue);

        startActivity(j);

    }

}