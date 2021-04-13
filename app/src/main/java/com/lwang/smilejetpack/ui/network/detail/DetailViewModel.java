package com.lwang.smilejetpack.ui.network.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.lwang.smilejetpack.entity.DemoEntity;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @Author lwang
 * @Date 2021/4/13 22:09
 * @Description
 */
public class DetailViewModel extends BaseViewModel {

    public ObservableField<DemoEntity.ItemsEntity> entity = new ObservableField<>();


    public DetailViewModel(@NonNull Application application) {
        super(application);
    }


    public void setDemoEntity(DemoEntity.ItemsEntity e) {
        this.entity.set(e);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        entity = null;
    }

}
