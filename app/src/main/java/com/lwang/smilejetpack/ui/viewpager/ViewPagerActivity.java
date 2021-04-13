package com.lwang.smilejetpack.ui.viewpager;

import android.os.Bundle;

import androidx.lifecycle.Observer;

import com.google.android.material.tabs.TabLayout;
import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.ActivityViewpagerBinding;
import com.lwang.smilejetpack.ui.viewpager.adapter.ViewPagerBindingAdapter;
import com.lwang.smilejetpack.ui.viewpager.vm.ViewPagerViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @Author lwang
 * @Date 2021/4/12 23:07
 * @Description ViewPager绑定
 */
public class ViewPagerActivity extends BaseActivity<ActivityViewpagerBinding, ViewPagerViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_viewpager;
    }


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {

        //使用 TabLayout 和 ViewPager 相关联
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));

        //给ViewPager设置adapter
        binding.setAdapter(new ViewPagerBindingAdapter());
    }


    @Override
    public void initViewObservable() {

        //ViewPager的item点击事件的监听
        viewModel.itemClickEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String text) {
                ToastUtils.showShort("position：" + text);
            }
        });
    }

}