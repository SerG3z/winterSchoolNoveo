package com.noveogroup.task2;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    static boolean tap = true;
    static boolean tap2 = true;
    List<Employee> employees = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listemployeeInit(employees);

        final ListView listView = (ListView) findViewById(R.id.listEmployee);

        final TextView name_land = (TextView) findViewById(R.id.name_land);
        final TextView surname_land = (TextView) findViewById(R.id.surname_land);
        final TextView skills_land = (TextView) findViewById(R.id.skills_land);
        final Button btn_edit_land = (Button) findViewById(R.id.edit_land);

        final ViewHolder holder = new ViewHolder();
        final View v = getLayoutInflater().inflate(R.layout.header, listView, false);

        final int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            listView.addHeaderView(v);
        }
        listView.setAdapter(new CustomAdapter(this, employees));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                position -= listView.getHeaderViewsCount();

                if (orientation == Configuration.ORIENTATION_PORTRAIT) {

                    holder.name = (TextView) v.findViewById(R.id.name_header);
                    holder.surname = (TextView) v.findViewById(R.id.surname_header);
                    holder.skills = (EditText) v.findViewById(R.id.skills_header);
                    holder.btn_edit = (Button) v.findViewById(R.id.edit_header);

                    holder.name.setText(employees.get(position).getName());
                    holder.surname.setText(employees.get(position).getSurname());
                    holder.skills.setText(employees.get(position).getSkills());

                    final int finalPosition = position;

                    holder.btn_edit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (tap == true) {
                                holder.skills.setEnabled(true);
                                holder.skills.setCursorVisible(true);
                                holder.skills.setKeyListener(new EditText(getApplicationContext()).getKeyListener());
                                tap = false;
                                holder.btn_edit.setText("Ok");

                            } else {
                                employees.get(finalPosition).setSkills(holder.skills.getText().toString());

                                holder.skills.setEnabled(false);
                                holder.skills.setCursorVisible(false);
                                holder.skills.setKeyListener(null);
                                tap = true;
                                holder.btn_edit.setText("Edit");
                            }
                        }
                    });

                    if (listView.getHeaderViewsCount() == 0) {
                        listView.addHeaderView(v);
                    }
                } else {
                    name_land.setText(employees.get(position).getName());
                    surname_land.setText(employees.get(position).getSurname());
                    skills_land.setText(employees.get(position).getSkills());

                    final int posit = position;

                    btn_edit_land.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (tap2 == true) {
                                skills_land.setEnabled(true);
                                skills_land.setCursorVisible(true);
                                skills_land.setKeyListener(new EditText(getApplicationContext()).getKeyListener());
                                tap2 = false;
                                btn_edit_land.setText("Ok");

                            } else {
                                employees.get(posit).setSkills(skills_land.getText().toString());

                                skills_land.setEnabled(false);
                                skills_land.setCursorVisible(false);
                                skills_land.setKeyListener(null);
                                tap2 = true;
                                btn_edit_land.setText("Edit");
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelableArrayList("array", (ArrayList<? extends Parcelable>) employees);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        employees = savedInstanceState.getStringArray("array");
    }

    private void listemployeeInit(List<Employee> employees) {
        final String name = "Name ";
        final String surname = "SurName ";
        final String skills = "Skills ";

        for (int i = 0; i < 100; i++) {
            employees.add(new Employee(name + i, surname + i, skills + i));
        }
    }

    private class ViewHolder {
        private TextView name;
        private TextView surname;
        private EditText skills;
        private Button btn_edit;
    }
}
