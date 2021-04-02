package com.lwang.smilejetpack.demo.livedata_viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.ActivityMutableLiveDataBinding;

/**
 * @Author lwang
 * @Date 2021/4/2 10:31
 * @Description liveData + viewModel 来实时更新fragment之间的数据
 */
public class MutableLiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMutableLiveDataBinding activityMutableLiveDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mutable_live_data);
    }


}