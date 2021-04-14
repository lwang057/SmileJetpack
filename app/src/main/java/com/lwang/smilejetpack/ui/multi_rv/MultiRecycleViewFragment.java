package com.lwang.smilejetpack.ui.multi_rv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.FragmentMultiRvBinding;
import com.lwang.smilejetpack.ui.multi_rv.adapter.MultiRecyclerViewBindingAdapter;
import com.lwang.smilejetpack.ui.multi_rv.vm.MultiRecycleViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * @Author lwang
 * @Date 2021/4/13 23:08
 * @Description RecycleView多布局实现
 */
public class MultiRecycleViewFragment extends BaseFragment<FragmentMultiRvBinding, MultiRecycleViewModel> {


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_multi_rv;
    }


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {
        //给RecyclerView添加Adapter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象。
        // Adapter属于View层的东西, 不建议定义到ViewModel中绑定，以免内存泄漏
        binding.setAdapter(new MultiRecyclerViewBindingAdapter());
    }


}
