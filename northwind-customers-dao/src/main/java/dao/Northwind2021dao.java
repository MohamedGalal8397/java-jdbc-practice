package dao;
import java.sql.SQLException;
import java.util.* ;
import com.Mohamed.model.Customer;

public interface Northwind2021dao {

public  List<Customer> findAllCustomer() throws SQLException;
public  Customer findById(int id) throws SQLException;

    public  void saveCustomer(Customer customer) throws SQLException ;

    public   void removeCustomerById(int id) throws SQLException;








}
