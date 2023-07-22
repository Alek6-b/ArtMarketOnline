package model;

import java.sql.PreparedStatement;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHandler extends ArtMarketResourceHandler{
	public OrderHandler() throws SQLException{
		super();
	}
	public List<Order> getUserOrders(String user) throws SQLException {
    	PreparedStatement query = con.prepareStatement("SELECT * FROM Ordine WHERE Ordine.Utente = ? ORDER BY Ordine.DataOrdine");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	ArrayList<Order> output = new ArrayList<Order>();
    	while(rs.next()){
    		output.add(new Order(rs.getInt(1), user, rs.getDate(3), rs.getBigDecimal(4),rs.getString(5)));
    	}
		return output;
	}
	
	
	public void makeOrder(String user, List<CartItem> cart, BigDecimal deliveryFee) throws SQLException {
		try(    	PreparedStatement orderQuery = con.prepareStatement("INSERT INTO Ordine(Utente,Prezzo,Descrizione) VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		    	PreparedStatement includeQuery = con.prepareStatement("INSERT INTO Include(Ordine,Prodotto) VALUES (?,?)");){

    	orderQuery.setString(1, user);
    	
    	//calcola prezzo
    	BigDecimal sum = deliveryFee;
    	String desc = "";
    	for(CartItem i : cart) {
    		BigDecimal a = i.getProduct().getPrice();
    		int b = i.getQuantity();
    		sum = sum.add(a.multiply(BigDecimal.valueOf(b)));
    		desc+=i.toString();
    	}
    	orderQuery.setBigDecimal(2, sum);
    	orderQuery.setString(3, desc);
    	orderQuery.execute();
    	ResultSet rs = orderQuery.getGeneratedKeys();
    	rs.next();
    	int id = rs.getInt(1);
    	
    	includeQuery.setInt(1, id);
    	
		for(CartItem i : cart) {
			Product p = i.getProduct();
			includeQuery.setInt(2, p.getId());
			includeQuery.execute();
		}
		
	}
	}
	public void makeOrder(String user, List<CartItem> cart) throws SQLException {
		makeOrder(user,cart, new BigDecimal(0));
	}

}
