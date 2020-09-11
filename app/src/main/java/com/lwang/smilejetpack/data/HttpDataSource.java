package com.lwang.smilejetpack.data;

import io.reactivex.Observable;

/**
 * @Author lwang
 * @Date 2020/9/11 17:47
 * @Description
 */
public interface HttpDataSource {

    Observable<Object> login();
}
