package com.noveogroup.task3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * Created by serg on 18.03.16.
 */
public class SpinnerActivity extends AppCompatActivity {

    public static final int COUNT_RECORD_IN_SPINNER1 = 5;
    @Bind(R.id.spinner_nav)
    Spinner spinnerToolbar;

    @Bind(R.id.spinner_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_toolbar_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        addItemsToSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.room:
                Toast.makeText(getApplicationContext(), R.string.click_room, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.rowing:
                Toast.makeText(getApplicationContext(), R.string.click_rowing, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.setting:
                Toast.makeText(getApplicationContext(), R.string.click_setting, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addItemsToSpinner() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < COUNT_RECORD_IN_SPINNER1; i++) {
            list.add(getString(R.string.record, i));
        }

        SpinnerAdapter spinAdapter = new SpinnerAdapter(
                getApplicationContext(), list);

        spinnerToolbar.setAdapter(spinAdapter);
    }

    @OnItemSelected(R.id.spinner_nav)
    public void onClickItemSpinner(AdapterView<?> adapter, View v, int position, long id) {
        String item = adapter.getItemAtPosition(position).toString();

        Toast.makeText(getApplicationContext(), getString(R.string.select, item),
                Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
