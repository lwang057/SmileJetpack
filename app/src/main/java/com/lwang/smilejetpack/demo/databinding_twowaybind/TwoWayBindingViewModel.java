package com.lwang.smilejetpack.demo.databinding_twowaybind;

import androidx.databinding.ObservableField;


/**
 * @Author lwang
 * @Date 2021/3/31 21:58
 * @Description 使用ObservableField 实现双向绑定
 */
public class TwoWayBindingViewModel {

    private ObservableField<TwoWayModel> twoWayModelObservableField = new ObservableField<>();


    public TwoWayBindingViewModel(){

        TwoWayModel twoWayModel = new TwoWayModel();
        twoWayModel.userName = "周杰伦";

        twoWayModelObservableField.set(twoWayModel);
    }

    public String getUserName(){
        return twoWayModelObservableField.get().userName;
    }


    public void setUserName(String userName){
        twoWayModelObservableField.get().userName = userName;

    }

}
