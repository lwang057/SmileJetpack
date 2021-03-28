package com.lwang.smilejetpack.data.http;

import com.lwang.smilejetpack.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * @Author lwang
 * @Date 2020/9/11 17:47
 * @Description
 */
public interface HttpDataSource {

    /**
     * 模拟登录
     */
    Observable<Object> login();


    /**
     * 模拟上拉加载
     */
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);
}