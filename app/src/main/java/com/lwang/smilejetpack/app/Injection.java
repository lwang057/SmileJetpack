package com.lwang.smilejetpack.app;

import com.lwang.smilejetpack.data.DemoRepository;
import com.lwang.smilejetpack.data.http.HttpDataSource;
import com.lwang.smilejetpack.data.local.LocalDataSource;
import com.lwang.smilejetpack.data.http.HttpDataSourceImpl;
import com.lwang.smilejetpack.data.http.DemoApiService;
import com.lwang.smilejetpack.data.local.LocalDataSourceImpl;
import com.lwang.smilejetpack.utils.RetrofitClient;

/**
 * @Author lwang
 * @Date 2020/9/14 15:22
 * @Description 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 */
public class Injection {

    public static DemoRepository provideDemoRepository(){

        //网络API服务
        DemoApiService demoApiService = RetrofitClient.getInstance().create(DemoApiService.class);

        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(demoApiService);

        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();

        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }
}