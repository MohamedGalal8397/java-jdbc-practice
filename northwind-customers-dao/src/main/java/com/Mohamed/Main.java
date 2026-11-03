package com.Mohamed;

import com.Mohamed.model.Customer;
import dao.DataBaseConnection;
import dao.NorthWind2021DaoImplementation;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {


        UserDisplay.displayOptions();
        int number =  UserDisplay.getOptionNumber();
        UserDisplay.excuteOption(number);





    }
}