package com.lwang.smilejetpack.demo.databinding_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.ActivityRecycleviewBinding;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRecycleviewBinding activityRecycleviewBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycleview);

        activityRecycleviewBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        activityRecycleviewBinding.recyclerview.setHasFixedSize(true);

        RecycleViewAdapter adapter = new RecycleViewAdapter(new RecycleViewViewModel().getBooks());
        activityRecycleviewBinding.recyclerview.setAdapter(adapter);
    }
}