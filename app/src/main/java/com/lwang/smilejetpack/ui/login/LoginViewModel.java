package com.lwang.smilejetpack.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.lwang.smilejetpack.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @Author lwang
 * @Date 2020/9/11 16:52
 * @Description
 */
public class LoginViewModel extends BaseViewModel<DemoRepository> {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

//    public LoginViewModel(@NonNull Application application, DemoRepository model) {
//        super(application, model);
//    }



}
