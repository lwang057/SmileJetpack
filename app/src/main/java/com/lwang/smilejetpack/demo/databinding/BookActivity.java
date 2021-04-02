package com.lwang.smilejetpack.demo.databinding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.ActivityBookBinding;

import me.goldze.mvvmhabit.utils.ToastUtils;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 通过DataBindingUtil将Activity与布局文件进行性绑定
        ActivityBookBinding activityDemoBinding = DataBindingUtil.setContentView(this, R.layout.activity_book);

        Book book = new Book("七里香", "周杰伦");
        book.rating = 5;

//        activityDemoBinding.setVariable(BR.book, book);
        activityDemoBinding.setBook(book);

        activityDemoBinding.setEventHandle(new EventHandleListener());

        activityDemoBinding.setLocalImage(R.mipmap.ic_launcher);

        activityDemoBinding.setNetworkImage("");
    }


    public class EventHandleListener {

        public EventHandleListener() {
        }


        public void onButtonClick(View view) {
            ToastUtils.showShort("点我啦");
        }

    }

}

