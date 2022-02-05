package com.example.navmyappsnew;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navmyappsnew.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 메인화면 연결
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Floating Action 버튼 클릭시 이벤트 부분
        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 햄버거 버튼 클릭시 네비게이션 바 호출
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // 메뉴 추가할 때 아래 메소드에 하나 추가해 주면 툴바에 이름이 표시된다.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_basiccalculatornew2, R.id.nav_viewclass00,
                R.id.nav_mathgraphic)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController,
                mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 키보드 뒤로가기 키 클릭 시 메뉴 반응
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void increaseValue(View v) {
        MyView.radius += 2;
    }

    public void decreaseValue(View v) {
        MyView.radius -= 2;
    }

    public void setGreen(View v) {
        MyView.whatColor = 4;
    }

    public void setRed(View v) {
        MyView.whatColor = 1;

    }

    public void setBlue(View v) {
        MyView.whatColor = 2;
    }

    public void setYellow(View v) {
        MyView.whatColor = 3;
    }

    public void setBlack(View v) {
        MyView.whatColor = 0;
    }

}