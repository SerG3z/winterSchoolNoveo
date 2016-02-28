package com.noveogroup.tas1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.noveogroup.task1.R;

import java.util.AbstractCollection;

/**
 * Created by serg on 28.02.16.
 */
public class SecondActvity extends Activity {

    TextView Name;
    TextView SecondName;
    TextView Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Name = (TextView) findViewById(R.id.NameS);
        SecondName = (TextView) findViewById(R.id.SecondName);
        Date = (TextView) findViewById(R.id.Date);

        Intent intent = getIntent();

        Name.setText(intent.getStringExtra("name"));
        SecondName.setText(intent.getStringExtra("secondName"));
        Date.setText(intent.getStringExtra("date"));

    }
}
