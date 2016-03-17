package com.noveogroup.task3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by serg on 18.03.16.
 */
public class ToolbarTabsActivity extends AppCompatActivity {

    public static final int TAB_SIZE = 5;

    @Bind(R.id.simple_toolbar)
    Toolbar simpleToolbar;

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_tabs);
        ButterKnife.bind(this);

        simpleToolbar.setTitle(R.string.simple_up);
        setSupportActionBar(simpleToolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < TAB_SIZE; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab1, i)));
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
