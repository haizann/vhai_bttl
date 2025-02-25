package com.example.myapplication2.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment_home(); // Fragment cho tab đầu tiên
            case 1:
                return new fragment_cart(); // Fragment cho tab thứ hai
            case 2:
                return new fragment_comment();
            case 3:
                return new fragment_like();
            default:
                return new fragment_home(); // Fragment mặc định
        }
    }

    @Override
    public int getCount() {
        return 4; // Số lượng Fragment bạn có
    }
}
