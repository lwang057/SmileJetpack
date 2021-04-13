package com.lwang.smilejetpack.ui.network;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.app.AppViewModelFactory;
import com.lwang.smilejetpack.databinding.FragmentNetWorkBinding;
import com.lwang.smilejetpack.ui.network.adapter.NetWorkRecyclerViewBindingAdapter;
import com.lwang.smilejetpack.ui.network.vm.NetWorkItemViewModel;
import com.lwang.smilejetpack.ui.network.vm.NetWorkViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.MaterialDialogUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class NetWorkFragment extends BaseFragment<FragmentNetWorkBinding, NetWorkViewModel> {

    @Override
    public void initParam() {
        super.initParam();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_net_work;
    }


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public NetWorkViewModel initViewModel() {

        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        ViewModelProvider viewModelProvider = ViewModelProviders.of(this, factory);
        NetWorkViewModel netWorkViewModel = viewModelProvider.get(NetWorkViewModel.class);

        return netWorkViewModel;
    }


    @Override
    public void initData() {

        //给RecyclerView添加Adapter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象。
        // Adapter属于View层的东西, 不建议定义到ViewModel中绑定，以免内存泄漏
        binding.setAdapter(new NetWorkRecyclerViewBindingAdapter());

        //请求网络数据
        viewModel.requestNetWork();
    }


    @Override
    public void initViewObservable() {

        // 监听下拉刷新完成
        viewModel.uc.finishRefreshing.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                binding.twinklingRefreshLayout.finishRefreshing();
            }
        });


        // 监听上拉加载完成
        viewModel.uc.finishLoadMore.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                binding.twinklingRefreshLayout.finishLoadmore();
            }
        });


        //监听删除条目
        viewModel.deleteItemData.observe(this, new Observer<NetWorkItemViewModel>() {
            @Override
            public void onChanged(final NetWorkItemViewModel netWorkItemViewModel) {
                int itemPosition = viewModel.getItemPosition(netWorkItemViewModel);

                MaterialDialogUtils.showBasicDialog(getContext(), "提示", "是否删除【" + netWorkItemViewModel.entity.get().getName() + "】？ position：" + itemPosition)
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                ToastUtils.showShort("取消");
                            }
                        })
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                viewModel.deleteItem(netWorkItemViewModel);
                            }
                        })
                        .show();
            }
        });

    }


}