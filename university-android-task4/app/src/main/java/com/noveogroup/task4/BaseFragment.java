package com.noveogroup.task4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by serg on 19.03.16.
 */
public class BaseFragment extends Fragment {

    private final static String CLICKFLAG_KEY = "flag1";
    private BaseFragmentListener listener;
    private boolean flagListener = true;

    public static BaseFragment newInstance(boolean flag) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putBoolean(CLICKFLAG_KEY, flag);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen1_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        if (getArguments() != null) {
            if (!getArguments().getBoolean(CLICKFLAG_KEY)) {
                flagListener = false;
            } else if (getArguments().getBoolean(CLICKFLAG_KEY)) {
                flagListener = true;
            }
        }
        if (flagListener) {
            try {
                this.listener = (BaseFragmentListener) getActivity();
            } catch (ClassCastException e) {
                Log.e("TEST", "The activity should implement BaseFragmentListener interface", e);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onBaseFragmentClicked();
                    }
                }
            });
        }
    }

    public interface BaseFragmentListener {
        void onBaseFragmentClicked();
    }
}
