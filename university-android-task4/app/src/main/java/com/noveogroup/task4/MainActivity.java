package com.noveogroup.task4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {

    BaseFragment fragment1;
    BaseFragment fragment2;
    android.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        fragment1 = new BaseFragment();

        fragment2 = new BaseFragment();

        fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.fragment_layout, fragment1);
        fragmentTransaction.add(R.id.fragment_layout, fragment2);
        fragmentTransaction.commit();
    }
}
