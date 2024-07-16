package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entity.Category;
import Util.DatabaseUtil;
import static Util.QueryUtil.*;

public class CategoryRepository {


    public static List<Category> list() {
        List<Category> categoryList = new ArrayList<>();
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(SELECT_CATEGORY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt("id");
                String categoryName = rs.getString("name");
                Category category = new Category(categoryId, categoryName);
                categoryList.add(category);
            }
        } catch (Exception e) {
            System.out.println("Error fetching categories: " + e.getMessage());
        }
        return categoryList;
    }

    public static void insert(String name) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(INSERT_CATEGORY);
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (Exception e) {
            System.out.println("Error inserting category: " + e.getMessage());
        }
    }

    public static void update(int id, String newName) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(UPDATE_CATEGORY);
            ps.setString(1, newName);
            ps.setInt(2, id); // 2. parametre indeksi olarak id kullanılmalı
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (Exception e) {
            System.out.println("Error updating category with ID " + id + ": " + e.getMessage());
        }
    }

    public static void delete(Integer id) {
        try {
            Connection c = DatabaseUtil.connect();
            PreparedStatement ps = c.prepareStatement(DELETE_CATEGORY);
            ps.setInt(1, id); // 1. parametre indeksi olarak id kullanılmalı
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (Exception e) {
            System.out.println("Error deleting category with ID " + id + ": " + e.getMessage());
        }
    }
}
