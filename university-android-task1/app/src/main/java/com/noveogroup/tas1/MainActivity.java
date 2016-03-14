package com.noveogroup.tas1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.noveogroup.task1.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by serg on 28.02.16.
 */
public class MainActivity extends Activity {

    @Bind(R.id.dataBorn) TextView dateTextView;
    @Bind(R.id.Name) EditText nameEditText;
    @Bind(R.id.Famil) EditText secondNameEditText;


    DialogFragment newFragment;

    final String DATEBORN_KEY = "dateKey";
    final String DATAPICKER_KEY = "datePicker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.buttonNextActivity)
    public void BtnNextActivity(){
        final int age = counterAge();
        if (validationDate(age)){

            Intent intent = SecondActvity.createIntent(
                    nameEditText.getText().toString(),
                    secondNameEditText.getText().toString(),
                    String.valueOf(age));

            startActivity(intent);
        }
    }

    @OnClick(R.id.dataBorn)
    public void onClickDate(View view) {
        newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), DATAPICKER_KEY);

    }


    final DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dateTextView.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
        }
    };

    private int counterAge() {
        int year = 2016;
        int month = 1;
        int day = 1;

        String str = dateTextView.getText().toString();
        String[] tmp = str.split("-");
        if (tmp.length == 3) {
            day = Integer.parseInt(tmp[0]);
            month = Integer.parseInt(tmp[1]);
            year = Integer.parseInt(tmp[2]);
        } else {
            return -1;
        }

        final Calendar calendar = Calendar.getInstance();
        final int currentMonth = calendar.get(Calendar.MONTH);
        final int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int currentYear = calendar.get(Calendar.YEAR);
        int age = currentYear - year;

        if (currentMonth < month - 1) {
                age--;
        } else if (currentMonth == month - 1) {
            if (currentDay < day) {
                age--;
            }
        }

        return age;
    }


    private boolean validationDate(final int age){
        if (nameEditText.getText().toString().equals("")){
            return false;
        } else if (secondNameEditText.getText().toString().equals("")){
            return false;
        } else if (age < 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getApplicationContext().getResources().getString(R.string.error_age),
                    Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DATEBORN_KEY, dateTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dateTextView.setText(savedInstanceState.getString(DATEBORN_KEY));
    }
}
