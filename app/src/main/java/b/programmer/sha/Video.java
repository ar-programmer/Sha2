package b.programmer.sha;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

/**
 * Created by alexanderrabau on 03.11.17.
 */



public class Video extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);



        videoView = (VideoView) findViewById(R.id.videoView);


        String videopath = "android.resource://b.programmer.sha/"+R.raw.baloon;

        Uri uri = Uri.parse(videopath);



        videoView.setVideoURI(uri);
        videoView.start();


    }
}