import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Mysql8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        Properties info = new Properties();
        info.load(new FileInputStream("Mysql/src/jdbc.properties"));  //ModulesName/src/file
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String url = info.getProperty("url");
        String driver = info.getProperty("driver");

        //1. 加载驱动
        Class.forName(driver);

        //2. 连接数据库
        connection = DriverManager.getConnection(url, user, password);

        //3 编写SQL
        sql = "select employee_id, last_name, email from employees where salary = ? and last_name = ?";

        //4. 获取执行SQL语句命令对象
        ps = connection.prepareStatement(sql);
        ps.setInt(1, 3200);
        ps.setString(2, "taylor");

        //5. 使用命令对象执行sql语句
        rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString("last_name");
            Object gender = rs.getObject(3);
            System.out.println(id + name + gender);
        }

        //6.关闭连接 (后用先关)
        rs.close();
        ps.close();
        connection.close();
    }
}
