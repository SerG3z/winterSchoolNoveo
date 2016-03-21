package com.noveogroup.task4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by admin on 3/21/2016.
 */
public class Fragment3DialogFragment extends DialogFragment {

    static Fragment3DialogFragment newInstance() {
        return new Fragment3DialogFragment();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setMessage(R.string.text_dialog);
        return adb.create();
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmen3_layout, container, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                showDialog();
            }
        });
        return view;
    }

    void showDialog() {
        DialogFragment newFragment = Fragment3DialogFragment.newInstance();
        newFragment.show(getFragmentManager(), "dialog");

    }




}
