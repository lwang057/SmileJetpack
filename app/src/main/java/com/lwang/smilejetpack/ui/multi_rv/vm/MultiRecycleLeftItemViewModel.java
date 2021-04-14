package com.lwang.smilejetpack.ui.multi_rv.vm;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @Author lwang
 * @Date 2021/4/14 15:33
 * @Description 多布局的左边条目
 */
public class MultiRecycleLeftItemViewModel extends MultiItemViewModel<MultiRecycleViewModel> {

    public ObservableField<String> text = new ObservableField<>("");


    public MultiRecycleLeftItemViewModel(@NonNull MultiRecycleViewModel viewModel, String s) {
        super(viewModel);
        this.text.set(s);
    }


    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            int position = viewModel.observableList.indexOf(MultiRecycleLeftItemViewModel.this);
            ToastUtils.showShort("position：" + position);
        }
    });


}
