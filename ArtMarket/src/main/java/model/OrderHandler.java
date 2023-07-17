package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


public class OrderHandler {
    PoolProperties p = new PoolProperties();
    Connection con = null;
    PreparedStatement query;

	public OrderHandler() throws SQLException{
	    p.setUrl("jdbc:mysql://localhost:3306/artmarketonline");
	    p.setDriverClassName("com.mysql.jdbc.Driver");
	    p.setUsername("ArtMarketOnlineManager");
	    p.setPassword("Prodotti");
	    DataSource s = new DataSource(p);
	    con = s.getConnection();
	}
	public ArrayList<Order> getUserOrders(String user) throws SQLException {
    	query = con.prepareCall("SELECT * FROM Ordine WHERE Ordine.Utente = ? ORDER BY Ordine.DataOrdine");
    	query.setString(1, user);
    	query.execute();
    	ResultSet rs = query.getResultSet();
    	ArrayList<Order> output = new ArrayList<Order>();
    	while(rs.next()){
    		output.add(new Order(rs.getInt(1), user, rs.getDate(3) ,rs.getBigDecimal(4)));
    	}
		return output;
	}
	public void makeOrder(Cart c) {
		
	}
}
