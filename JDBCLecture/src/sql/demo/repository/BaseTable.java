package sql.demo.repository;

import sql.demo.StockExchangeDB;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable implements Closeable {
    private Connection connection;
    String tableName;

    public BaseTable(String tableName) {
        this.tableName = tableName;
        //!!!!!!!!!!!!!!!!connections here
    }

    public void close(){
        try{
            if (connection!= null && !connection.isClosed()){
                connection.close();
            }

        }catch (SQLException e){
            System.out.println("Error closing SQL connection");
        }
    }
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        if (description!=null){
            System.out.println(description);
        }
    }
    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql,null);
    }
    void reopenConnection() throws SQLException {
        if (connection==null || connection.isClosed()){
            connection= StockExchangeDB.getConnection();
        }
    }
}
