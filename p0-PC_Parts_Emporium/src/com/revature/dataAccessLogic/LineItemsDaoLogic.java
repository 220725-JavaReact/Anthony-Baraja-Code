package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.revature.models.LineItems;
import com.revature.util.ConnectionFactory;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class LineItemsDaoLogic implements Dao<LineItems>, LineItemInterface {
	
	private static Logger logger = new Logger();

	// CRUD Methods
	@Override
	public LineItems get(int id) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from lineItems where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  lineItems");
			
			if(rs.next()) {
				return new LineItems(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("quantity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public LineItems getByProdId(int product_id) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from lineItems where product_id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, product_id);
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  lineItems");
			
			if(rs.next()) {
				return new LineItems(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("quantity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LineItems> getAll() {
		return null;
	}

	@Override
	public void save(LineItems t) {

	}

	@Override
	public void update(LineItems t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "update lineitems set quantity = ? where product_id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getQuantity());
			pstmt.setInt(2, t.getProductId());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "UPDATE  ->  lineItems");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(LineItems t) {
	}

}
