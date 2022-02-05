package com.example.navmyappsnew.ui.slideshow;

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

import com.example.navmyappsnew.R;
import com.example.navmyappsnew.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // 뷰모델 연결
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        // 화면과 연결 ( 최신 기술 : findViewById() 대신 사용
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 카멜표기법으로 뷰의 위젯에 접근할 수 있다.
        final TextView textView = binding.textSlideshow;
        // 관찰했다가 textView 내용이 수정되면 자동 반영
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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