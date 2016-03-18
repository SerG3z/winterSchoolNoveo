package com.sample.drawer.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.drawer.R;

/**
 * Created by serg on 19.03.16.
 */
public class MondayFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent = new Intent(this.getActivity(), ViewPagerAdapter.class);
        startActivity(intent);
//        ViewGroup rootView = (ViewGroup) inflater.inflate(
//                R.layout.item_viewpager, container, false);
        return null;
    }
}
