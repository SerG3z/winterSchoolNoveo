package com.noveogroup.task2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends Activity {

    private static boolean tap  = true;
    private static boolean tap2 = true;

    private static List<Employee> employees = new ArrayList<>();
    private ViewHolder holder;
    private static int positionInListView;
    private int orientation;

    private static InputMethodManager inputMethodManager;

    @Nullable @Bind(R.id.name_land)     TextView nameLandTextView;
    @Nullable @Bind(R.id.surname_land)  TextView surnameLandTextView;
    @Nullable @Bind(R.id.skills_land)   TextView skillsLandTextView;
    @Nullable @Bind(R.id.edit_land)     Button   editLandButton;

    @Bind(R.id.listEmployee) ListView employeeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listEmployeeInit(employees);

        ButterKnife.bind(this);

        final View inflate = LayoutInflater.from(this).inflate(R.layout.header, employeeListView, false);
        holder = new ViewHolder(inflate);

        orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            employeeListView.addHeaderView(inflate);
        }

        employeeListView.setAdapter(new CustomAdapter(this, employees));

        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }



    @OnItemClick(R.id.listEmployee)
    public void onItemClickListEmployee(int position) {
        position -= employeeListView.getHeaderViewsCount();
        positionInListView = position;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            holder.nameTextView.setText(employees.get(position).getName());
            holder.surnameTextView.setText(employees.get(position).getSurname());
            holder.skillsTextView.setText(employees.get(position).getSkills());
        } else {
            nameLandTextView.setText(employees.get(position).getName());
            surnameLandTextView.setText(employees.get(position).getSurname());
            skillsLandTextView.setText(employees.get(position).getSkills());
        }
    }


    @Nullable @OnClick(R.id.edit_land)
    public void onClickButtonEditLandscape() {
        if (tap2) {
            skillsLandTextView.setEnabled(true);
            skillsLandTextView.setCursorVisible(true);
            skillsLandTextView.setKeyListener(new EditText(getApplicationContext()).getKeyListener());
            tap2 = false;
            editLandButton.setText("Ok");
            inputMethodManager.showSoftInput(skillsLandTextView, InputMethodManager.SHOW_FORCED);
            skillsLandTextView.requestFocus();
        } else {
            employees.get(positionInListView).setSkills(skillsLandTextView.getText().toString());
            skillsLandTextView.setEnabled(false);
            skillsLandTextView.setCursorVisible(false);
            skillsLandTextView.setKeyListener(null);
            tap2 = true;
            editLandButton.setText("Edit");
        }
    }

    private void listEmployeeInit(List<Employee> employees) {
        final int countEmployeeInList = 100;
        for (int i = 0; i < countEmployeeInList; i++) {
            employees.add(new Employee(getString(R.string.name_list, i),
                    getString(R.string.surname_list, i),
                    getString(R.string.skills_list, i)));
        }
    }

    static class ViewHolder {
        @Bind(R.id.name_header)     TextView nameTextView;
        @Bind(R.id.surname_header)  TextView surnameTextView;
        @Bind(R.id.skills_header)   EditText skillsTextView;
        @Bind(R.id.edit_header)     Button   editButton;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Nullable @OnClick(R.id.edit_header)
        public void onClickButtonEditPortrait(View view) {
            if (tap) {
                skillsTextView.setEnabled(true);
                skillsTextView.setCursorVisible(true);
                skillsTextView.setKeyListener(new EditText(view.getContext()).getKeyListener());
                tap = false;
                editButton.setText("Ok");
                inputMethodManager.showSoftInput(skillsTextView, InputMethodManager.SHOW_FORCED);
                skillsTextView.requestFocus();
            } else {
                employees.get(MainActivity.positionInListView).setSkills(skillsTextView.getText().toString());
                skillsTextView.setEnabled(false);
                skillsTextView.setCursorVisible(false);
                skillsTextView.setKeyListener(null);
                tap = true;
                editButton.setText("Edit");
            }
        }
    }
}
