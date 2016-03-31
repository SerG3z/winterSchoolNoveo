package com.noveo.internship.databaseexample.fragments;

import android.app.Fragment;
import android.content.AsyncQueryHandler;
import android.content.ComponentCallbacks;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
        return new UpFragment();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.up_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
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

    private void deleteLastData() {
        final String[] id = new String[1];
        new AsyncQueryHandler(getActivity().getContentResolver()) {
            @Override
            protected void onQueryComplete(final int token, final Object cookie, final Cursor cursor) {
                super.onQueryComplete(token, cookie, cursor);
                Log.d("base data", String.valueOf(cursor));
                Log.d("base data", String.valueOf(cursor.getCount()));

//                id[1] = cursor.getString(cursor.getColumnIndex(ContentDescriptor.Toys.Cols.TITLE));
//                id[2] = cursor.getString(cursor.getColumnIndex(ContentDescriptor.Toys.Cols.COST));
                Log.d("base data id = ", cursor.getString(cursor.getColumnIndex(ContentDescriptor.Toys.Cols.ID)));
//                Log.d("base data title = ", id[1]);
//                Log.d("base data cost = ", id[2]);


            }
        }.startQuery(1, null, ContentDescriptor.Toys.TABLE_URI, new String[] {"MAX(" + ContentDescriptor.Toys.Cols.ID + ")"}, null, null, ContentDescriptor.Toys.Cols.ID);
//                .startDelete(1, null, ContentDescriptor.Toys.TABLE_URI, ContentDescriptor.Toys.Cols.ID + " = ?", new String[]{String.valueOf(id)});

    }

    @OnClick(R.id.insert)
    public void onClickButtonSave() {
        insertData();
    }

    @OnClick(R.id.delete)
    public void clickButtonInsert() {
        deleteLastData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
