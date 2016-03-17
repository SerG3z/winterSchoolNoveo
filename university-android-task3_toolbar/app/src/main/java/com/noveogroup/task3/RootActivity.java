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
    public void onClick(){
        Intent intent = new Intent(this, SimpleToolbarActivity.class);
        startActivity(intent);
    }


    public void dummy(View view) {
        Toast.makeText(this, R.string.dragon, Toast.LENGTH_SHORT).show();
    }

}
