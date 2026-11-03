package com.Mohamed.dao;

import com.Mohamed.Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDao {
    @Override
    public  List<Employee> findAll() {

        Connection con = DBConnection.getConnection();
                    if (con == null){
                        return null ; }
                    else{
                        String finadAllQuery= "Select * from Employee";
                        List<Employee> EmployeeList = new ArrayList<>();
                        try(PreparedStatement preparedStatement = con.prepareStatement(finadAllQuery)){

                            ResultSet resultSet = preparedStatement.executeQuery();

                            while (resultSet.next()) {

                                Employee emp = new Employee(resultSet.getNString("Name"), resultSet.getInt("ID"),
                                        resultSet.getDouble("Salary"), resultSet.getDate("Date_Employment").toLocalDate());

                                EmployeeList.add(emp);
                            }


                        }catch(SQLException se){
                            se.printStackTrace();
                        }

                        finally {
                            try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return EmployeeList ;
        }
    }

    @Override
    public  Employee findByid(int id) {

        Employee Employee_id = null;
int EmployeeId = id ;
        Connection con = DBConnection.getConnection();
        if (con == null){
            return null ; }
        else{
            String finadByidQuery= "Select * from Employee where id = ? ;";

            try(PreparedStatement preparedStatement = con.prepareStatement(finadByidQuery)){
                preparedStatement.setInt(1,EmployeeId);
                ResultSet resultSet = preparedStatement.executeQuery();
if (resultSet.next()){
                    Employee_id = new Employee();
                    Employee_id.setEmployeeName(resultSet.getNString("Name"));
                    Employee_id.setSalary(resultSet.getDouble("Salary"));
                    Employee_id.setEmployeeId(resultSet.getInt("ID"));
                    Employee_id.setDate_Employment(resultSet.getDate("Date_Employment").toLocalDate());
    System.out.println("Done ");
}
else{
    System.out.println("No employee found with the provided ID.");
}
            }catch(SQLException se){
                se.printStackTrace();
            }

            finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return Employee_id ;





    }

    @Override
    public void saveEmployee(Employee emp) {

        Connection con = DBConnection.getConnection();
        if (con == null){return ;}
        else {
            if (emp.getEmployeeId() > 0 )
            {
                // update Employee Data

                String updatequery = "update Employee " +
                        "set Name = ? ," +
                        " Salary = ? , " +
                        " Date_Employment = ?" +
                        "where ID= ? ;";

                try(PreparedStatement preparedStatement = con.prepareStatement(updatequery)){


                    preparedStatement.setString(1,emp.getEmployeeName());
                    preparedStatement.setDouble(2,emp.getSalary());
                    preparedStatement.setDate(3, Date.valueOf(emp.getDate_Employment()));
                    preparedStatement.setInt(4, emp.getEmployeeId());

                    preparedStatement.executeUpdate();

                }catch (SQLException se){
                    se.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
            else {
                // Save new Employee

                String savequery = "insert into Employee (Name , Salary ,Date_Employment) values(?,?,?) ";

                try(PreparedStatement preparedStatement = con.prepareStatement(savequery)){


                    preparedStatement.setString(1,emp.getEmployeeName());
                    preparedStatement.setDouble(2,emp.getSalary());
                    preparedStatement.setDate(3, Date.valueOf(emp.getDate_Employment()));

                    preparedStatement.executeUpdate();

                }catch (SQLException se){
                    se.printStackTrace();
                }finally {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }



            }





        }




    }

    @Override
    public void deleteEmployee(int id) {

        int Employee_ID = id ;
        Connection con = DBConnection.getConnection();
        if (con == null){return ;}
        else{

            String DeleteQuery= "delete from Employee where ID = ? ;" ;
                    try(PreparedStatement preparedStatement = con.prepareStatement(DeleteQuery)){
                        preparedStatement.setInt(1,Employee_ID);
                        preparedStatement.executeUpdate();

                    }catch (SQLException se){
                        se.printStackTrace();
                    }finally {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

        }






    }
}
