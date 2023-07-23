package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PieceHandler extends ArtMarketResourceHandler {
	public PieceHandler() throws SQLException {
		super();
	}
	
	public Piece getPiece(int id) throws SQLException {
		try(		PreparedStatement query = con.prepareStatement("SELECT * FROM Opera WHERE Opera.Codice = ?");
){
		
		
		query.setInt(1, id);
		query.execute();
		ResultSet rs = query.getResultSet();
		
		if (rs.next()) {
			return new Piece(id, rs.getString("Titolo"), rs.getString("Autore"), rs.getString("UrlImmagine"));
		}
		return null;
	}}
	
	public List<Piece> getUserPieces(String user) throws SQLException {
		try(PreparedStatement query = con.prepareStatement("SELECT * FROM Opera WHERE Autore = ?")){
	    	query.setString(1, user);
	    	query.execute();
	    	ResultSet rs = query.getResultSet();
	    	ArrayList<Piece> output = new ArrayList<>();
	    	PieceHandler p= new PieceHandler();
	    	while(rs.next()){
	    		output.add(getPiece(rs.getInt("Codice")));
	    	}
			return output;
		}
	}

	
	public void makePiece(Piece p) throws SQLException {
		try(PreparedStatement query = con.prepareStatement("INSERT INTO Opera(Titolo, Autore, UrlImmagine) VALUES (?,?,?)")){
			query.setString(1, p.getTitle());
			query.setString(2, p.getAuthor());
			query.setString(3, p.getImageSource());
			query.execute();
		}
	}
}

