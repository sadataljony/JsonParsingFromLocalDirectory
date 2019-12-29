package com.sadataljony.app.android.loadjsondatafromlocaldirectory.model;

public class Employee {
    private String empId;
    private String empName;
    private String empDesignation;
    private String empSalary;
    private String empFatherName;

    public Employee(String empId, String empName, String empDesignation, String empSalary, String empFatherName) {
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
        this.empFatherName = empFatherName;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public String getEmpFatherName() {
        return empFatherName;
    }
}
