package Util;

public class QueryUtil {

    public static final String SELECT_CATEGORY = "SELECT id, name FROM CATEGORY";
    public static final String INSERT_CATEGORY = "INSERT INTO CATEGORY (name) VALUES (?)";
    public static final String UPDATE_CATEGORY = "UPDATE CATEGORY SET name = ? WHERE id = ?";
    public static final String DELETE_CATEGORY = "DELETE FROM CATEGORY WHERE id = ?";

    public static final String SELECT_CUSTOMER = "SELECT id, first_name, last_name, email, city, country FROM customers WHERE id = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER (first_name, last_name, email, city, country) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER SET first_name = ?, last_name = ?, email = ?, city = ?, country = ? WHERE id = ?";
    public static final String DELETE_CUSTOMER = "DELETE FROM CUSTOMER WHERE id = ?";


    public static final String SELECT_PRODUCT = "SELECT id, name FROM PRODUCT";
    public static final String INSERT_PRODUCT = "INSERT INTO PRODUCT (name) VALUES (?)";
    public static final String UPDATE_PRODUCT = "UPDATE PRODUCT SET name = ? WHERE id = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE id = ?";
}





