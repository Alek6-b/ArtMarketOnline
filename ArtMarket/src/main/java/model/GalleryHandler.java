package model;

import java.sql.Connection;
import java.sql.SQLException;

public class GalleryHandler {
	Connection con = new DataSourceHandler("jdbc:mysql://localhost:3306/artmarketonline", "ArtMarketOnlineManager", "Prodotti").getConnection();

	public GalleryHandler() throws SQLException{
		super();
	}
}
