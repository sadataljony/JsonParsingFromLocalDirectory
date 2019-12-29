package com.sadataljony.app.android.loadjsondatafromlocaldirectory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadataljony.app.android.loadjsondatafromlocaldirectory.R;
import com.sadataljony.app.android.loadjsondatafromlocaldirectory.model.Employee;

import java.util.List;

public class AdapterEmployee extends RecyclerView.Adapter<AdapterEmployee.CustomViewHolder> {
    private Context context;
    private List<Employee> employeeList;

    // todo received data from  activity    List<Employee> employeeList
    public AdapterEmployee(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(context).inflate(R.layout.row_employee, viewGroup, false); //TODO your xml
        return new CustomViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int pos) {
        Employee employee = employeeList.get(pos);
        customViewHolder.tvId.setText(employee.getEmpId());
        customViewHolder.tvName.setText(employee.getEmpName());
        customViewHolder.tvDesignation.setText(employee.getEmpDesignation());
        customViewHolder.tvSalary.setText(employee.getEmpSalary());
        customViewHolder.tvFatherName.setText(employee.getEmpFatherName());
    }

    @Override
    public int getItemCount() {
        return employeeList == null ? 0 : employeeList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvId;
        private TextView tvDesignation;
        private TextView tvSalary;
        private TextView tvFatherName;

        private CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            tvId = itemView.findViewById(R.id.id);
            tvDesignation = itemView.findViewById(R.id.designation);
            tvSalary = itemView.findViewById(R.id.salary);
            tvFatherName = itemView.findViewById(R.id.fatherName);

        }
    }
}