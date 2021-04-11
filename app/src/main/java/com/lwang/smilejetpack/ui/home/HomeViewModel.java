package com.lwang.smilejetpack.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;

import com.lwang.smilejetpack.ui.network.NetWorkFragment;
import com.lwang.smilejetpack.ui.tab_bar.TabBarActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * @Author lwang
 * @Date 2021/3/29 22:16
 * @Description
 */
public class HomeViewModel extends BaseViewModel {


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public SingleLiveEvent<Boolean> requestCameraPermissions = new SingleLiveEvent<>();


    public SingleLiveEvent<String> loadUrlEvent = new SingleLiveEvent<>();


    /**
     * 网络访问
     */
    public BindingCommand netWorkClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(NetWorkFragment.class.getCanonicalName());
        }
    });


    /**
     * RecycleView多布局
     */
    public BindingCommand rvMultiClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });


    /**
     * 进入TabBarActivity
     */
    public BindingCommand startTabBarClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(TabBarActivity.class);
        }
    });


    /**
     * ViewPager绑定
     */
    public BindingCommand viewPagerBindingClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });


    /**
     * ViewPager+Fragment
     */
    public BindingCommand viewPagerGroupBindingClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });


    /**
     * 表单提交点击事件
     */
    public BindingCommand formSbmClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });


    /**
     * 表单编辑点击事件
     */
    public BindingCommand formModifyClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });


    /**
     * 权限申请
     */
    public BindingCommand permissionsClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            requestCameraPermissions.call();
        }
    });


    /**
     * 全局异常捕获
     */
    public BindingCommand exceptionClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Integer.parseInt("hello");
        }
    });


    /**
     * 文件下载
     */
    public BindingCommand fileDownLoadClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadUrlEvent.setValue("http://gdown.baidu.com/data/wisegame/dc8a46540c7960a2/baidushoujizhushou_16798087.apk");
        }
    });


}
