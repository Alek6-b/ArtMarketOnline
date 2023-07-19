package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PieceHandler extends ArtMarketResourceHandler {
	public PieceHandler() throws SQLException {
		super();
	}
	
	public Piece getPiece(int id) throws SQLException {
		PreparedStatement query = con.prepareStatement("SELECT * FROM Opera WHERE Opera.Codice = ?");
		query.setInt(1, id);
		ResultSet rs = query.getResultSet();
		
		if (rs.next()) {
			return new Piece(id, rs.getString("Titolo"), rs.getString("Autore"), rs.getString("UrlImmagine"));
		}
		return null;
	}
	
	public void makePiece(Piece p) throws SQLException {
		PreparedStatement query = con.prepareStatement("INSERT INTO Opera(Titolo, Autore, UrlImmagine) VALUES (?,?,?)");
		query.setString(1, p.getTitle());
		query.setString(2, p.getAuthor());
		query.setString(3, p.getImageSource());
		query.execute();
	}
}
