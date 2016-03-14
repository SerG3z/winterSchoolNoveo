package com.noveogroup.tas1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;
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

    private final static String NAME_KEY = "nameKey";
    private final static String SECONDNAME_KEY = "secondNamekey";
    private final static String DATEBORN_KEY = "dateKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Name.setText(intent.getStringExtra(NAME_KEY));
        SecondName.setText(intent.getStringExtra(SECONDNAME_KEY));
        Date.setText(intent.getStringExtra(DATEBORN_KEY));
    }

    public static Intent createIntent(String name, String secondName, String age) {
        Intent intent = new Intent();
        intent.putExtra(NAME_KEY, name);
        intent.putExtra(SECONDNAME_KEY, secondName);
        intent.putExtra(DATEBORN_KEY, age);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
