package com.noveogroup.tas1;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.noveogroup.task1.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by serg on 28.02.16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.dataBorn) TextView Date;
    @Bind(R.id.Name) TextView Name;
    @Bind(R.id.Famil) TextView SecondName;
    @Bind(R.id.buttonNextActivity) TextView btnNextActivity;

    DialogFragment newFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btnNextActivity.setOnClickListener(this);
    }


    public void onclick(View view) {
        newFragment = new DatePickerFragment(view);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    private int counterAge() {
        int Year = 2016;
        int Mounth = 1;
        int Day = 1;

        String str = Date.getText().toString();
        String[] tmp = str.split("-");
        if (tmp.length == 3) {
            Day = Integer.parseInt(tmp[0]);
            Mounth = Integer.parseInt(tmp[1]);
            Year = Integer.parseInt(tmp[2]);
        }
        int age;
        Calendar c = Calendar.getInstance();
        int mount = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        age = c.get(Calendar.YEAR);
        if (Year >= age) {
            return 0;
        }
        age = age - Year;
        if (mount < Mounth-1) {
            age--;
        } else if (mount == Mounth-1) {
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
        int age = counterAge();
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
