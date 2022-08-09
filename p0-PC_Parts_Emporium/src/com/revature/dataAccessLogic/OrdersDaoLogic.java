package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.LineItems;
import com.revature.models.Order;
import com.revature.models.StoreFront;
import com.revature.util.ConnectionFactory;

public class OrdersDaoLogic implements Dao<Order> {

	@Override
	public Order get(int id) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from orders where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Order(rs.getInt("id"), rs.getInt("lineItem_id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getDouble("totalPrice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Order> getAll() {
		List<Order> orderList = new ArrayList<Order>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from orders";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("id"), rs.getInt("lineItem_id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getDouble("totalPrice")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return orderList;
	}

	@Override
	public void save(Order t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "Insert into products (id, lineItem_id, store_id, customer_id, totalPrice) values (DEFAULT, ?, ?, ?, ?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getLineItem_id());
			pstmt.setInt(2, t.getStore_id());
			pstmt.setInt(3, t.getCustomer_id());
			pstmt.setDouble(4, t.getTotalPrice());
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Order t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "update products set lineItem_id = ?, store_id = ?, customer_id = ?, totalPrice = ? where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getLineItem_id());
			pstmt.setInt(2, t.getStore_id());
			pstmt.setInt(3, t.getCustomer_id());
			pstmt.setDouble(4, t.getTotalPrice());
			pstmt.setInt(5, t.getId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Order t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "DELETE FROM orders WHERE id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getId());
			pstmt.execute();
			System.out.println("Order id: " + t.getId() + ", successfully deleted from the database.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
