package com.lwang.smilejetpack.data.source.local;

import com.lwang.smilejetpack.data.source.LocalDataSource;

import me.goldze.mvvmhabit.utils.SPUtils;

/**
 * @Author lwang
 * @Date 2020/9/14 15:38
 * @Description 本地数据源，可配合Room框架使用
 */
public class LocalDataSourceImpl implements LocalDataSource {

    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    private LocalDataSourceImpl() {
        // 数据库Helper构建
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void saveUserName(String userName) {
        SPUtils.getInstance().put("UserName", userName);
    }

    @Override
    public void savePassword(String password) {
        SPUtils.getInstance().put("password", password);
    }

    @Override
    public String getUserName() {
        return SPUtils.getInstance().getString("UserName");
    }

    @Override
    public String getPassword() {
        return SPUtils.getInstance().getString("password");
    }
}
