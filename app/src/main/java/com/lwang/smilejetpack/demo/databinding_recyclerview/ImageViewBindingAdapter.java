package com.lwang.smilejetpack.demo.databinding_recyclerview;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

/**
 * @Author lwang
 * @Date 2021/3/31 20:20
 * @Description
 */
public class ImageViewBindingAdapter {

    @BindingAdapter("image")
    public static void setImage(ImageView imageView, int imageResource) {

        imageView.setImageResource(imageResource);
    }

    @BindingAdapter("image")
    public static void setImage(ImageView imageView, String imageUrl) {

//            Picasso.get().load(imageUrl).into(imageView);
    }


    @BindingAdapter(value = {"image", "defaultImageView"}, requireAll = false)
    public static void setImage(ImageView imageView, String imageUrl, int imageResource){

        if (!TextUtils.isEmpty(imageUrl)){

//            Picasso.get().load(imageUrl).into(imageView);
        }else {
            imageView.setImageResource(imageResource);
        }
    }

}
