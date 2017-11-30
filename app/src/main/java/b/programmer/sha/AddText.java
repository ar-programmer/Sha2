package b.programmer.sha;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by alexanderrabau on 23.11.17.
 */

public class AddText extends AppCompatActivity {

    int i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text);

        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
      int lolo =  sharedPref.getInt("intText", 0);
        System.out.println("huhu" + lolo);
    }



    public void confirmText(View view){

        EditText editText = (EditText)findViewById(R.id.introText);

        String juju = editText.getText().toString();

        System.out.println(juju);


        SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);


        String dateToSaveText = sharedPref.getString("toto", null);


        System.out.println(dateToSaveText);    // das ist das angecklickte Datum

        int lolo =   sharedPref.getInt("intText", 0);


 /*       if(lolo == 0){
            sharedPref.edit().putString("textBefore", juju).apply();
        } */

        lolo++;
        sharedPref.edit().putString("textBefore" + lolo, juju).apply();


        lolo++;

        System.out.println(lolo + " the addText Activity");

        sharedPref.edit().putInt("intText"  , lolo).apply();
        sharedPref.edit().putString("text" + lolo, juju).apply();   // es wird der Text in text + i abgespeichert


    }

}
