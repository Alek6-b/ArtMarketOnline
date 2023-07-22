package model;

import java.sql.*;

public class UserHandler extends ArtMarketResourceHandler {

	public UserHandler() throws SQLException {
		super();
	}

	public boolean checkUser(String user) throws SQLException {
		try (PreparedStatement query = con.prepareCall("SELECT * FROM Utente WHERE Utente.Nome = ?");) {

			query.setString(1, user);
			query.execute();
			ResultSet rs = query.getResultSet();
			return rs.next();
		}
	}

	public Boolean verifyUser(String user, String password) throws SQLException {
		try (PreparedStatement query = con.prepareCall("SELECT Password FROM Utente WHERE Utente.Nome = ?")) {
			query.setString(1, user);
			query.execute();
			ResultSet rs = query.getResultSet();
			return (rs.next() && rs.getString(1).equals(password));

		}
	}

	public Boolean isAdmin(String user) throws SQLException {
		try (PreparedStatement query = con.prepareCall("SELECT Admin FROM Utente WHERE Utente.Nome = ?")) {
			query.setString(1, user);
			query.execute();
			ResultSet rs = query.getResultSet();
			return (rs.next() && rs.getBoolean(1));
		}

	}

	public void registerUser(String user, String password) throws SQLException {
		try (PreparedStatement query = con.prepareCall("INSERT INTO Utente(Nome,Password) VALUES (?,?)")) {
			query.setString(1, user);
			query.setString(2, password);
			query.execute();
		}
	}

}
