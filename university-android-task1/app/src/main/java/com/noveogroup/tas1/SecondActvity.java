package com.noveogroup.tas1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.noveogroup.task1.R;

import java.util.AbstractCollection;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by serg on 28.02.16.
 */
public class SecondActvity extends Activity {

    @Bind(R.id.NameS) TextView Name;
    @Bind(R.id.SecondName) TextView SecondName;
    @Bind(R.id.Date) TextView Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Name.setText(intent.getStringExtra("name"));
        SecondName.setText(intent.getStringExtra("secondName"));
        Date.setText(intent.getStringExtra("date"));

    }
}
