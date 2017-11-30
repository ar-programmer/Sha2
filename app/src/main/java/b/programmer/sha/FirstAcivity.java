package b.programmer.sha;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;

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

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final String imageFilePath = Environment.getExternalStorageDirectory().getPath() + "/picture.jpg";

    public void onAddNoteClick(View view) {



   /*     SharedPreferences sharedPref = getSharedPreferences("sharePref", MODE_PRIVATE);
     int   i = sharedPref.getInt("IAddText", 0);  // get stored int Value

        i++;                                   // add one to the stored Value

        Intent j = new Intent(this, AddNoteActivity.class);  // Warum funktioniert hier nicht nur ledglich THIS ANZUGEBEN?
        //       j.putExtra("output", newValue);

        startActivity(j);  */


        // TODO Auto-generated method stub
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
          //    textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
            //    Resources res = getResources(bitmap);

                RelativeLayout bg = (RelativeLayout) findViewById(R.id.relativelayout);
                Drawable drawable = new BitmapDrawable(getResources(), bitmap);
                bg.setBackgroundDrawable(drawable);
           //     RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
           //     relativeLayout.setBackgroundDrawable(bitmap);

          //                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}