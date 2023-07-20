package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductHandler extends ArtMarketResourceHandler{
    public ProductHandler() throws SQLException {
		super();
	}
	
	public ArrayList<Product> getPieceProducts(int opera) throws SQLException {
		PreparedStatement query = con.prepareStatement("SELECT * FROM Prodotto WHERE Prodotto.Opera = ?");
    	query.setInt(1, opera);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	ArrayList<Product> output = new ArrayList<Product>();
    	while(rs.next()){
    		output.add(new Product(opera, rs.getString("Formato"), rs.getBigDecimal("Prezzo")));
    	}
		return output;
	}
	public Product getProduct(int id) throws SQLException {
		PreparedStatement query = con.prepareStatement("SELECT * FROM Prodotto WHERE Prodotto.Codice = ?");
    	query.setInt(1, id);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	if(rs.next()){
    		return new Product(id, rs.getString("Formato"), rs.getBigDecimal("Prezzo"));
    	}
		return null;
	}

	
	
}
