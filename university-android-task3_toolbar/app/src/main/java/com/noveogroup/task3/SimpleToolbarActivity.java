package com.noveogroup.task3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by serg on 17.03.16.
 */
public class SimpleToolbarActivity extends AppCompatActivity {

    @Bind(R.id.simple_toolbar)
    Toolbar simpleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);
        ButterKnife.bind(this);

        simpleToolbar.setTitle(R.string.simple);
        setSupportActionBar(simpleToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.room:
                Toast.makeText(getApplicationContext(), R.string.click_room, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.rowing:
                Toast.makeText(getApplicationContext(), R.string.click_rowing, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.setting:
                Toast.makeText(getApplicationContext(), R.string.click_setting, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
