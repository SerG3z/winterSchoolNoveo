package com.noveo.internship.databaseexample.fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.noveo.internship.databaseexample.R;
import com.noveo.internship.databaseexample.db.ContentDescriptor;
import com.noveo.internship.databaseexample.db.OpenHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 3/29/2016.
 */
public class DownFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    @Bind(R.id.list)
    ListView listView;

    private LoaderManager loaderManager;
    private SimpleCursorAdapter adapter;

    public static Fragment newInstance() {
        return new DownFragment();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.down_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        loaderManager = getLoaderManager();

        String[] columns = new String[]{ContentDescriptor.Toys.Cols.TITLE, ContentDescriptor.Toys.Cols.COST};
        int[] toFields = new int[]{R.id.title, R.id.cost};

        adapter = new SimpleCursorAdapter(this.getActivity(), R.layout.list_item_layout, null, columns, toFields, 0);
        listView.setAdapter(adapter);

        loaderManager.initLoader(0, null, this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        OpenHelper.getInstance(this.getActivity()).close();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), ContentDescriptor.Toys.TABLE_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (adapter != null && cursor != null) {
            adapter.changeCursor(cursor);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (adapter != null) {
            adapter.changeCursor(null);
        }
    }

    private void showData() {
        loaderManager.restartLoader(0, null, this);
    }  // обновление данных

    public interface DownFragmentListener {
        void DownFragmentShow();
    }
}
