package com.lwang.smilejetpack.ui.base;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @Author lwang
 * @Date 2021/4/11 09:49
 * @Description include标题的 ToolbarViewModel
 */
public class ToolbarViewModel<M extends BaseModel> extends BaseViewModel<M> {

    public ObservableField<String> titleText = new ObservableField<>(""); //标题文字
    public ObservableField<String> rightText = new ObservableField<>("更多"); //右边文字
    public ObservableInt rightTextVisibleObservable = new ObservableInt(View.GONE); //右边文字的观察者
    public ObservableInt rightIconVisibleObservable = new ObservableInt(View.GONE); //右边图标的观察者
    public ToolbarViewModel toolbarViewModel; //兼容dataBinding，去泛型化


    public ToolbarViewModel(@NonNull Application application) {
        super(application);
        toolbarViewModel = this;
    }


    /**
     * 设置标题
     */
    public void setTitleText(String text) {
        titleText.set(text);
    }


    /**
     * 设置右边文字
     */
    public void setRightText(String text) {
        rightText.set(text);
    }


    /**
     * 设置右边文字的显示和隐藏
     */
    public void setRightTextVisible(int visibility) {
        rightTextVisibleObservable.set(visibility);
    }


    /**
     * 设置右边图标的显示和隐藏
     */
    public void setRightIconVisible(int visibility) {
        rightIconVisibleObservable.set(visibility);
    }


    /**
     * 返回按钮的点击事件
     */
    public BindingCommand callBack = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });


    /**
     * 右边文字的点击事件
     */
    public BindingCommand rightTextOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            rightTextOnClick();
        }
    });


    /**
     * 右边图标的点击事件
     */
    public BindingCommand rightIconOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            rightIconOnClick();
        }
    });


    /**
     * 右边文字的点击事件，子类可重写进行点击事件的处理
     */
    public void rightTextOnClick() {
    }


    /**
     * 右边图标的点击事件，子类可重写进行点击事件的处理
     */
    protected void rightIconOnClick() {
    }

}
