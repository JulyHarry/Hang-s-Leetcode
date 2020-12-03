import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库封装类
 * 1. 连接
 * 2. 关闭
 */
public class JDBCUtils {
    private static Properties info = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driver = null;

    static {
        try {
            info = new Properties();
            info.load(new FileInputStream("src/jdbc.properties"));
            url = info.getProperty("url");
            user = info.getProperty("user");
            password = info.getProperty("password");
            driver = info.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection () {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
                System.out.println("ResultSet关闭");
            }
            if (statement != null) {
                statement.close();
                System.out.println("Statement关闭");
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connection关闭");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
                System.out.println("Statement关闭");
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connection关闭");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection关闭");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
                System.out.println("Statement关闭");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
                System.out.println("ResultSet关闭");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
