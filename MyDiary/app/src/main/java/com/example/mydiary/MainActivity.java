package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 첫번째 탭 만들기
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;

        Intent intent = new Intent().setClass(this, ShowMyData.class);

        spec = tabHost.newTabSpec("show").setIndicator("일기보기").setContent(intent);
        tabHost.addTab(spec);

        // 두번째 탭 만들기
        intent = new Intent().setClass(this, WriteDiaryActivity.class);
        spec = tabHost.newTabSpec("write").setIndicator("일기쓰기").setContent(intent);
        tabHost.addTab(spec);

        // 세번째 탭 만들기
        intent = new Intent().setClass(this, AppHelpActivity.class);
        spec = tabHost.newTabSpec("help").setIndicator("App소개").setContent(intent);
        tabHost.addTab(spec);

        // 처음 앱 실행시 탭 활성화 지정하기
        tabHost.setCurrentTab(0);

    }
}