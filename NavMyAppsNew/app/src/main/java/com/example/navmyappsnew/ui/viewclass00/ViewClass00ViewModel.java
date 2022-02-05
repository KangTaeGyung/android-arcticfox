package com.example.navmyappsnew.ui.viewclass00;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewClass00ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ViewClass00ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is viewclass00 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    // 데이터 설정
    public void setText(String text) {
        mText.setValue(text);
    }
}