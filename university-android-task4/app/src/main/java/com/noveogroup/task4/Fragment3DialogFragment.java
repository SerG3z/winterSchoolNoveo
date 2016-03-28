package com.noveogroup.task4;

import android.app.DialogFragment;
import android.content.DialogInterface;
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
    private boolean clikedFlag = true;

    public static Fragment3DialogFragment newInstance() {
        Fragment3DialogFragment myFragment = new Fragment3DialogFragment();
        return myFragment;
    }

    public boolean isClikedFlag() {
        return clikedFlag;
    }

    public void setClikedFlag(final boolean clikedFlag) {
        this.clikedFlag = clikedFlag;
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

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        clikedFlag = false;
    }

    public interface DialogFragmentListener {
        void onFragmentClicked();
    }


}
