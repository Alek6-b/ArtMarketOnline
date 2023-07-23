package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductHandler extends ArtMarketResourceHandler{
    public ProductHandler() throws SQLException {
		super();
	}
	
	public List<Product> getPieceProducts(int opera) throws SQLException {
		try(PreparedStatement query = con.prepareStatement("SELECT * FROM Prodotto WHERE Opera = ?")){
	    	query.setInt(1, opera);
	    	query.execute();
	    	ResultSet rs = query.getResultSet();
	    	ArrayList<Product> output = new ArrayList<Product>();
	    	PieceHandler p= new PieceHandler();
	    	while(rs.next()){
	    		output.add(new Product(rs.getInt("Codice"),p.getPiece(opera),rs.getString("Formato"),rs.getBigDecimal("Prezzo")));
	    	}
			return output;
		}

	}
	public Product getProduct(int id) throws SQLException {
		try(		PreparedStatement query = con.prepareStatement("SELECT * FROM Prodotto WHERE Prodotto.Codice = ?")){
	    	query.setInt(1, id);
	    	query.execute();
	    	ResultSet rs = query.getResultSet();
	    	PieceHandler p = new PieceHandler();
	    	if(rs.next()){
	    		return new Product(id,p.getPiece(rs.getInt("Opera")),rs.getString("Formato"),rs.getBigDecimal("Prezzo"));
	    		}
			return null;	
		}

	}

	public void makeProduct(Product p) throws SQLException {
		try(PreparedStatement query = con.prepareStatement("INSERT INTO Prodotto(Opera, Formato,Prezzo) VALUES (?,?,?)")){
			query.setInt(1, p.getPiece().getId());
			query.setString(2, p.getFormat());
			query.setBigDecimal(3, p.getPrice());
			query.execute();
		}
	}

	
}
