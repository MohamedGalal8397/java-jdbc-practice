package com.Mohamed.Model;

import java.time.LocalDate;

public class Employee {

   private  String EmployeeName ;
    private int EmployeeId ;
    private double Salary ;
    private LocalDate Date_Employment ;

    public Employee() {
    }

    public Employee(String employeeName, int employeeId, double salary, LocalDate date_Employment) {
        EmployeeName = employeeName;
        EmployeeId = employeeId;
        Salary = salary;
        Date_Employment = date_Employment;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public double getSalary() {
        return Salary;
    }

    public LocalDate getDate_Employment() {
        return Date_Employment;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public void setDate_Employment(LocalDate date_Employment) {
        Date_Employment = date_Employment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeId=" + EmployeeId +
                ", Salary=" + Salary +
                ", Date_Employment=" + Date_Employment +
                '}';
    }
}
