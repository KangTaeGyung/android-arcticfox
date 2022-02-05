package com.example.navmyappsnew.ui.basiccalculatornewv2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BasicCalculatorNewV2ViewModel extends ViewModel {

    private MutableLiveData<String> mOutput;
    private MutableLiveData<String> mOutputExpression;

    public BasicCalculatorNewV2ViewModel() {
        mOutput = new MutableLiveData<>();
        mOutputExpression = new MutableLiveData<>();

        mOutput.setValue("");
        mOutputExpression.setValue("");
    }

    public LiveData<String> getOutput() {
        return mOutput;
    }

    public LiveData<String> getOutputExpression() {
        return mOutputExpression;
    }

    // 데이터 설정
    public void setOutput(String text) {
        mOutput.setValue(text);
    }

    // 데이터 설정
    public void setOutputExpression(String text) {
        mOutputExpression.setValue(text);
    }
}