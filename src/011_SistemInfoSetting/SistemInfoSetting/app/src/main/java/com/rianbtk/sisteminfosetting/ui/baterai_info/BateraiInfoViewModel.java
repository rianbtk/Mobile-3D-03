package com.rianbtk.sisteminfosetting.ui.baterai_info;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class BateraiInfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BateraiInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}