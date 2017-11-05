package b.programmer.sha;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by alexanderrabau on 31.10.17.
 */

public class EventDecorator2 implements DayViewDecorator {

    private final int color;
    private final HashSet<CalendarDay> dates;
    private final Drawable drawable1;

    public EventDecorator2(int color, Collection<CalendarDay> dates , Activity context) {
        this.color = color;
        this.dates = new HashSet<>(dates);
        drawable1 = ContextCompat.getDrawable(context, R.drawable.selected_bg_color2);
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