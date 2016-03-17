package com.noveogroup.task3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serg on 18.03.16.
 */
public class SpinnerAdapter extends BaseAdapter {
    private List<String> list = new ArrayList<String>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || !view.getTag().toString().equals("NO_DROPDOWN"))
        return view;
    }
}
