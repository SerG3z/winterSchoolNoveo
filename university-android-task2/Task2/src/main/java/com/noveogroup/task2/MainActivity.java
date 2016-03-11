package com.noveogroup.task2;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    static boolean tap = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Employee> employees = new ArrayList<>();
        final String name = "Name ";
        final String surname = "SurName ";
        final String skills = "Skills ";

        for (int i = 0; i < 100; i++) {
            employees.add(new Employee(name + i, surname + i, skills + i));
        }

        final ListView listView = (ListView) findViewById(R.id.listEmployee);
        final TextView name_land = (TextView) findViewById(R.id.name_land);
        final TextView surname_land = (TextView) findViewById(R.id.surname_land);
        final TextView skills_land = (TextView) findViewById(R.id.skills_land);
        final Button btn_edit = (Button) findViewById(R.id.edit_land);

        final ViewHolder holder = new ViewHolder();
        final View v = getLayoutInflater().inflate(R.layout.header, listView, false);
        listView.setAdapter(new CustomAdapter(this, employees));

        final int orientation=this.getResources().getConfiguration().orientation;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                position -= listView.getHeaderViewsCount();

                Toast.makeText(MainActivity.this,
                        getString(R.string.toast_message, position),
                        Toast.LENGTH_SHORT).show();

                if (orientation == Configuration.ORIENTATION_PORTRAIT) {

                    holder.name = (TextView) v.findViewById(R.id.name_header);
                    holder.surname = (TextView) v.findViewById(R.id.surname_header);
                    holder.skills = (TextView) v.findViewById(R.id.skills_header);

                    listView.getItemAtPosition(position);

                    holder.name.setText("Name : " + employees.get(position).getName());
                    holder.surname.setText("Surname : " + employees.get(position).getSurname());
                    holder.skills.setText("Skills : " + employees.get(position).getSkills());

                    if (listView.getHeaderViewsCount() == 0) {
                        listView.addHeaderView(v);
                    }
                } else {
                    name_land.setText("Name : " + employees.get(position).getName());
                    surname_land.setText("Surname : " + employees.get(position).getSurname());
                    skills_land.setText("Skills : " + employees.get(position).getSkills());
                }
            }
        });


//        btn_edit.setOnClickListener();


    }

    private class ViewHolder {
        private TextView name;
        private TextView surname;
        private TextView skills;
    }

}
