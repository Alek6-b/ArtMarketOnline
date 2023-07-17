package model;
import java.sql.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class UserHandler {
    PoolProperties p = new PoolProperties();
    Connection con = null;
    PreparedStatement query;
    public UserHandler() throws SQLException{
        p.setUrl("jdbc:mysql://localhost:3306/artmarketonline");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("ArtMarketOnlineManager");
        p.setPassword("Prodotti");
        DataSource s = new DataSource(p);
        con = s.getConnection();
    }
    public boolean checkUser(String user) throws SQLException {
    	query = con.prepareCall("SELECT * FROM Utente WHERE Utente.Nome = ?");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	return rs.next();
    }
    public boolean verifyUser(String user, String password) throws SQLException {
    	query = con.prepareCall("SELECT Password FROM Utente WHERE Utente.Nome = ?");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	if (rs.next()&&rs.getString(1).equals(password))
    		return true;
    	return false;
    }
    public void registerUser(String user, String password) throws SQLException {
    	query = con.prepareCall("INSERT INTO Utente(Nome,Password) VALUES (?,?)");
    	query.setString(1, user);
    	query.setString(2, password);
    	query.execute();
    }
    	
}
