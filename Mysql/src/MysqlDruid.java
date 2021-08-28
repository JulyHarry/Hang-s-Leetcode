import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;


/**
 * Druid连接池使用
 */
public class MysqlDruid {
    @Test
    public void connect () {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = ds.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
