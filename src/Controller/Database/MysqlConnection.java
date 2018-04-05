package Controller.Database;

import Model.Exception.MysqlCloseError;
import Model.Exception.MysqlConnectionError;

import java.sql.*;

class MysqlConnection {
    private final String jdbc_url;
    private final String database_host = "170.178.163.38";
    private final String database_port = "3306";
    private final String username = "jdbcfuwu";
    private final String password = "qbQG07myQL";
    private final String database_name = "jdbcfuwu";
    private Connection conn;

    MysqlConnection() {
        jdbc_url = "jdbc:mysql://" + database_host + ":" + database_port + "/";
    }

    private void Mysqlconnect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(jdbc_url, username, password);
    }

    void Mysqlclose() throws MysqlCloseError{
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException error) {
            throw new MysqlCloseError();
        }
    }

    ResultSet Mysqlquery(String sql) throws MysqlConnectionError, SQLException{
        try {
            Mysqlconnect();
        } catch (Exception error) {
            throw new MysqlConnectionError();
        }
        Statement stmt = conn.createStatement();
        stmt.executeQuery("USE " + database_name + ";");
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    void Mysqlupdate(String sql) throws MysqlConnectionError, SQLException{
        try {
            Mysqlconnect();
        } catch (Exception error) {
            throw new MysqlConnectionError();
        }
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("USE " + database_name + ";");
        stmt.executeUpdate(sql);
    }

}
