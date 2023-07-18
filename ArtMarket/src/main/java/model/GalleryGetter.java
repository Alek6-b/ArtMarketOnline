package model;

import java.sql.Connection;
import java.sql.SQLException;

public class GalleryGetter {
	Connection con = new DataSourceHandler("jdbc:mysql://localhost:3306/artmarketonline", "ArtMarketOnlineManager", "Prodotti").getConnection();

	public GalleryGetter() throws SQLException{
		
	}
}
