package com.example.harkkatyo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.harkkatyo.fragments.BasicDataFragment;
import com.example.harkkatyo.fragments.VisualisationFragment;
import com.example.harkkatyo.fragments.WeatherFragment;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BasicDataFragment();
            case 1:
                return new WeatherFragment();
            case 2:
                return new VisualisationFragment();
            default:
                return new BasicDataFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
