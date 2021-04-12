package com.lwang.smilejetpack.ui.form;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;

import com.google.gson.Gson;
import com.lwang.smilejetpack.entity.FormEntity;
import com.lwang.smilejetpack.entity.SpinnerItemData;
import com.lwang.smilejetpack.ui.base.ToolbarViewModel;
import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.binding.viewadapter.spinner.IKeyAndValue;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @Author lwang
 * @Date 2021/4/11 09:48
 * @Description
 */
public class FormViewModel extends ToolbarViewModel {


    public FormEntity entity;
    public SingleLiveEvent<String> entityJsonLiveData = new SingleLiveEvent<>();
    public List<IKeyAndValue> sexItemDatas;
    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //显示日期对话框
        public ObservableBoolean showDateDialogObservable = new ObservableBoolean(false);
    }


    public FormViewModel(@NonNull Application application) {
        super(application);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //sexItemDatas 一般可以从本地Sqlite数据库中取出数据字典对象集合，让该对象实现IKeyAndValue接口
        sexItemDatas = new ArrayList<>();
        sexItemDatas.add(new SpinnerItemData("男", "1"));
        sexItemDatas.add(new SpinnerItemData("女", "2"));
    }


    /**
     * 设置数据
     *
     * @param entity
     */
    public void setFormEntity(FormEntity entity) {
        if (this.entity == null) {
            this.entity = entity;
        }
    }


    /**
     * 设置生日数据到实体
     *
     * @param year
     * @param month
     * @param dayOfMonth
     */
    public void setBir(int year, int month, int dayOfMonth) {
        entity.setBir(year + "年" + (month + 1) + "月" + dayOfMonth + "日");

        //刷新实体,驱动界面更新
        entity.notifyChange();
    }


    /**
     * 初始化Toolbar
     */
    public void initToolbar() {

        //初始化 显示标题栏
        setRightTextVisible(View.VISIBLE);


        if (TextUtils.isEmpty(entity.getId())) {
            setTitleText("表单提交");
        }else {
            setTitleText("表单编辑");
        }
    }


    /**
     * 性别选择的监听
     */
    public BindingCommand<IKeyAndValue> onSexSelectorCommand = new BindingCommand<IKeyAndValue>(new BindingConsumer<IKeyAndValue>() {
        @Override
        public void call(IKeyAndValue iKeyAndValue) {
            entity.setSex(iKeyAndValue.getKey());
        }
    });


    /**
     * 生日选择的监听
     */
    public BindingCommand onBirClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //回调到view层(Fragment)中显示日期对话框
            uc.showDateDialogObservable.set(!uc.showDateDialogObservable.get());
        }
    });


    /**
     * 是否已婚Switch点状态改变回调
     */
    public BindingCommand<Boolean> onMarryCheckedChangeCommand = new BindingCommand<Boolean>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean aBoolean) {
            entity.setMarry(aBoolean);
        }
    });


    /**
     * 提交按钮点击事件
     */
    public BindingCommand onCmtClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            String submitJson = new Gson().toJson(entity);
            entityJsonLiveData.setValue(submitJson);
        }
    });


    @Override
    public void rightTextOnClick() {
        ToastUtils.showShort("更多内容");
    }


}
