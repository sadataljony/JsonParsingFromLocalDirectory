package com.sadataljony.app.android.loadjsondatafromlocaldirectory.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sadataljony.app.android.loadjsondatafromlocaldirectory.R;
import com.sadataljony.app.android.loadjsondatafromlocaldirectory.adapter.AdapterEmployee;
import com.sadataljony.app.android.loadjsondatafromlocaldirectory.model.Employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Employee> mList = new ArrayList<>();
    private AdapterEmployee mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        initUi();// Initialized all ui elements
        loadJsonDataFromLocal();// Load JSON Data from Local Directory
    }

    private void initUi() {
        mRecyclerView = findViewById(R.id.emp_recycler_view);// initialized RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(EmployeeActivity.this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new AdapterEmployee(EmployeeActivity.this, mList);
        mRecyclerView.setAdapter(mAdapter);// set Adapter in RecyclerView
    }

    private void loadJsonDataFromLocal() {

        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());// Load JSON File From Asset Folder
            String responseCode = jsonObject.getString("responseCode");
            String responseMessage = jsonObject.getString("responseMessage");
            String responseTime = jsonObject.getString("responseTime");

            if (responseCode.equals("200")) {

            } else {
                Toast.makeText(this, "No Record Found ", Toast.LENGTH_SHORT).show();
            }

            JSONArray employeeArray = jsonObject.getJSONArray("employeesList");// read Employee Array
            for (int i = 0; i < employeeArray.length(); i++) {
                JSONObject jsonObjectEmployee = employeeArray.getJSONObject(i);
                String empId = jsonObjectEmployee.getString("empId");
                String empName = jsonObjectEmployee.getString("empName");
                String empDesignation = jsonObjectEmployee.getString("empDesignation");
                String empSalary = jsonObjectEmployee.getString("empSalary");
                String empFatherName = jsonObjectEmployee.getString("empFatherName");
                mList.add(new Employee(empId,empName,empDesignation, empSalary, empFatherName));
                mAdapter.notifyDataSetChanged();
            }

            if (mList != null) {
                mRecyclerView.setAdapter(mAdapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = EmployeeActivity.this.getAssets().open("employees.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
