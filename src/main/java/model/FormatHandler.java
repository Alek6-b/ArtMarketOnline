package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormatHandler extends ArtMarketResourceHandler {

	public FormatHandler() throws SQLException {
		super();
	}
	public List<Format> getFormats() throws SQLException{
		try(PreparedStatement query = con.prepareStatement("SELECT * FROM Formato")){
	    	query.execute();
	    	ResultSet rs = query.getResultSet();
	    	ArrayList<Format> output = new ArrayList<>();
	    	while(rs.next()){
	    		output.add(new Format(rs.getString("Nome"),rs.getString("Dimensioni"),rs.getString("Materiale")));
	    	}
			return output;
		}

	}
}
