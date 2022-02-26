package com.example.videowork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Video Album");
    }

    public void showVideo(View v) {
        // xml ID를 얻는 과정
        int id = v.getId();
        LinearLayout layout = (LinearLayout)findViewById(id);

        // xml 태그를 얻는 과정
        String tag = (String)layout.getTag();

        // 인덴트 생성
        Intent intent = new Intent(this, PlayVideo.class);

        // 데이터 담아서 전송
        intent.putExtra("data", tag);
        startActivity(intent);
    }
}
