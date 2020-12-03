import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql5 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
    }
}
