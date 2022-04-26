package com.example.sqlitedemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class DepartmentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Department> departmentList;

    public DepartmentAdapter(Context context, int layout, List<Department> departmentList) {
        this.context = context;
        this.layout = layout;
        this.departmentList = departmentList;
    }

    @Override
    public int getCount() {
        return departmentList.size();
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
        if(departmentList.size() > 0 && position >= 0){
            final TextView id = (TextView) convertView.findViewById(R.id.textViewIdDepartment);
            final TextView name = (TextView) convertView.findViewById(R.id.textViewNameDepartment);
            final TextView location = (TextView) convertView.findViewById(R.id.textViewLocationDepartment);
            final Department department = departmentList.get(position);
            id.setText(String.valueOf(department.getId()));
            name.setText(department.getName());
            location.setText(department.getLocation());
        }
        return  convertView;
    }
}
