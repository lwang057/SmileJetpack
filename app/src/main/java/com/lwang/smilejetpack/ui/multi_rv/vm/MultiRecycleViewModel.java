package com.lwang.smilejetpack.ui.multi_rv.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.lwang.smilejetpack.R;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.BR;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @Author lwang
 * @Date 2021/4/13 23:10
 * @Description
 */
public class MultiRecycleViewModel extends BaseViewModel {

    private static final String MultiRecycleType_Head = "head";
    private static final String MultiRecycleType_Left = "left";
    private static final String MultiRecycleType_Right = "right";

    //给RecyclerView添加ObservableList
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();


    public MultiRecycleViewModel(@NonNull Application application) {
        super(application);

        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                MultiItemViewModel itemHead = new MultiRecycleHeadViewModel(this);
                itemHead.multiItemType(MultiRecycleType_Head);
                observableList.add(itemHead);
            } else {
                String text = "我是第" + i + "条";
                if (i % 2 == 0) {
                    //条目类型为左布局
                    MultiItemViewModel itemLeft = new MultiRecycleLeftItemViewModel(this, text);
                    itemLeft.multiItemType(MultiRecycleType_Left);
                    observableList.add(itemLeft);
                } else {
                    //条目类型为右布局
                    MultiItemViewModel itemRight = new MultiRecycleRightItemViewModel(this, text);
                    itemRight.multiItemType(MultiRecycleType_Right);
                    observableList.add(itemRight);
                }
            }
        }

    }


    /**
     * RecyclerView多布局添加ItemBinding
     */
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(@NonNull ItemBinding itemBinding, int position, MultiItemViewModel item) {

            //通过item的类型, 动态设置Item加载的布局
            String itemType = (String) item.getItemType();
            if (MultiRecycleType_Head.equals(itemType)) {
                //设置头布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_head);
            } else if (MultiRecycleType_Left.equals(itemType)) {
                //设置左布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_rv_left);
            } else if (MultiRecycleType_Right.equals(itemType)) {
                //设置右布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_rv_right);
            }
        }
    });

}

