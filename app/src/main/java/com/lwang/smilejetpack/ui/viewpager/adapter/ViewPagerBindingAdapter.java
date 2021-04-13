package com.lwang.smilejetpack.ui.viewpager.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.lwang.smilejetpack.databinding.ItemViewpagerBinding;
import com.lwang.smilejetpack.ui.viewpager.vm.ViewPagerItemViewModel;

import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;

/**
 * @Author lwang
 * @Date 2021/4/13 10:22
 * @Description
 */
public class ViewPagerBindingAdapter extends BindingViewPagerAdapter<ViewPagerItemViewModel> {

    @Override
    public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, ViewPagerItemViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        ItemViewpagerBinding binding1 = (ItemViewpagerBinding) binding;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

}
