package com.lwang.smilejetpack.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.lwang.smilejetpack.data.http.HttpDataSource;
import com.lwang.smilejetpack.data.local.LocalDataSource;
import com.lwang.smilejetpack.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * @Author lwang
 * @Date 2020/9/11 17:01
 * @Description MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repository）
 */
public class DemoRepository extends BaseModel implements HttpDataSource, LocalDataSource {

    private volatile static DemoRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;
    private final LocalDataSource mLocalDataSource;

    public static DemoRepository getInstance(HttpDataSource httpDataSource, LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (DemoRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DemoRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    private DemoRepository(@NonNull HttpDataSource httpDataSource, @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<Object> login() {
        return mHttpDataSource.login();
    }

    @Override
    public Observable<DemoEntity> loadMore() {
        return mHttpDataSource.loadMore();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return mHttpDataSource.demoPost(catalog);
    }

    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }

}
