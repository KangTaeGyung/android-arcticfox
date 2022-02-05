package com.example.navmyappsnew.ui.viewclass00;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navmyappsnew.databinding.FragmentViewclass00Binding;

public class ViewClass00Fragment extends Fragment {

    private ViewClass00ViewModel viewClass00ViewModel;
    private FragmentViewclass00Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // 뷰모델 연결
        viewClass00ViewModel =
                new ViewModelProvider(this).get(ViewClass00ViewModel.class);

        // 화면과 연결 ( 최신 기술 : findViewById() 대신 사용
        binding = FragmentViewclass00Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 카멜표기법으로 뷰의 위젯에 접근할 수 있다.
        final TextView textView = binding.textViewclass00;
        // 관찰했다가 textView 내용이 수정되면 자동 반영
        viewClass00ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}