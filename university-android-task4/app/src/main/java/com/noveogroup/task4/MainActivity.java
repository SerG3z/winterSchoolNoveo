package com.noveogroup.task4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements Fragment3DialogFragment.DialogFragmentListener, BaseFragment.BaseFragmentListener {

    private static final String TAG_FRAGMENT1 = "fragment1";
    private static final String TAG_FRAGMENT3 = "fragment3";
    private static final String FIRSTCLICK_KEY = "key_bool";

    BaseFragment fragment1;
    Fragment3DialogFragment fragment3;
    Fragment4WebView fragment4;
    FragmentManager fragmentManager;

    private boolean firstClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        fragmentManager = getFragmentManager();

        if (savedInstanceState == null) {
            fragment1 = BaseFragment.newInstance(false);
            fragment3 = Fragment3DialogFragment.newInstance();
            fragment4 = Fragment4WebView.newInstance();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container1, fragment1, TAG_FRAGMENT1)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container3, fragment3, TAG_FRAGMENT3)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container4, fragment4)
                    .commit();
        }
    }

    @Override
    public void onFragmentClicked() {
        fragment3.newInstance().show(fragmentManager, TAG_FRAGMENT3);
    }

    @Override
    public void onBaseFragmentClicked() {
        if (firstClick) {
            firstClick = false;
            swapFragment(R.id.frame_container1, R.id.frame_container4, fragmentManager);
        }
    }

    public void swapFragment(int container1, int container2, FragmentManager manager) {

        Fragment f1 = manager.findFragmentById(container1);
        Fragment f2 = manager.findFragmentById(container2);

        FragmentTransaction ft = manager.beginTransaction();
        ft.remove(f1);
        ft.remove(f2);
        ft.commit();
        manager.executePendingTransactions();

        ft = manager.beginTransaction();
        ft.add(container1, f2);
        ft.add(container2, f1);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        ft.commit();
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(FIRSTCLICK_KEY, firstClick);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstClick = savedInstanceState.getBoolean(FIRSTCLICK_KEY);
    }

}
