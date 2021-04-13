package com.lwang.smilejetpack.ui.viewpager_fragment.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author lwang
 * @Date 2021/4/13 11:51
 * @Description FragmentViewPager适配器
 */
public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;//ViewPager要填充的fragment列表
    private List<String> title;//tab中的title文字列表


    public FragmentViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //获得position中的fragment来填充
        return list.get(position);
    }

    @Override
    public int getCount() {
        //返回FragmentPager的个数
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //FragmentPager的标题,如果重写这个方法就显示不出tab的标题内容
        return title.get(position);
    }
}
