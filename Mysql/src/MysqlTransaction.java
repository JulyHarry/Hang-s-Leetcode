import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 实现MySQL数据库事务处理
 */
public class MysqlTransaction {

    /**
     * 没有开启事务处理
     *
     * @throws SQLException
     */
    public void NoTransaction() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = null;
        PreparedStatement ps = null;
        try {
            sql = "update easy set salary = 310 where id = 1";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            int i = 1 / 0;
            sql = "update easy set salary = 320 where id = 2";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, ps);
        }
    }


    /**
     * 开启事务处理
     */
    public void withTransaction() {
        Connection connection = JDBCUtils.getConnection();
        String sql;
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false); //关闭自动提交
            sql = "update easy set salary = 1 where id = 1";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            int i = 1 / 0;
            sql = "update easy set salary = 2 where id = 2";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, ps);
        }
    }
}
