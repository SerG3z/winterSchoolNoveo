package com.sample.drawer.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.drawer.R;

import java.util.Random;


public class ScheduleFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backColor;

    static ScheduleFragment newInstance(int page) {
        ScheduleFragment scheduleFragment = new ScheduleFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        scheduleFragment.setArguments(arguments);
        return scheduleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random random = new Random();
        backColor = Color.argb(40, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schedule_fragment, null);

        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        tvPage.setText("Page " + pageNumber);
        tvPage.setBackgroundColor(backColor);
        return view;
    }

}
