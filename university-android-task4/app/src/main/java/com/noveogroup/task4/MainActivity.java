package com.noveogroup.task4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class MainActivity extends ActionBarActivity implements Fragment3DialogFragment.DialogFragmentListener, BaseFragment.BaseFragmentListener {

    private static final String TAG_FRAGMENT1 = "baseFragment";
    private static final String TAG_FRAGMENT3 = "dialogFragment";
    private static final String TAG_FRAGMENT3_SHOW = "dialog_show";
    private static final String TAP_FRAGMENT3_KEY = "key_tap";
    private static final String FIRSTCLICK_KEY = "key_bool";
    BaseFragment baseFragment;
    Fragment3DialogFragment dialogFragment;
    Fragment4WebView webViewFragment;
    FragmentManager fragmentManager;

    private boolean clickDialogFragment = true;
    private boolean firstClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        fragmentManager = getFragmentManager();

        if (savedInstanceState == null) {
            baseFragment = BaseFragment.newInstance(false);
            dialogFragment = Fragment3DialogFragment.newInstance();
            webViewFragment = Fragment4WebView.newInstance();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container1, baseFragment, TAG_FRAGMENT1)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container3, dialogFragment, TAG_FRAGMENT3)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container4, webViewFragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentClicked() {
        if (clickDialogFragment) {
                dialogFragment = Fragment3DialogFragment.newInstance();
                clickDialogFragment = false;
                fragmentManager.beginTransaction()
                        .add(dialogFragment, TAG_FRAGMENT3_SHOW)
                        .show(dialogFragment)
                        .commit();
        } else {
            clickDialogFragment = true;
            if (dialogFragment != null)
                fragmentManager.beginTransaction()
                        .remove(dialogFragment)
                        .commit();
        }
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
        outState.putBoolean(TAP_FRAGMENT3_KEY, clickDialogFragment);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstClick = savedInstanceState.getBoolean(FIRSTCLICK_KEY);
        clickDialogFragment = savedInstanceState.getBoolean(TAP_FRAGMENT3_KEY);
    }

}
