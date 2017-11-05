package b.programmer.sha;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by alexanderrabau on 30.10.17.
 */


    public class CircleDecorator implements DayViewDecorator {

        private HashSet<CalendarDay> dates;
        private Drawable drawable;

        public CircleDecorator(Context context, int resId, Collection<CalendarDay> dates) {
            drawable = ContextCompat.getDrawable(context, resId);
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new ForegroundColorSpan(Color.WHITE));
            view.setSelectionDrawable(drawable);
        }
    }
