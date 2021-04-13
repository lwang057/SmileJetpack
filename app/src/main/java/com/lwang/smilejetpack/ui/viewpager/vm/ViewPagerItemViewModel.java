package com.lwang.smilejetpack.ui.viewpager.vm;

import androidx.annotation.NonNull;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @Author lwang
 * @Date 2021/4/13 09:51
 * @Description
 */
public class ViewPagerItemViewModel extends ItemViewModel<ViewPagerViewModel> {

    public String text;


    public ViewPagerItemViewModel(@NonNull ViewPagerViewModel viewModel, String text) {
        super(viewModel);
        this.text = text;
    }


    /**
     * viewpager Item的点击事件
     */
    public BindingCommand onItemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            //点击之后将逻辑转到activity中处理
            viewModel.itemClickEvent.setValue(text);
        }
    });

}

