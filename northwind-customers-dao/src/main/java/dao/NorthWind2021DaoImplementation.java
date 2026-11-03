package dao;
import dao.DataBaseConnection;
import com.Mohamed.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NorthWind2021DaoImplementation implements Northwind2021dao {

    @Override
    public List<Customer> findAllCustomer() throws SQLException {

        List <Customer> customerList = new ArrayList<>();
        Connection connection = DataBaseConnection.getConnection();
        if (connection == null){
            System.out.println("Connection is failed");
            return null;
        }else {

            String query = "select * from customer ";

            try (PreparedStatement preparedStatement =connection.prepareStatement(query)){
              ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()){
                  Customer customer = new Customer(
                          resultSet.getNString("FirstName") ,
                          resultSet.getNString("LastName"),
                          resultSet.getNString("Phone"),
                          resultSet.getInt("Id"),
                          resultSet.getNString("City"),
                          resultSet.getNString("Country")
                  );
                  customerList.add(customer) ;
              }
            }catch (Exception exception){
                exception.printStackTrace();
            }finally {
              try {
                  connection.close();
              }catch (Exception exception){
                  exception.printStackTrace();
              }
            }

return customerList ;
        }



    }

    @Override
    public Customer findById(int id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();

        if (connection == null){

            System.out.println("Connetion is Failed");
            return null ;
        }
        else {
            Customer customer = new Customer();
            String query = "select * " +
                    "from dbo.customer " +
                    "where Id = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()){
                    customer.setFirstName(resultSet.getNString("FirstName"));
                    customer.setLastName(resultSet.getNString("LastName"));
                    customer.setId(resultSet.getInt("Id"));
                    customer.setCity(resultSet.getNString("City"));
                    customer.setCountry(resultSet.getNString("Country"));
                                }
                return  customer ;


            }catch(Exception exception){
                exception.printStackTrace();
            }finally {
                connection.close();
            }

        return customer ;
        }
    }

    @Override
    public void saveCustomer(Customer customer) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        if (connection== null){
            System.out.println("Connection is failed");
           return ;
        }else {

            String query = "insert into dbo.customer (FirstName , LastName ,City , Country , Phone )" +
                    "values (?,?,?,?,?) ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ;

                preparedStatement.setString(1, customer.getFirstName());
                preparedStatement.setString(2, customer.getLastName());
                preparedStatement.setString(3, customer.getCity());
                preparedStatement.setString(4, customer.getCountry());
                preparedStatement.setString(5, customer.getPhone());
                preparedStatement.executeUpdate();


            }catch(Exception exception){
                exception.printStackTrace();
            }finally {
              try {
                  connection.close();
              } catch (Exception exception) {
                  exception.printStackTrace();
              }
            }









        }





    }

    @Override
    public void removeCustomerById(int id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        if (connection == null){
            System.out.println("Connection is failed");
        }else {

            String query = "delete from customer where id = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
              preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
                System.out.println("Customer is deleted");
            }catch (Exception exception){
                exception.printStackTrace();
            }finally {
                connection.close();
            }
        }




    }
}