package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DataSourceHandler {
    PoolProperties p = new PoolProperties();
    Connection con = null;
    PreparedStatement query;

	public DataSourceHandler(String url,String username,String password) throws SQLException{
	    p.setUrl(url);
	    p.setDriverClassName("com.mysql.jdbc.Driver");
	    p.setUsername(username);
	    p.setPassword(password);
	    DataSource s = new DataSource(p);
	    con = s.getConnection();
	}
	public Connection getConnection() {
		return con;
	}
}
