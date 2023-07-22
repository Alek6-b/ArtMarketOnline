package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public class GalleryHandler extends ArtMarketResourceHandler{
		public GalleryHandler() throws SQLException {
		super();
	}

	public List<Piece> getGallery(String tag) throws SQLException {
		try (PreparedStatement query = con.prepareCall(
				"SELECT * FROM Tag WHERE Tag.Categoria = ?")) {
			query.setString(1, tag);
			query.execute();
			PieceHandler p= new PieceHandler();
			ResultSet rs = query.getResultSet();
			ArrayList<Piece> out = new ArrayList<>();
			while (rs.next())
				out.add(p.getPiece(rs.getInt("Opera")));
			return out;
		}
	}
}
