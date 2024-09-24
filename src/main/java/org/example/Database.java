package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.SQLException;

@UtilityClass
public class Database {

    public static final String DB_URL = "jdbc:h2:~/mydb";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";

    private static final HikariConfig config = new HikariConfig();
    static final HikariDataSource ds;

    static {
        config.setJdbcUrl( DB_URL );
        config.setUsername( DB_USER );
        config.setPassword( DB_PASSWORD );
        ds = new HikariDataSource( config );
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
