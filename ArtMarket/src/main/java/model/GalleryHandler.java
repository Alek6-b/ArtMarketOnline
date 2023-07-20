package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class GalleryHandler {
	Connection con = new DataSourceHandler("jdbc:mysql://localhost:3306/artmarketonline", "ArtMarketOnlineManager", "Prodotti").getConnection();

	public GalleryHandler() throws SQLException{
		super();
	}
	
	public ArrayList<Piece> getGallery(String tag) throws SQLException{
		PreparedStatement query = con.prepareCall("SELECT * FROM (Opera INNER JOIN Tag ON Opera.Codice = Tag.Opera) WHERE Tag.Categoria = ?");
		query.setString(1, tag);
		query.execute();
		ResultSet rs = query.getResultSet();
		ArrayList<Piece> out = new ArrayList<Piece>();
		while(rs.next())
			out.add(new Piece(rs.getInt("Codice"),rs.getString("Titolo"),rs.getString("Autore"),rs.getString("UrlImmagine")));
		return out;	
	}
}
