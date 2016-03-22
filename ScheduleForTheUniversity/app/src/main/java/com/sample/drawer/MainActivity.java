package com.sample.drawer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.sample.drawer.fragments.ScheduleViewPagerFragment;
import com.sample.drawer.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends ActionBarActivity {

    private Drawer.Result drawerResult = null;
    private AccountHeader.Result headerResult = null;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDrawer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, ScheduleViewPagerFragment.newIntent()).commit();

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
//        headerResult = Utils.getAccountHeader(MainActivity.this, savedInstanceState);
        drawerResult = Utils.createCommonDrawer(MainActivity.this, toolbar, headerResult);
        drawerResult.setSelectionByIdentifier(1, false); // Set proper selection
//
        drawerResult.openDrawer();
    }

//    @Override
//    public void onBackPressed() {
//        if (drawerResult.isDrawerOpen()) {
//            drawerResult.closeDrawer();
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
