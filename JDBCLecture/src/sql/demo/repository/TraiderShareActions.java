package sql.demo.repository;

import java.sql.SQLException;

public class TraiderShareActions extends BaseTable implements TableOperations {
    public TraiderShareActions() throws SQLException {
        super("traider_share_actions");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traider_share_actions(" +
                "operation INTEGER NOT NULL," +
                "traider BIGINT NOT NULL," +
                "shareRate BIGINT NOT NULL," +
                "amount BIGINT NOT NULL)", "Table created " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE traider_share_actions " +
                "ADD FOREIGN KEY (shareRate) REFERENCES shares(id)","Created internal key traider_share_actions.shareRate -> shares.id");
    }
}

