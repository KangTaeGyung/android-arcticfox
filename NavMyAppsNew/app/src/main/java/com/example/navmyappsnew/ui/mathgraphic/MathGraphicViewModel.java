package com.example.navmyappsnew.ui.mathgraphic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MathGraphicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MathGraphicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mathgraphic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    // 데이터 설정
    public void setText(String text) {
        mText.setValue(text);
    }
}