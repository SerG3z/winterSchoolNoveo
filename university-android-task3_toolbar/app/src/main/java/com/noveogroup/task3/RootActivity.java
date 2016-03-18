package com.noveogroup.task3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RootActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.simple_toolbar_button)
    public void onClickSimpleToolbar(){
        Intent intent = new Intent(this, SimpleToolbarActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.simple_toolbar_up_button)
    public void onClickSimpleToolbarUp() {
        Intent intent = new Intent(this, ToolbarUpActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.toolbar_tabs_button)
    public void onClickToolbarTabs() {
        Intent intent = new Intent(this, ToolbarTabsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.toolbar_actionview_button)
    public void onClickToolbarActionView() {
        Intent intent = new Intent(this, ToolbarActionViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.spinner_button)
    public void onClickSpinnerButton() {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }


    public void dummy(View view) {
        Toast.makeText(this, R.string.dragon, Toast.LENGTH_SHORT).show();
    }

}
