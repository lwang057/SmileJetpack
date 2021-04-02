package com.lwang.smilejetpack.demo.databinding;

/**
 * @Author lwang
 * @Date 2021/3/31 07:36
 * @Description
 */
public class BookRatingUtil {

    public static String getRating(int rating){


        switch (rating){
            case 0:
                return "0星";
            case 1:
                return "1星";
            case 2:
                return "2星";
            case 3:
                return "3星";
            case 4:
                return "4星";
            case 5:
                return "5星";
        }

        return "";
    }
}
