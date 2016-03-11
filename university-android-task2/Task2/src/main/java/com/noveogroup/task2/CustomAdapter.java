package com.noveogroup.task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by serg on 10.03.16.
 */
public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Employee> employeeList;

    public CustomAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Employee getItem(int position) {
        return employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.surname = (TextView) convertView.findViewById(R.id.surname);
            holder.skills = (TextView) convertView.findViewById(R.id.skills);

            convertView.setTag(holder);
        }

        holder = holder == null ? (ViewHolder) convertView.getTag() : holder;

        final Employee item = getItem(position);

        holder.name.setText(item.getName());
        holder.surname.setText(item.getSurname());
        holder.skills.setText(item.getSkills());

        return convertView;
    }

    private class ViewHolder {
        private TextView name;
        private TextView surname;
        private TextView skills;
    }
}
