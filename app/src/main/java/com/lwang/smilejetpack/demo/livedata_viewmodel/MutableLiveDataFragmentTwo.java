package com.lwang.smilejetpack.demo.livedata_viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lwang.smilejetpack.R;
import com.lwang.smilejetpack.databinding.FragmentMutableLiveDataTwoBinding;

/**
 * @Author lwang
 * @Date 2021/4/2 10:31
 * @Description
 */
public class MutableLiveDataFragmentTwo extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final FragmentMutableLiveDataTwoBinding dataTwoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mutable_live_data_two, container, false);


        // 获取viewModel
        MutableLiveDataShareViewModel mutableLiveDataShareViewModel = new ViewModelProvider(this.getActivity()).get(MutableLiveDataShareViewModel.class);

        // 通过viewModel拿到liveData封装的数据
        final MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) mutableLiveDataShareViewModel.getProgress();

        // 通过observe方法观察viewModel中字段的变化，并在变化中得到通知
        liveData.observe(this.getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                dataTwoBinding.seekBar.setProgress(integer);
            }
        });


        dataTwoBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // 当用户操作SeekBar时，更新viewModel中的字段数据
                liveData.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return dataTwoBinding.getRoot();
    }

}
