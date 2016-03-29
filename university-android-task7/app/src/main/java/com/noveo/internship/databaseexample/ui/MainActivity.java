package com.noveo.internship.databaseexample.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.noveo.internship.databaseexample.R;
import com.noveo.internship.databaseexample.fragments.DownFragment;
import com.noveo.internship.databaseexample.fragments.UpFragment;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment upFragment = UpFragment.newInstance();
        Fragment downFragment = DownFragment.newInstance();

        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.layout_for_up_fragment, upFragment)
                .add(R.id.layout_for_down_fragment, downFragment)
                .commit();
    }
}
