package com.lwang.smilejetpack.ui.tab_bar;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.ActivityTabBarBinding;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import me.tatarka.bindingcollectionadapter2.BR;


/**
 * @Author lwang
 * @Date 2021/4/10 09:27
 * @Description 底部tab导航页面
 */
public class TabBarActivity extends BaseActivity<ActivityTabBarBinding, BaseViewModel> {

    private ArrayList<Fragment> mFragments;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_tab_bar;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {

        //初始化Fragment
        initFragment();

        //初始化底部Button
        initBottomTab();
    }


    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new TabBar1Fragment());
        mFragments.add(new TabBar2Fragment());
        mFragments.add(new TabBar3Fragment());
        mFragments.add(new TabBar4Fragment());

        //默认显示第一个
        showFragment(0);
    }


    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.mipmap.yingyong, "应用")
                .addItem(R.mipmap.huanzhe, "工作")
                .addItem(R.mipmap.xiaoxi_select, "消息")
                .addItem(R.mipmap.wode_select, "我的")
                .setDefaultColor(ContextCompat.getColor(this, R.color.textColorVice))
                .build();


        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                showFragment(index);
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }


    private void showFragment(int position){
        hideAllFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(position));
        if (currentFragment == null){
            currentFragment = mFragments.get(position);
            transaction.add(R.id.frameLayout, currentFragment, String.valueOf(position));
        }else {
            transaction.show(currentFragment);
        }

        transaction.commitAllowingStateLoss();
    }


    /**
     * 隐藏所有Fragment
     */
    private void hideAllFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(i));
            if (currentFragment != null){
                transaction.hide(currentFragment);
            }
        }

        transaction.commitAllowingStateLoss();

    }

}
