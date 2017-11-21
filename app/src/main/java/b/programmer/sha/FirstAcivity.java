package b.programmer.sha;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
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
}