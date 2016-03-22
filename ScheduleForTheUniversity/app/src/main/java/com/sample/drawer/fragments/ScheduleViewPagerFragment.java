package com.sample.drawer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.drawer.R;
import com.sample.drawer.fragments.animation.ZoomOutPageTransformer;

/**
 * Created by admin on 3/18/2016.
 */
public class ScheduleViewPagerFragment extends Fragment {

    private static final int NUM_PAGES = 7;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    public ScheduleViewPagerFragment() {
    }


    public static ScheduleViewPagerFragment newIntent() {
        ScheduleViewPagerFragment viewPagerFragment = new ScheduleViewPagerFragment();
        return viewPagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_screen_slide, null);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        return view;
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ItemDayFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
