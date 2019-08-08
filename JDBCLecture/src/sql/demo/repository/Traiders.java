package sql.demo.repository;

import java.sql.SQLException;

public class Traiders extends BaseTable implements TableOperations {
    public Traiders() throws SQLException {
        super("traiders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traiders(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "freqTick INTEGER NOT NULL," +
                "cash DECIMAL(10,2) NOT NULL DEFAULT 1000," +
                "traidingMethod INTEGER NOT NULL," +
                "changeProbability INTEGER NOT NULL DEFAULT 50," +
                "about VARCHAR(255) NULL)", "Table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }

}
