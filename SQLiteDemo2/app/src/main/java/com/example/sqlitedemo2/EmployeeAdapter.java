package com.example.sqlitedemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Employee> EmployeeList;

    public EmployeeAdapter(Context context, int layout, List<Employee> employeeList) {
        this.context = context;
        this.layout = layout;
        EmployeeList = employeeList;
    }

    @Override
    public int getCount() {
        return EmployeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        if(EmployeeList.size() > 0 && position >= 0){
            final TextView id = convertView.findViewById(R.id.textViewIdEmployee);
            final TextView name = convertView.findViewById(R.id.textViewNameEmployee);
            final TextView address = convertView.findViewById(R.id.textViewAddressEmp);
            final TextView deptId = convertView.findViewById(R.id.textViewDeptId);
            final Employee employee = EmployeeList.get(position);
            id.setText(String.valueOf(employee.getId()));
            name.setText(employee.getName());
            address.setText(employee.getAddress());
            deptId.setText(String.valueOf(employee.getDeptId()));
        }
        return  convertView;
    }
}
