package com.noveogroup.task2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Employee> employees = new ArrayList<>();
        final String name = "Name";
        final String surname = "SurName";
        final String skills = "Skills";

        for (int i = 0; i < 100; i++) {
            employees.add(new Employee(name + i, surname + i, skills + i));
        }

        final ListView listView = (ListView)findViewById(R.id.listEmployee);
        listView.setAdapter(new CustomAdapter(this, employees));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        getString(R.string.toast_message, position),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

}
