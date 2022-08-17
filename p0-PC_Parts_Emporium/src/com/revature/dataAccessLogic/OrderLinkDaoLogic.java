package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.OrderLink;
import com.revature.util.ConnectionFactory;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class OrderLinkDaoLogic implements Dao<OrderLink> {
	
	private static Logger logger = new Logger();

	@Override
	public OrderLink get(int id) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from orderlink where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  orderlink");
			
			if(rs.next()) {
				return new OrderLink(rs.getInt("id"), rs.getDouble("subTotal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<OrderLink> getAll() {
		List<OrderLink> orderLinkList = new ArrayList<OrderLink>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from orderlink";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			logger.logDB(LogLevel.info, "GET  ->  orderlink");
			
			while(rs.next()) {
				orderLinkList.add(new OrderLink(rs.getInt("id"), rs.getDouble("subTotal")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return orderLinkList;
	}

	@Override
	public void save(OrderLink t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "Insert into orderlink (id, subTotal) values (DEFAULT, ?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setDouble(1, t.getSubTotal());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "CREATE  ->  orderlink");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(OrderLink t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "update orderlink set subTotal = ? where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setDouble(1, t.getSubTotal());
			pstmt.setInt(2, t.getId());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "UPDATE  ->  orderlink");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(OrderLink t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "DELETE FROM orderlink WHERE id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getId());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "DELETE  ->  orderlink");			
			System.out.println("Orderlink id: " + t.getId() + ", successfully deleted from the database.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
