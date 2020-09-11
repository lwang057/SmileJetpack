package com.lwang.smilejetpack.data;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;

/**
 * @Author lwang
 * @Date 2020/9/11 17:01
 * @Description
 */
public class DemoRepository extends BaseModel implements HttpDataSource, LocalDataSource{


    @Override
    public Observable<Object> login() {
        return null;
    }

    @Override
    public void saveUserName(String userName) {

    }

    @Override
    public void savePassword(String password) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

}
