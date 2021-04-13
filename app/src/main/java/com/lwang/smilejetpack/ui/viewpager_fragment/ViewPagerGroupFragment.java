package com.lwang.smilejetpack.ui.viewpager_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.FragmentViewpagerBinding;
import com.lwang.smilejetpack.ui.viewpager_fragment.adapter.FragmentViewPagerAdapter;
import com.lwang.smilejetpack.ui.tab_bar.TabBar1Fragment;
import com.lwang.smilejetpack.ui.tab_bar.TabBar2Fragment;
import com.lwang.smilejetpack.ui.tab_bar.TabBar3Fragment;
import com.lwang.smilejetpack.ui.tab_bar.TabBar4Fragment;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @Author lwang
 * @Date 2021/4/13 11:13
 * @Description ViewPager+Fragment的实现
 */
public abstract class ViewPagerGroupFragment extends BaseFragment<FragmentViewpagerBinding, BaseViewModel> {

    private List<Fragment> mFragments;
    private List<String> titlePager;


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_viewpager;
    }


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {
        mFragments = pagerFragment();
        titlePager = pagerTitleString();


        //设置Adapter
        FragmentViewPagerAdapter pagerAdapter = new FragmentViewPagerAdapter(getChildFragmentManager(), mFragments, titlePager);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
    }


    private List<Fragment> pagerFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add(new TabBar1Fragment());
        list.add(new TabBar2Fragment());
        list.add(new TabBar3Fragment());
        list.add(new TabBar4Fragment());
        return list;
    }

    private List<String> pagerTitleString() {
        List<String> list = new ArrayList<>();
        list.add("page1");
        list.add("page2");
        list.add("page3");
        list.add("page4");
        return list;
    }


}