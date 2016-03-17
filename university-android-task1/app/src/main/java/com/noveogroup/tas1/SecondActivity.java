package com.noveogroup.tas1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.noveogroup.task1.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by serg on 28.02.16.
 */
public class SecondActivity extends Activity {

    private final static String NAME_KEY = "nameKey";
    private final static String SECONDNAME_KEY = "secondNamekey";
    private final static String DATEBORN_KEY = "dateKey";

    @Bind(R.id.NameS)
    TextView nameTextView;
    @Bind(R.id.SecondName)
    TextView secondNameTextView;
    @Bind(R.id.Date)
    TextView dateTextView;

    public static Intent createIntent(Context context, String name, String secondName, String age) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(NAME_KEY, name);
        intent.putExtra(SECONDNAME_KEY, secondName);
        intent.putExtra(DATEBORN_KEY, age);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
        initializateIntent();
    }

    private void initializateIntent() {
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra(NAME_KEY));
        secondNameTextView.setText(intent.getStringExtra(SECONDNAME_KEY));
        dateTextView.setText(intent.getStringExtra(DATEBORN_KEY));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
