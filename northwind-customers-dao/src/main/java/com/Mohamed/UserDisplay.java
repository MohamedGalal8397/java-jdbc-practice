package com.Mohamed;

import com.Mohamed.model.Customer;
import dao.NorthWind2021DaoImplementation;
import dao.Northwind2021dao;
import sun.util.resources.cldr.chr.CalendarData_chr_US;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDisplay {

    public static void displayOptions () throws InterruptedException {
        System.out.println("Welcome to NorthWind2021 Database");

        System.out.println("Please,Choose the operation :");

        System.out.println("________________________________________");
        System.out.println("1-find all customers");

        System.out.println("2-find customer by using Id");

        System.out.println("3-Add customer to dataBase");

        System.out.println("4-Remover customer from dataBase");
        System.out.println("________________________________________");



    };
    public static int getOptionNumber(){
        int operationNumber =0 ;
        try {
      Scanner input = new Scanner(System.in);
        System.out.print("Operation = ");

       operationNumber = input.nextInt();
        System.out.println("________________________________________");

        return operationNumber;
        }catch (Exception exception){
            System.out.println("Enter the correct number");
            exception.getStackTrace();

        }
        return operationNumber;
    }
    public static void excuteOption (int id ) throws SQLException {
        Scanner input = new Scanner(System.in);
        switch(id){

            case 1 :
                displayAllCustomers();
                break;
            case 2 :
                try {
                    System.out.print("Customer Id = ");
                    int customerId1 = input.nextInt();
                    displayCustomerByID(customerId1);
                }catch (Exception a) {
                    System.out.println("Enter the Correct Number");
                }
                break;
            case 3 :
                dsiplayAddCustomer();
                System.out.println("Customer is added");
                break;

            case 4:
            try {
                System.out.print("Customer Id = ");
                int customerId2 = input.nextInt();
                displayRemoveCustomerById( customerId2);
                }catch (Exception a) {
    System.out.println("Enter the correct Number");
                }
                break;
            default :
                System.out.println("Please enter the correct number");

        }

    }



    private static void displayAllCustomers() throws SQLException {

        ArrayList < Customer> customers = new ArrayList<>();
        Northwind2021dao northwind2021dao = new NorthWind2021DaoImplementation();
        customers .addAll( northwind2021dao.findAllCustomer());
        System.out.println(customers);
    }
    private static Customer getCustomerById(int id) throws SQLException {

        Customer customer= new Customer();
        Northwind2021dao northwind2021dao = new NorthWind2021DaoImplementation();
        customer= northwind2021dao.findById(id);
        return customer;

    }
    private static boolean checkCustomer(int id) throws SQLException {

        if (getCustomerById(id).getFirstName().equals(null) ){
            return false ;
        }else {
            return true;
        }

    }
    private static void displayCustomerByID(int id ) throws SQLException {

        if (checkCustomer(id)){
            System.out.println(getCustomerById(id));
        }else {
            System.out.println("Invalid Id");
        }

    }
    private static void displayRemoveCustomerById(int id) throws SQLException {

        if (checkCustomer(id)){
            NorthWind2021DaoImplementation northWind2021DaoImplementation = new NorthWind2021DaoImplementation();
            northWind2021DaoImplementation.removeCustomerById(id);
        }else {
            System.out.println("Invalid Id");
        }


    }
    private static  void dsiplayAddCustomer () throws SQLException {
       Scanner input = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.print("First Name = ");
        customer.setFirstName(input.next());
        System.out.print("Last Name = ");
        customer.setLastName(input.next());

        System.out.print("City = ");
        customer.setCity(input.next());

        System.out.print("Country = ");
        customer.setCountry(input.next());

        Northwind2021dao northwind2021dao = new NorthWind2021DaoImplementation();
        northwind2021dao.saveCustomer(customer);


    }



}
