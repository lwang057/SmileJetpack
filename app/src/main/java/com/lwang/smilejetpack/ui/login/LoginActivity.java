package com.lwang.smilejetpack.ui.login;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.app.AppViewModelFactory;
import com.lwang.smilejetpack.databinding.ActivityLoginBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @Author lwang
 * @Date 2020/9/11 16:51
 * @Description M V VM 模式的登录界面
 * ActivityLoginBinding类是databinding框架自定生成的,对应activity_login.xml
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginViewModel initViewModel() {

        // 使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        LoginViewModel loginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return loginViewModel;
    }


    @Override
    public void initViewObservable() {
        //监听ViewModel中pSwitchObservable的变化, 当ViewModel中执行【uc.pSwitchObservable.set(!uc.pSwitchObservable.get());】时会回调该方法

        viewModel.uc.pSwitchEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                //pSwitchObservable是boolean类型的观察者,所以可以直接使用它的值改变密码开关的图标

                if (viewModel.uc.pSwitchEvent.getValue()) { //为true时密码可见

                    //在xml中定义id后,使用binding可以直接拿到这个view的引用,不再需要findViewById去找控件了
                    binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw);
                    binding.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {

                    binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw_press);
                    binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }


}
