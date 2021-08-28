import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlBatch {
    @Test
    public void noBatch() {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "insert into easy (id, salary) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 1; i < 5000; i++) {
                ps.setInt(1, i);
                ps.setInt(2, i);
                ps.executeUpdate();
            }
            JDBCUtils.close(conn, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void withBatch() {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "insert into easy (id, salary) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 5001; i < 10000; i++) {
                ps.setInt(1, i);
                ps.setInt(2, i);
                ps.addBatch();
                if (i % 1000 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            JDBCUtils.close(conn, ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
