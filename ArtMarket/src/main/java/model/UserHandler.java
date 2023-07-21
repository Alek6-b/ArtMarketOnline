package model;
import java.sql.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class UserHandler extends ArtMarketResourceHandler {

    public UserHandler() throws SQLException {
		super();
	}
	
    public boolean checkUser(String user) throws SQLException {
    	PreparedStatement query = con.prepareCall("SELECT * FROM Utente WHERE Utente.Nome = ?");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	return rs.next();
    }
    public Boolean verifyUser(String user, String password) throws SQLException {
    	PreparedStatement query = con.prepareCall("SELECT Password FROM Utente WHERE Utente.Nome = ?");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	if (rs.next()&&rs.getString(1).equals(password))
    		return true;
    	return false;
    }
    public Boolean isAdmin(String user) throws SQLException {
    	PreparedStatement query = con.prepareCall("SELECT Admin FROM Utente WHERE Utente.Nome = ?");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	if (rs.next()&&rs.getBoolean(1))
    		return true;
    	return false;

    }
    public void registerUser(String user, String password) throws SQLException {
    	PreparedStatement query = con.prepareCall("INSERT INTO Utente(Nome,Password) VALUES (?,?)");
    	query.setString(1, user);
    	query.setString(2, password);
    	query.execute();
    }
    	
}
