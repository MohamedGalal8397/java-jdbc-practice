package com.mohamed;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO =
                new EmployeeDAO();

        // =========================
        // CREATE
         // =========================
//        Employee employee =
//                new Employee(
//                        11,
//                        "Mouse",
//                        "Mohamed",
//                        "employee1@example.com"
//
//                );
//
//        employeeDAO.addEmployee(employee);

          // =========================
          // UPDATE
          // =========================
//        Employee updatedEmployee =
//                new Employee(
//                        11,
//                        "Mousa",
//                        "Mohamed",
//                        "employee2@example.com"
//
//                );
//
//        employeeDAO.updateEmployee(
//                updatedEmployee
//        );


        // =========================
        // READ BY ID
        // =========================

//      Employee employee =  employeeDAO.getEmployee(
//                11
//        );
//        System.out.println(employee);


        // =========================
        // READ ALL
        // =========================

//        System.out.println("\nAll Employees: \n");
//
//        List<Employee> employees =
//                employeeDAO.getAllEmployees();
//
//        for (Employee emp : employees) {
//
//            System.out.println(emp);
//            System.out.println("__________________" + "\n");
//        }

        // =========================
        // DELETE
        // =========================

        employeeDAO.deleteEmployee(10);


    }
}