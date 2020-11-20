package com.rianbtk.sisteminfosetting.ui.cara_rooting;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CaraRootingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CaraRootingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}