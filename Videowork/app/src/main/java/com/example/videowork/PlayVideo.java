package com.example.videowork;

import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);

        setTitle("동영상 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("data");

        TextView title = (TextView)findViewById(R.id.title);
        VideoView videoView = (VideoView)findViewById(R.id.videoview);

        int stringId;
        String myInfo;

        Resources res = getResources();

        stringId = res.getIdentifier("what" + tag, "string", getPackageName());
        //다음 처럼 해도 된다.
        myInfo = res.getString(stringId);
        title.setText(myInfo);

        stringId = res.getIdentifier("video" + tag, "string", getPackageName());
        myInfo = res.getString(stringId);

        int video_num = res.getIdentifier(myInfo, "raw", getPackageName());

        Uri uri = Uri.parse("android.resource://com.example.videowork/" + video_num);

        videoView.setVideoURI(uri);
        videoView.start();

        MediaController mController = new MediaController(this);
        videoView.setMediaController(mController);

    }

    public void closeVideo(View v) {
        finish();
    }
}

