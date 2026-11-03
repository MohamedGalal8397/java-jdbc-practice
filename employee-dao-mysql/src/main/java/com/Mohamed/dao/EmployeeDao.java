package com.Mohamed.dao;

import com.Mohamed.Model.Employee;

import java.util.*;

public interface EmployeeDao {

   public List<Employee> findAll();
   public Employee findByid(int id);
    public void saveEmployee(Employee emp);
    public void deleteEmployee(int id);

}
