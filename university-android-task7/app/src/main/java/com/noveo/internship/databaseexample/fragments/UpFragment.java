package com.noveo.internship.databaseexample.fragments;

import android.app.Fragment;
import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.noveo.internship.databaseexample.R;
import com.noveo.internship.databaseexample.db.ContentDescriptor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 3/29/2016.
 */
public class UpFragment extends Fragment {

    @Bind(R.id.titleEdit)
    EditText titleEditText;
    @Bind(R.id.costEdit)
    EditText costEditText;

    public static Fragment newInstance() {
        UpFragment upFragment = new UpFragment();
        return upFragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.up_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(getActivity());

    }

    private void insertData() {
        if (!TextUtils.isEmpty(titleEditText.getText()) && !TextUtils.isEmpty(costEditText.getText())) {
            ContentValues values = new ContentValues();
            values.put(ContentDescriptor.Toys.Cols.TITLE, String.valueOf(titleEditText.getText()));
            values.put(ContentDescriptor.Toys.Cols.COST, Integer.valueOf(String.valueOf(costEditText.getText())));

            new AsyncQueryHandler(getActivity().getContentResolver()) {
            }.startInsert(1, null, ContentDescriptor.Toys.TABLE_URI, values);
        } else {
            Toast.makeText(getActivity(), R.string.toast_message, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.insert)
    public void onClickButtonSave() {
        insertData();
    }

    @OnClick(R.id.delete)
    public void clickButtonInsert() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
