package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ArtMarketResourceHandler {
	Connection con;
	ArtMarketResourceHandler() throws SQLException{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artmarketonline", "ArtMarketOnlineManager", "Prodotti");
	}
}
