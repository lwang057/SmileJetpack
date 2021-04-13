package com.lwang.smilejetpack.ui.network.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.lwang.smilejetpack.BR;
import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.data.DemoRepository;
import com.lwang.smilejetpack.entity.DemoEntity;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.http.ResponseThrowable;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @Author lwang
 * @Date 2020/9/15 17:51
 * @Description
 */
public class NetWorkViewModel extends BaseViewModel<DemoRepository> {

    //item发生删除的观察者
    public SingleLiveEvent<NetWorkItemViewModel> deleteItemData = new SingleLiveEvent<>();
    //给RecyclerView添加ObservableList数据源
    public ObservableList<NetWorkItemViewModel> observableList = new ObservableArrayList();
    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {

        public SingleLiveEvent finishRefreshing = new SingleLiveEvent(); //下拉刷新完成
        public SingleLiveEvent finishLoadMore = new SingleLiveEvent(); //上拉加载完成
    }


    public NetWorkViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }


    /**
     * 给RecyclerView添加ItemBinding
     */
    public ItemBinding<NetWorkItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_network);


    /**
     * 下拉刷新
     */
    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("下拉刷新");
            requestNetWork();
        }
    });


    /**
     * 上拉加载
     */
    public BindingCommand onLoadMoreCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (observableList.size() > 50) {
                ToastUtils.showLong("兄dei，你太无聊啦~崩是不可能的~");
                uc.finishLoadMore.call();
                return;
            }
            loadMoreNewWork();
        }
    });


    /**
     * 网络请求方法，在ViewModel中调用Model层，通过OkHttp+Retrofit+RxJava发起请求
     */
    public void requestNetWork() {
        model.demoGet()
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .compose(RxUtils.exceptionTransformer()) // 网络错误的异常转换, 这里可以换成自己的ExceptionHandle
                .doOnSubscribe(this) //请求与ViewModel周期同步
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog("正在请求...");
                    }
                })
                .subscribe(new DisposableObserver<BaseResponse<DemoEntity>>() {
                    @Override
                    public void onNext(BaseResponse<DemoEntity> response) {
                        observableList.clear();

                        //请求成功
                        if (response.getCode() == 1) {
                            for (DemoEntity.ItemsEntity entity : response.getResult().getItems()) {
                                NetWorkItemViewModel itemViewModel = new NetWorkItemViewModel(NetWorkViewModel.this, entity);
                                //双向绑定动态添加Item
                                observableList.add(itemViewModel);
                            }
                        } else {
                            //code错误时也可以定义Observable回调到View层去处理
                            ToastUtils.showShort("数据错误");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissDialog();

                        //请求刷新完成收回
                        uc.finishRefreshing.call();

                        if (e instanceof ResponseThrowable) {
                            ToastUtils.showShort(((ResponseThrowable) e).message);
                        }
                    }

                    @Override
                    public void onComplete() {
                        dismissDialog();

                        //请求刷新完成收回
                        uc.finishRefreshing.call();
                    }
                });
    }


    /**
     * 模拟网络上拉加载更多
     */
    private void loadMoreNewWork() {
        model.loadMore()
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(this) //请求与ViewModel周期同步
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        ToastUtils.showShort("上拉加载");
                    }
                })
                .subscribe(new Consumer<DemoEntity>() {
                    @Override
                    public void accept(DemoEntity entity) throws Exception {

                        for (DemoEntity.ItemsEntity itemsEntity : entity.getItems()) {
                            NetWorkItemViewModel itemViewModel = new NetWorkItemViewModel(NetWorkViewModel.this, itemsEntity);

                            //双向绑定动态添加Item
                            observableList.add(itemViewModel);
                        }

                        //加载更多完成收回
                        uc.finishLoadMore.call();
                    }
                });
    }


    //----------------------------------------------------------------------------------


    /**
     * 删除条目
     *
     * @param netWorkItemViewModel
     */
    public void deleteItem(NetWorkItemViewModel netWorkItemViewModel) {
        //点击确定，在 observableList 绑定中删除，界面立即刷新
        observableList.remove(netWorkItemViewModel);
    }


    /**
     * 获取条目下标
     *
     * @param netWorkItemViewModel
     * @return
     */
    public int getItemPosition(NetWorkItemViewModel netWorkItemViewModel) {
        return observableList.indexOf(netWorkItemViewModel);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
