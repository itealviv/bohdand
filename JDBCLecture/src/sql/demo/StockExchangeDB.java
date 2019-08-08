package sql.demo;

import sql.demo.repository.ShareRates;
import sql.demo.repository.Shares;
import sql.demo.repository.TraiderShareActions;
import sql.demo.repository.Traiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {

    public static final String DB_URL = "jdbc:h2:C:\\Users\\bdmytrys\\IdeaProjects\\ITEA\\JDBCLecture\\db\\stockExchange";
    public static final String DB_Driver = "org.h2.Driver";

    private Traiders traiders;
    private ShareRates shareRates;
    private Shares shares;
    private TraiderShareActions traiderShareActions;


    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        traiders=new Traiders();
        shares = new Shares();
        shareRates = new ShareRates();
        traiderShareActions = new TraiderShareActions();
    }

    private void createTablesAndForeignKeys() throws SQLException{
        shares.createTable();
        shareRates.createTable();
        traiders.createTable();
        traiderShareActions.createTable();
        shareRates.createForeignKeys();
        traiderShareActions.createForeignKeys();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void main(String[] args) {
        try {
            StockExchangeDB stockExchangeDB = new StockExchangeDB();
            stockExchangeDB.createTablesAndForeignKeys();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL error");
        }
    }
}
