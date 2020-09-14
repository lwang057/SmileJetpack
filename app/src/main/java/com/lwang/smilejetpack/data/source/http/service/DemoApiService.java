package com.lwang.smilejetpack.data.source.http.service;

import com.lwang.smilejetpack.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @Author lwang
 * @Date 2020/9/14 17:04
 * @Description
 */
public interface DemoApiService {

    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);

}
