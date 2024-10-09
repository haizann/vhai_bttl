package com.example.myapplication2.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication2.fragment.fragment_cart;
import com.example.myapplication2.fragment.fragment_comment;
import com.example.myapplication2.fragment.fragment_home;
import com.example.myapplication2.fragment.fragment_like;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tab1Fragment(); // Fragment cho tab đầu tiên
            case 1:
                return new Tab2Fragment(); // Fragment cho tab thứ hai
            case 2:
                return new Tab3Fragment();
            case 3:
                return new Tab4Fragment();
            default:
                return new Tab1Fragment(); // Fragment mặc định
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tất cả";
            case 1:
                return "Đồ nam";
            case 2:
                return "Đồ nữ";
            case 3:
                return "Trẻ em";
            default:
                return "Tất cả";
        }
    }
}
