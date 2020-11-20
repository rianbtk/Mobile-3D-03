package com.rianbtk.sisteminfosetting.ui.display_info;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class DisplayInfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DisplayInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}