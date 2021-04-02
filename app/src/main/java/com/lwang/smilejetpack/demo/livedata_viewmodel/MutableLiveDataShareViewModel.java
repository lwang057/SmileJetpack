package com.lwang.smilejetpack.demo.livedata_viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @Author lwang
 * @Date 2021/4/2 10:22
 * @Description 使用LiveData包装的viewModel
 */
public class MutableLiveDataShareViewModel extends ViewModel {

    private MutableLiveData<Integer> progress;


    public LiveData<Integer> getProgress() {

        if (progress == null) {
            progress = new MutableLiveData<>();
        }

        return progress;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        progress = null;
    }


}
