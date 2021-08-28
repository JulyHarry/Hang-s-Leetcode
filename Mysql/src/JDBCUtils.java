import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 数据库封装类
 * 实现：
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

    /**
     * 连接Mysql数据库
     *
     * @return Connection类
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param connection Connection
     * @param statement  Statement or PreparedStatement
     * @param resultSet  ResultSet
     */
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

    public static void close(Connection connection, Statement statement) {
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

    /**
     * 增删改
     * @param sql
     * @return
     */
    public static int update(String sql, Object ... params) {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(++i, params[i]);
            }
            int update = preparedStatement.executeUpdate();
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param sql
     * @param params
     * @return
     */
    public static Object querySingle (String sql, Object... params) {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(++i, params[0]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            JDBCUtils.close();
        }
        return null;
    }

    /**
     * @param sql
     * @param params
     * @return
     */
    public static List<Object> queryMulti (String sql, Object... params) {
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(++i, params[0]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Object> list = new ArrayList<Object>();
            while (resultSet.next()) {
                list.add(null);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            JDBCUtils.close();
        }
    }
}
