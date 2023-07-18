package model;

import java.sql.PreparedStatement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderHandler {
    Connection con = null;
    PreparedStatement query;

	public OrderHandler() throws SQLException{
		con = new DataSourceHandler("jdbc:mysql://localhost:3306/artmarketonline", "ArtMarketOnlineManager", "Prodotti").getConnection();
	}
	public ArrayList<Order> getUserOrders(String user) throws SQLException {
    	query = con.prepareCall("SELECT * FROM Ordine WHERE Ordine.Utente = ? ORDER BY Ordine.DataOrdine");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	ArrayList<Order> output = new ArrayList<Order>();
    	while(rs.next()){
    		output.add(new Order(rs.getInt(1), user, rs.getDate(3), rs.getBigDecimal(4)));
    	}
		return output;
	}
	
	
	public void makeOrder(String user, ArrayList<CartItem> cart, BigDecimal deliveryFee) throws SQLException {
    	PreparedStatement orderQuery = con.prepareCall("INSERT INTO Order(Utente,Prezzo) VALUES (?,?)");
    	orderQuery.setString(1, user);
    	
    	//calcola prezzo
    	BigDecimal sum = deliveryFee;
    	for(CartItem i : cart) {
    		sum.add(i.getProduct().getPrice());
    	}
    	
    	orderQuery.setBigDecimal(2, sum);
    	orderQuery.execute();
    	ResultSet rs = orderQuery.getGeneratedKeys();
    	rs.next();
    	int id = rs.getInt(1);
    	orderQuery.close();
    	
    	PreparedStatement includeQuery = con.prepareCall("INSERT INTO Include(Ordine,Prodotto) VALUES (?,?)");
    	includeQuery.setInt(1, id);
    	
		for(CartItem i : cart) {
			Product p = i.getProduct();
			includeQuery.setInt(2, p.getId());
			includeQuery.execute();
		}
	}
	public void makeOrder(String user, ArrayList<CartItem> cart) throws SQLException {
		makeOrder(user,cart, new BigDecimal(0));
	}

}
