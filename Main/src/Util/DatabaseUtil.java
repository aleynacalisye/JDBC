package Util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final String DRIVER_NAME = "org.postgresql.Driver";
    private final static String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "LsaQ!c@gf";




    public static Connection connect () {
        Connection connection = null;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            System.out.println("Bağlantı başarılı");
        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
        return connection; // Bağlantıyı döndür
    }
}






