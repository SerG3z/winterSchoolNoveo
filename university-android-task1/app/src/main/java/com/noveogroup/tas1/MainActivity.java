package com.noveogroup.tas1;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.noveogroup.task1.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by serg on 28.02.16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.dataBorn) TextView dateTextView;
    @Bind(R.id.Name) EditText nameEditText;
    @Bind(R.id.Famil) EditText secondNameEditText;
    @Bind(R.id.buttonNextActivity) Button btnNextActivity;

    DialogFragment newFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btnNextActivity.setOnClickListener(this);
    }


    public void onClickDate(View view) {
        newFragment = new DatePickerFragment(view);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    private int counterAge() {
        int year = 2016;
        int mounth = 1;
        int day = 1;

        String str = dateTextView.getText().toString();
        String[] tmp = str.split("-");
        if (tmp.length == 3) {
            day = Integer.parseInt(tmp[0]);
            mounth = Integer.parseInt(tmp[1]);
            year = Integer.parseInt(tmp[2]);
        } else {
            return -1;
        }

        final Calendar calendar = Calendar.getInstance();
        final int curentMounth = calendar.get(Calendar.MONTH);
        final int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int currentYear = calendar.get(Calendar.YEAR);
        int age = currentYear - year;


        if (curentMounth < mounth - 1) {
                age--;
            } else if (curentMounth == mounth - 1) {
                if (currentDay < day) {
                    age--;
                }
            }

            return age;
        }

        @Override
    public void onClick(View v) {
        final int age = counterAge();
        if (validationDate(age)){
            Intent intent = new Intent(this, SecondActvity.class);
            intent.putExtra("nameEditText", nameEditText.getText().toString());
            intent.putExtra("secondNameEditText", secondNameEditText.getText().toString());
            intent.putExtra("dateTextView", String.valueOf(age));
            startActivity(intent);
        }
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
        outState.putString("dateTextView", dateTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dateTextView.setText(savedInstanceState.getString("dateTextView"));
    }
}
