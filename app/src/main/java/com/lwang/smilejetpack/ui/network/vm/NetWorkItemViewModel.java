package com.lwang.smilejetpack.ui.network.vm;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.entity.DemoEntity;
import com.lwang.smilejetpack.ui.network.detail.DetailFragment;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @Author lwang
 * @Date 2021/4/7 22:31
 * @Description
 */
public class NetWorkItemViewModel extends ItemViewModel<NetWorkViewModel> {

    //dataBinding的双向绑定
    public ObservableField<DemoEntity.ItemsEntity> entity = new ObservableField<>();
    public Drawable drawableImg;


    public NetWorkItemViewModel(@NonNull NetWorkViewModel viewModel, DemoEntity.ItemsEntity entity) {
        super(viewModel);
        this.entity.set(entity);

        //ImageView的占位图片，可以解决RecyclerView中图片错误问题
        drawableImg = ContextCompat.getDrawable(viewModel.getApplication(), R.mipmap.ic_launcher);
    }


    /**
     * 条目的点击事件
     */
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

            //跳转到详情界面,传入条目的实体对象
            Bundle mBundle = new Bundle();
            mBundle.putParcelable("entity", entity.get());
            viewModel.startContainerActivity(DetailFragment.class.getCanonicalName(), mBundle);
        }
    });


    /**
     * 条目的长按事件
     */
    public BindingCommand itemLongClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            viewModel.deleteItemData.setValue(NetWorkItemViewModel.this);
        }
    });


    /**
     * 获取position的方式有很多种,indexOf是其中一种，常见的还有在Adapter中、ItemBinding.of回调里
     *
     * @return
     */
    public int getPosition() {
        return viewModel.getItemPosition(this);
    }
}
