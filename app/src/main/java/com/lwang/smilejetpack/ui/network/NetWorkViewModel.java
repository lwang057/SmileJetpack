package com.lwang.smilejetpack.ui.network;

import android.app.Application;

import androidx.annotation.NonNull;

import com.lwang.smilejetpack.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @Author lwang
 * @Date 2020/9/15 17:51
 * @Description
 */
public class NetWorkViewModel extends BaseViewModel<DemoRepository> {


    public NetWorkViewModel(@NonNull Application application) {
        super(application);
    }

    public NetWorkViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
}
