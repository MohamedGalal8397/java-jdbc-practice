package com.Mohamed;
import java.time.LocalDate;
import java.util.Scanner;

import com.Mohamed.Model.Employee;
import com.Mohamed.dao.EmployeeDao;
import com.Mohamed.dao.EmployeeDaoImplementation;

public class App {

    public static void main(String[] args) {

        optionRequired(displayOptions());




    }







    public static int displayOptions(){
        Scanner input = new Scanner(System.in) ;

        System.out.println("=======================================");
        System.out.println("   Welcome to Employee Database System ");
        System.out.println("=======================================");
        System.out.println("Please, choose an operation:");
        System.out.println("1 - Add a new Employee");
        System.out.println("2 - Delete an Employee");
        System.out.println("3 - Update an Employee");
        System.out.println("4 - Show all Employees' details");
        System.out.println("5 - Show Employee details by ID");
        System.out.println("=======================================");
        System.out.print("Please,Enter the operation : ");

        int operationnumber = input.nextInt();
        return  operationnumber ;
    }
    public static void optionRequired(int number){

        if (number == 1 ){ addEmployee(); }
        else if (number == 2) {deleteEmployee();}
        else if (number == 3){updateEmployee();}
        else if (number == 4){diplayEmployeesDetail();}
        else if (number == 5){diplayEmployeeDetailByid();}
        else {System.out.println("Please ,Enter integer number between 1 to 6 .");}

    }


    public static void diplayEmployeesDetail()
    {
        EmployeeDao employee = new EmployeeDaoImplementation();
        employee.findAll().forEach(System.out::println);
    }

    public static void diplayEmployeeDetailByid()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please ,Enter Employee Id : ");
        int id = input.nextInt();
;        EmployeeDao employee = new EmployeeDaoImplementation();
        System.out.println(employee.findByid(id));
    }

    public static void addEmployee(){

        Scanner input = new Scanner(System.in) ;
        EmployeeDaoImplementation Employee = new EmployeeDaoImplementation();
        System.out.print("Please,Enter name : ");
        String name = input.nextLine();
        System.out.print("Please,Enter Salary : ");
        double salary = input.nextDouble();
        System.out.print("Please,Enter Date_Employment :\n year = ");
        int year =  input.nextInt();
        System.out.print("month = ");
        int month =  input.nextInt();
        System.out.print("day = ");
        int day =  input.nextInt();

        Employee emp = new Employee(name , 0 , salary , LocalDate.of(year,month,day));
        Employee.saveEmployee(emp);

    }

    public static void deleteEmployee(){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Employee Id : ");
        int id = input.nextInt();

        EmployeeDaoImplementation employee = new EmployeeDaoImplementation();
        employee.deleteEmployee(id);

    }

    public static void updateEmployee(){

        Scanner input = new Scanner(System.in) ;
        EmployeeDaoImplementation Employee = new EmployeeDaoImplementation();
        System.out.println("============================================");
         Employee.findAll().forEach(System.out::println);
        System.out.println("============================================");

        System.out.print("Please,Enter Id : ");
        int id = input.nextInt();
        EmployeeDaoImplementation employee = new EmployeeDaoImplementation();
        Employee emp = new Employee();
        emp=employee.findByid(id);

        System.out.println("============================================");
        System.out.println(emp);
        System.out.println("============================================");

        System.out.println("Which field would you like to update?");
        System.out.println("1 - Name");
        System.out.println("2 - Salary");
        System.out.println("3 - Date of Employment");
        System.out.print("Enter your choice: ");
        int FieldNumber = input.nextInt();
        input.nextLine();


        if (FieldNumber == 1 ){
            System.out.print("Please,Enter new name : ");

            String name = input.nextLine();

            emp.setEmployeeName(name);
            employee.saveEmployee(emp);
        }

        else if (FieldNumber == 2) {
            System.out.print("Please,Enter new Salary : ");
            double salary = input.nextDouble();
            emp.setSalary(salary);
            employee.saveEmployee(emp);
        }

        else if (FieldNumber == 3){
            System.out.print("Please,Enter Date_Employment :\n year = ");
            int year =  input.nextInt();
            System.out.print("month = ");
            int month =  input.nextInt();
            System.out.print("day = ");
            int day =  input.nextInt();
        emp.setDate_Employment(LocalDate.of(year , month , day));
            employee.saveEmployee(emp);
        }

        else {System.out.println("Please ,Enter integer number between 1 to 4 .");}

        System.out.println("============================================");
        System.out.println(emp);
        System.out.println("============================================");



    }



}






