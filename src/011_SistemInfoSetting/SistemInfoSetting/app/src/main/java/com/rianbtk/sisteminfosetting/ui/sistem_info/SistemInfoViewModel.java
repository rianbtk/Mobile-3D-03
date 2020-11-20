package com.rianbtk.sisteminfosetting.ui.sistem_info;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SistemInfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SistemInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}