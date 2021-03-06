package com.noveogroup.task4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

/**
 * Created by admin on 3/21/2016.
 */
public class Fragment4WebView extends WebViewFragment {

    private static final String url = "https://github.com/noveogroup/university-android-task4";

    public static Fragment4WebView newInstance() {
        return new Fragment4WebView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = super.onCreateView(inflater, container, savedInstanceState);
        getWebView().getSettings().setJavaScriptEnabled(true);

        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(url);
        return result;
    }
}

