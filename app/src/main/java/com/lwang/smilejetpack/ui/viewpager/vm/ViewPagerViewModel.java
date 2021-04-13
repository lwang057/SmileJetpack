package com.lwang.smilejetpack.ui.viewpager.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @Author lwang
 * @Date 2021/4/12 23:09
 * @Description
 */
public class ViewPagerViewModel extends BaseViewModel {

    //给ViewPager添加ObservableList 数据源
    public ObservableList<ViewPagerItemViewModel> items = new ObservableArrayList<>();
    public SingleLiveEvent<String> itemClickEvent = new SingleLiveEvent<>();

    public ViewPagerViewModel(@NonNull Application application) {
        super(application);

        for (int i = 0; i <= 2; i++) {
            ViewPagerItemViewModel itemViewModel = new ViewPagerItemViewModel(this, "第" + i + "个页面");
            items.add(itemViewModel);
        }
    }


    /**
     * 给ViewPager添加ItemBinding
     */
    public ItemBinding<ViewPagerItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_viewpager);


    /**
     * 给ViewPager添加PageTitle(TabLayout的标题)
     */
    public final BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel> pageTitles = new BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel>() {
        @Nullable
        @Override
        public CharSequence getPageTitle(int position, ViewPagerItemViewModel item) {
            return "条目" + position;
        }
    };


    /**
     * ViewPager切换监听
     */
    public BindingCommand<Integer> onPageSelectedCommand = new BindingCommand<Integer>(new BindingConsumer<Integer>() {
        @Override
        public void call(Integer integer) {
            ToastUtils.showShort("ViewPager切换：" + integer);
        }
    });
}

