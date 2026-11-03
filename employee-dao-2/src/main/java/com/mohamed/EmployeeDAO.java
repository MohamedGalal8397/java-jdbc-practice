package com.mohamed;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee employee){

        String sql =
                "INSERT INTO employees (email ,first_name , last_name) VALUES (?, ? , ? )";

        try(
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

                ){

            statement.setString(1,employee.getEmail());
            statement.setString(2,employee.getFirstName());
            statement.setString(3,employee.getLastName());

           int affectedRows = statement.executeUpdate();

            System.out.println(
                    affectedRows + " employee inserted successfully."
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateEmployee (Employee employee){

        String sql =
                "UPDATE employees " +
                        "SET first_name = ? , last_name = ?, email = ? " +
                        "WHERE id = ?";


        try(
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
                ){

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getId());

          int affectedRows =  statement.executeUpdate();

          String res =  (affectedRows > 0) ?
                  "Employee updated successfully." :
                  "Employee not found.";

            System.out.println(res);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Employee getEmployee(int id){

        Employee employee = null ;
        String sql = "select id , first_name , last_name , email " +
                " from employees where id = ?";
       try (
               Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
               ) {
           statement.setInt(1,id);

           ResultSet resultSet =  statement.executeQuery();

           if(resultSet.next()){
               employee = new Employee(
                       resultSet.getInt("id"),
                       resultSet.getString("first_name"),
                       resultSet.getString("last_name"),
                       resultSet.getString("email")

               );
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       return employee;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        String sql = "select id , first_name , last_name , email  from employees ";
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {


            ResultSet resultSet =  statement.executeQuery();

            while (resultSet.next()){
               Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")

                );

               employees.add(employee);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return employees;
    }



    public void deleteEmployee(int id){

        String sql = "delete from employees where id = ? ";

                try(
                    Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql)
                        ){

                    statement.setInt(1,id);
                    int affectedRows = statement.executeUpdate();

                    String res =  (affectedRows > 0) ?
                            "Employee deleted successfully." :
                            "Employee not found.";

                    System.out.println(res);

                }catch (Exception e) {
                    e.printStackTrace();
                }
    }




}
