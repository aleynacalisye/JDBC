package Repository;
import Util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static Util.QueryUtil.*;
public class ProductRepository {

    public static void list(Integer id) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(SELECT_PRODUCT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt("id");
                String productName = rs.getString("name");
                System.out.println("Product ID: " + productId + ", Name: " + productName);
            } else {
                System.out.println("No product found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error listing product with ID " + id + ": " + e.getMessage());
        }
    }

    public static void insert(String name) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(INSERT_PRODUCT);
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (Exception e) {
            System.out.println("Error inserting product: " + e.getMessage());
        }
    }

    public static void update(int id, String newName) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, newName);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (Exception e) {
            System.out.println("Error updating product with ID " + id + ": " + e.getMessage());
        }
    }
    public static void delete(Integer id) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (Exception e) {
            System.out.println("Error deleting product with ID " + id + ": " + e.getMessage());
        }
    }
}


