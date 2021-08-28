import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * Blob数据类型的存取
 */
public class MysqlBlob {
    /**
     * 存放图片
     */
    @Test
    public void save() {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "insert into hard (id, photo) value (1, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBlob(1, new FileInputStream("src/trash/image.jpeg"));
            ps.executeUpdate();
            JDBCUtils.close(conn, ps);
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 读取图片
     */
    @Test
    public void read() {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "select photo from hard where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // 方式1
                Blob photo = rs.getBlob("photo");
                InputStream binaryStream1 = photo.getBinaryStream();

                // 方式2
                InputStream binaryStream2 = rs.getBinaryStream("photo");

                // 存放文件
                FileOutputStream fileOutputStream = new FileOutputStream("src/trash/image1.jpg");

                int len;
                byte[] b = new byte[1024];
                while ((len = binaryStream1.read(b)) != -1) {
                    fileOutputStream.write(b, 0, len);
                }

                fileOutputStream = new FileOutputStream("src/trash/image2.jpg");
                b = new byte[1024];
                while ((len = binaryStream2.read(b)) != -1) {
                    fileOutputStream.write(b, 0, len);
                }

                fileOutputStream.close();
                binaryStream1.close();
                binaryStream2.close();
            }
            JDBCUtils.close(conn, ps, rs);
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
