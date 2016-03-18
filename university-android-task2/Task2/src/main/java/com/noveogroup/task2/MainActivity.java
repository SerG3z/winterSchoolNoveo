package com.noveogroup.task2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends Activity {

    private final static String itemEmployeeKey = "itemEmployeeKey";
    private final static String listEmployeeKey = "listEmployeeKey";
    private static Employee showItemEmployee = null;
    private static int positionInListView;
    private static InputMethodManager inputMethodManager;
    private static boolean clickEditButton = false;

    @Nullable @Bind(R.id.name_land)
    TextView nameLandTextView;
    @Nullable @Bind(R.id.surname_land)
    TextView surnameLandTextView;
    @Nullable @Bind(R.id.skills_land)
    TextView skillsLandTextView;
    @Nullable @Bind(R.id.edit_land)
    Button editLandButton;
    @Bind(R.id.listEmployee)

    ListView employeeListView;
    private boolean tap = true;
    private int orientation;
    private ViewHolder holder;
    private List<Employee> employees = new ArrayList<>();

    private static Employee fillItemEmployee(String name, String surname, String skills) {
        return new Employee(name, surname, skills);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        listEmployeeInit(employees);

        final View inflate = LayoutInflater.from(this).inflate(R.layout.header, employeeListView, false);
        holder = new ViewHolder(inflate);

        orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            employeeListView.addHeaderView(inflate);
        }

        employeeListView.setAdapter(new CustomAdapter(this, employees));

        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (showItemEmployee != null) {
            fillFieldMoreInfo(showItemEmployee);
        }

        checkClickButtonEdit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void checkClickButtonEdit() {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (clickEditButton)
                showEditTextAndKeyboard(holder.skillsTextView, holder.editButton);
            else
                breakEditTextAndKeyboard(holder.skillsTextView, holder.editButton);
        } else {
            if (clickEditButton)
                showEditTextAndKeyboard(skillsLandTextView, editLandButton);
            else
                breakEditTextAndKeyboard(skillsLandTextView, editLandButton);
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

    private void breakEditTextAndKeyboard(TextView tmpSkillsTextView, Button tmpEditButton) {
        employees.get(MainActivity.positionInListView).setSkills(tmpSkillsTextView.getText().toString());
        tmpSkillsTextView.setEnabled(false);
        tmpSkillsTextView.setKeyListener(null);
        tap = true;
        tmpEditButton.setText(R.string.edit_button_edit);
        showItemEmployee = employees.get(positionInListView);
        clickEditButton = false;
    }


    private void showEditTextAndKeyboard(TextView tmpSkillsTextView, Button tmpEditButton) {
        tmpSkillsTextView.setEnabled(true);
        tmpSkillsTextView.setKeyListener(new EditText(getApplicationContext()).getKeyListener());
        tap = false;
        tmpEditButton.setText(R.string.edit_button_ok);
        inputMethodManager.showSoftInput(tmpSkillsTextView, InputMethodManager.SHOW_FORCED);
        tmpSkillsTextView.requestFocus();
        clickEditButton = true;
    }


    @OnItemClick(R.id.listEmployee)
    public void onItemClickListEmployee(int position) {
        position -= employeeListView.getHeaderViewsCount();
        positionInListView = position;

        final String nameStringTmp = employees.get(position).getName();
        final String surnameStringTmp = employees.get(position).getSurname();
        final String skillsStringTmp = employees.get(position).getSkills();

        showItemEmployee = fillItemEmployee(nameStringTmp, surnameStringTmp, skillsStringTmp);

        fillFieldMoreInfo(showItemEmployee);

        clickNewEmployee();
    }

    private void fillFieldMoreInfo(Employee tmpEmployee) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            holder.nameTextView.setText(tmpEmployee.getName());
            holder.surnameTextView.setText(tmpEmployee.getSurname());
            holder.skillsTextView.setText(tmpEmployee.getSkills());
        } else {
            nameLandTextView.setText(tmpEmployee.getName());
            surnameLandTextView.setText(tmpEmployee.getSurname());
            skillsLandTextView.setText(tmpEmployee.getSkills());
        }
    }


    private void clickNewEmployee() {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            breakEditTextAndKeyboard(holder.skillsTextView, holder.editButton);
        } else {
            breakEditTextAndKeyboard(skillsLandTextView, editLandButton);
        }
    }


    @Nullable @OnClick(R.id.edit_land)
    public void onClickButtonEditLandscape() {
        if (tap) {
            showEditTextAndKeyboard(skillsLandTextView, editLandButton);
        } else {
            breakEditTextAndKeyboard(skillsLandTextView, editLandButton);
        }
    }

    private void saveTextFromEditText() {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            showItemEmployee.setSkills(holder.skillsTextView.getText().toString());
        } else {
            showItemEmployee.setSkills(skillsLandTextView.getText().toString());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveTextFromEditText();
        outState.putParcelable(itemEmployeeKey, showItemEmployee);
        outState.putParcelableArrayList(listEmployeeKey, (ArrayList<? extends Parcelable>) employees);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        employees = savedInstanceState.getParcelableArrayList(listEmployeeKey);
        showItemEmployee = savedInstanceState.getParcelable(itemEmployeeKey);
    }

    class ViewHolder {
        @Bind(R.id.name_header)
        TextView nameTextView;
        @Bind(R.id.surname_header)
        TextView surnameTextView;
        @Bind(R.id.skills_header)
        EditText skillsTextView;
        @Bind(R.id.edit_header)
        Button editButton;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Nullable @OnClick(R.id.edit_header)
        public void onClickButtonEditPortrait(View view) {
            if (tap) {
                showEditTextAndKeyboard(skillsTextView, editButton);
            } else {
                breakEditTextAndKeyboard(skillsTextView, editButton);
            }
        }
    }
}
