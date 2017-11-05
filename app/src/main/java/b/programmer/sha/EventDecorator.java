package b.programmer.sha;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by alexanderrabau on 30.10.17.
 */

public class EventDecorator implements DayViewDecorator {

    private final int color;
    private final HashSet<CalendarDay> dates;
    private final Drawable drawable1;

    public EventDecorator(int color, Collection<CalendarDay> dates , Activity context) {
        this.color = color;
        this.dates = new HashSet<>(dates);
        drawable1 = ContextCompat.getDrawable(context, R.drawable.selected_bg_color);
    }


    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    public void decorate(DayViewFacade view) {

        // view.setBackgroundDrawable();

      //  view.addSpan(new DotSpan(10, color));        // dot under the number
     //   view.addSpan(new ForegroundColorSpan(color));  // this colors the number
     //   view.setBackgroundDrawable();//So this code add a background
     //   view.addSpan(new StyleSpan(Typeface.BOLD));  // Fett Schrift
    //    view.addSpan(new RelativeSizeSpan(1.4f));    // Grösse der Schrift


        view.setBackgroundDrawable(drawable1);

    }
}