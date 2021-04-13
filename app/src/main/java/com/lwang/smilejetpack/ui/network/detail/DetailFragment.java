package com.lwang.smilejetpack.ui.network.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.FragmentDetailBinding;
import com.lwang.smilejetpack.entity.DemoEntity;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * @Author lwang
 * @Date 2021/4/13 22:07
 * @Description 列表的详情页面
 */
public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> {

    private DemoEntity.ItemsEntity entity;


    @Override
    public void initParam() {
        Bundle mBundle = getArguments();
        if (mBundle != null) {
            entity = mBundle.getParcelable("entity");
        }
    }


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_detail;
    }


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {

        viewModel.setDemoEntity(entity);
    }


}
