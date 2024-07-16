package Repository;
import Entity.Customer;
import Util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Util.QueryUtil.*;

public class CustomerRepository {

    public static List<Customer> list() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(SELECT_CUSTOMER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customerId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String city = rs.getString("city");
                String country = rs.getString("country");

                System.out.println("CustomerID: " + customerId + ", First Name: " + firstName +
                        ", Last Name: " + lastName + ", Email: " + email +
                        ", City: " + city + ", Country: " + country);
            }
            if (!rs.next()) {
                System.out.println("Customer list is empty.");
            }
        } catch (Exception e) {
            System.out.println("Error listing customers: " + e.getMessage());
        }
        return customerList;
    }


//    public static void list() {
//        try {
//            Connection c = DatabaseUtil.connect();
//            PreparedStatement ps = c.prepareStatement(SELECT_CUSTOMER);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                String email = rs.getString("email");
//                String city = rs.getString("city");
//                String country = rs.getString("country");
//
//                System.out.println("CustomerID: " + id + ", First Name: " + firstName +
//                        ", Last Name: " + lastName + ", Email: " + email +
//                        ", City: " + city + ", Country: " + country);
//            }
//            if (!rs.next()) {
//                System.out.println("Customer list is empty.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error listing customers: " + e.getMessage());
//        }
//    }


    public static void insert(String first_name, String last_name, String email, String city, String country) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(INSERT_CUSTOMER);
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setString(4, city);
            ps.setString(5, country);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Error inserting customer: " + e.getMessage());
        }
    }

    public static void update(int id, String first_name, String last_name, String email, String city, String country) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setString(4, city);
            ps.setString(5, country);
            ps.setInt(6, id);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (Exception e) {
            System.out.println("Error updating customer with ID " + id + ": " + e.getMessage());
        }
    }

    public static void delete(Integer id) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (Exception e) {
            System.out.println("Error deleting customer with ID " + id + ": " + e.getMessage());
        }
    }
}
