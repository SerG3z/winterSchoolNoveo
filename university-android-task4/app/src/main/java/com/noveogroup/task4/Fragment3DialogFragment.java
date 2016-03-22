package com.noveogroup.task4;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 3/21/2016.
 */
public class Fragment3DialogFragment extends DialogFragment {

    private DialogFragmentListener listener;

    public static Fragment3DialogFragment newInstance() {
        Fragment3DialogFragment myFragment = new Fragment3DialogFragment();
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen3_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        try {
            this.listener = (DialogFragmentListener) getActivity();
        } catch (ClassCastException e) {
            Log.e("TEST", "The activity should implement DialogFragmentListener interface", e);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onFragmentClicked();

                }
            }
        });
    }


    public interface DialogFragmentListener {
        void onFragmentClicked();
    }
}
