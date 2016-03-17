package com.noveogroup.tas1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

    private final static String DATEBORN_KEY = "dateKey";
    private final static String DATAPICKER_KEY = "datePicker";

    @Bind(R.id.dataBorn)
    TextView dateTextView;
    @Bind(R.id.Name)
    EditText nameEditText;
    @Bind(R.id.Famil)
    EditText secondNameEditText;
    DatePickerFragment newFragment;

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
    public void onBtnNextClick() {
        final int age = countAge();
        if (validateDate(age)) {

            final String nameSend = nameEditText.getText().toString();
            final String secondNameSend = secondNameEditText.getText().toString();
            final String ageSend = String.valueOf(age);

            Intent intent = SecondActivity.createIntent(
                    this,
                    nameSend,
                    secondNameSend,
                    ageSend);

            startActivity(intent);
        }
    }


    @OnClick(R.id.dataBorn)
    public void onClickDate() {
        newFragment = new DatePickerFragment();
        newFragment.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(final DatePicker datePicker, final int year, final int monthOfYear, final int dayOfMonth) {
                dateTextView.setText(getString(R.string.format_date, dayOfMonth, (monthOfYear + 1), year));
            }
        });
        newFragment.show(getFragmentManager(), DATAPICKER_KEY);
    }

    private int countAge() {
        String str = dateTextView.getText().toString();
        String[] tmp = str.split("-");
        if (tmp.length != 3) {
            return -1;
        }
        final int day = Integer.parseInt(tmp[0]);
        final int month = Integer.parseInt(tmp[1]);
        final int year = Integer.parseInt(tmp[2]);

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


    private boolean validateDate(final int age) {
        if (TextUtils.isEmpty(nameEditText.getText().toString())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getApplicationContext().getResources().getString(R.string.error_field_name),
                    Toast.LENGTH_SHORT);
            toast.show();
            return false;
        } else if (TextUtils.isEmpty(secondNameEditText.getText().toString())) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getApplicationContext().getResources().getString(R.string.error_field_secondname),
                    Toast.LENGTH_SHORT);
            toast.show();
            return false;
        } else if (age <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getApplicationContext().getResources().getString(R.string.error_field_age),
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
