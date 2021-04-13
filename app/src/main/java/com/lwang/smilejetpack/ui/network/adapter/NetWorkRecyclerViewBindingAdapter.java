package com.lwang.smilejetpack.ui.network.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.lwang.smilejetpack.databinding.ItemNetworkBinding;
import com.lwang.smilejetpack.ui.network.vm.NetWorkItemViewModel;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * @Author lwang
 * @Date 2021/4/13 21:29
 * @Description
 */
public class NetWorkRecyclerViewBindingAdapter extends BindingRecyclerViewAdapter<NetWorkItemViewModel> {

    @Override
    public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, NetWorkItemViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        ItemNetworkBinding itemNetworkBinding = (ItemNetworkBinding) binding;
    }


}
