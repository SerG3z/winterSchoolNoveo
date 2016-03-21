package com.noveogroup.task4;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebView;


public class MainActivity extends ActionBarActivity {

    BaseFragment fragment1;
    BaseFragment fragment2;
    Fragment3DialogFragment fragment3;
    Fragment4WebView fragment4;

    FragmentManager fragmentManager;

    private static final String TAG_FRAGMENT1 = "fragment1";
    private static final String TAG_FRAGMENT2 = "fragment2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        fragment1 = new BaseFragment();
        fragment2 = new BaseFragment();
        fragment3 = new Fragment3DialogFragment();
        fragment4 = new Fragment4WebView();

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frame_container1, fragment1, TAG_FRAGMENT1)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container2, fragment2, TAG_FRAGMENT2)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container3, fragment3)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame_container4, fragment4)
                .commit();
    }
}
