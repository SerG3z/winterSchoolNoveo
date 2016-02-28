package com.noveogroup.tas1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
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

/**
 * Created by serg on 28.02.16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    int DIALOG_DATE = 1;
    int Year = 1990;
    int Mounth = 1;
    int Day = 1;

    EditText Name;
    EditText SecondName;
    TextView Date;
    Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date = (TextView) findViewById(R.id.dataBorn);

        Name = (EditText) findViewById(R.id.Name);
        SecondName = (EditText) findViewById(R.id.Famil);

        btnNextActivity = (Button) findViewById(R.id.buttonNextActivity);
        btnNextActivity.setOnClickListener( this);
    }

    public void onclick(View view) {
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, Year, Mounth, Day);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Year = year;
            Mounth = monthOfYear + 1;
            Day = dayOfMonth;
            Date.setText(Day + "." + Mounth + "." + Year);
        }
    };

    private int CounterAge(){
        int age;
        Calendar c = Calendar.getInstance();
        int mount = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        age = c.get(Calendar.YEAR);
        age = age - Year;
        if (mount < Mounth-1) {
            age--;
        } else if (mount == Mounth-1){
            if (day < Day) {
                age--;
            }
        }
        return age;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActvity.class);
        intent.putExtra("name", Name.getText().toString());
        intent.putExtra("secondName", SecondName.getText().toString());
        int age = CounterAge();
        intent.putExtra("date", String.valueOf(age));
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("date", Date.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Date.setText(savedInstanceState.getString("date"));
    }
}
