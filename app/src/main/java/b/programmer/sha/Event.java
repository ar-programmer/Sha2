package b.programmer.sha;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexanderrabau on 30.10.17.
 */

public class Event {

    private Date date;
    private int color;

    public Event(Date date, int color) {
        this.date = date;
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public int getColor() {
        return color;
    }


}