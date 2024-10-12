package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication2.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Khởi tạo ViewPagerAdapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter); // Thiết lập adapter cho ViewPager

        // Xử lý khi trang được thay đổi
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Khi trang được cuộn
            }

            @Override
            public void onPageSelected(int position) {
                // Sử dụng if-else thay cho switch-case để tránh lỗi Constant expression required
                if (position == 0) {
                    bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                } else if (position == 1) {
                    bottomNavigationView.getMenu().findItem(R.id.cart).setChecked(true);
                } else if (position == 2) {
                    bottomNavigationView.getMenu().findItem(R.id.comment).setChecked(true);
                } else if (position == 3) {
                    bottomNavigationView.getMenu().findItem(R.id.like).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Khi trạng thái cuộn thay đổi
            }
        });

        // Xử lý khi click vào các mục trong BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                viewpager.setCurrentItem(0);
                return true;
            } else if (itemId == R.id.cart) {
                viewpager.setCurrentItem(1);
                return true;
            } else if (itemId == R.id.comment) {
                viewpager.setCurrentItem(2);
                return true;
            } else if (itemId == R.id.like) {
                viewpager.setCurrentItem(3);
                return true;
            }
            return false;
        });

        // Thiết lập Padding cho View để xử lý các thanh hệ thống như Status bar, Navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
