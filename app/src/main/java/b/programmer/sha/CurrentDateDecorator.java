package b.programmer.sha;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

class CurrentDateDecorator implements DayViewDecorator {



    private Drawable drawable;

    CalendarDay currentDay = CalendarDay.from(new Date());

    public CurrentDateDecorator(Activity context) {
        drawable = ContextCompat.getDrawable(context,R.drawable.selected_bg_color);


    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {



        return day.equals(currentDay);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }
}
