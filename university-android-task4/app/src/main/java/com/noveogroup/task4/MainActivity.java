package com.noveogroup.task4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements Fragment3DialogFragment.DialogFragmentListener, BaseFragment.BaseFragmentListener {

    private static final String TAG_FRAGMENT1 = "baseFragment";
    private static final String TAG_FRAGMENT3 = "dialogFragment";
    private static final String TAG_FRAGMENT3_SHOW = "dialog_show";
    private static final String FIRSTCLICK_KEY = "key_bool";

    private boolean firstClick = true;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        BaseFragment baseFragment;
        Fragment4WebView webViewFragment;
        Fragment3DialogFragment dialogFragment;

        fragmentManager = getFragmentManager();

        if (savedInstanceState == null) {
            baseFragment = BaseFragment.newInstance(false);
            dialogFragment = Fragment3DialogFragment.newInstance();
            webViewFragment = Fragment4WebView.newInstance();

            fragmentManager.beginTransaction()
                    .add(R.id.frame_container1, baseFragment, TAG_FRAGMENT1)
                    .add(R.id.frame_container3, dialogFragment, TAG_FRAGMENT3)
                    .add(R.id.frame_container4, webViewFragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentClicked() {
        Fragment3DialogFragment dialog = (Fragment3DialogFragment) fragmentManager.findFragmentByTag(TAG_FRAGMENT3_SHOW);
        if (dialog == null) {
            dialog = Fragment3DialogFragment.newInstance();
        }

        if (dialog.isVisible()) {
            dialog.setClikedFlag(false);
        }

        if (dialog.isClikedFlag()) {
            dialog.setClikedFlag(false);
            dialog.show(fragmentManager, TAG_FRAGMENT3_SHOW);
        } else {
            dialog.setClikedFlag(true);
            if (dialog.isVisible())
                dialog.dismiss();
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
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstClick = savedInstanceState.getBoolean(FIRSTCLICK_KEY);
    }

}
