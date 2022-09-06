package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Order;
import com.revature.util.ConnectionFactory;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class OrderDaoLogic implements Dao<Order> {
	
	private static Logger logger = new Logger();

	@Override
	public Order get(int id) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from orders where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  orders");
			
			if(rs.next()) {
				return new Order(rs.getInt("id"), rs.getInt("lineItem_id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getInt("order_link"), rs.getDouble("totalPrice"));
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
			
			logger.logDB(LogLevel.info, "GET  ->  orders");
			
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("id"), rs.getInt("lineItem_id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getInt("order_link"), rs.getDouble("totalPrice")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	public List<Order> getAllByOrderLinkAsc(){
		List<Order> orderList = new ArrayList<Order>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from orders order by order_link asc";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			logger.logDB(LogLevel.info, "GET  ->  orders");
			
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("id"), rs.getInt("lineItem_id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getInt("order_link"), rs.getDouble("totalPrice")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}

	@Override
	public void save(Order t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "Insert into orders (id, lineItem_id, store_id, customer_id, order_link, totalPrice) values (DEFAULT, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getLineItem_id());
			pstmt.setInt(2, t.getStore_id());
			pstmt.setInt(3, t.getCustomer_id());
			pstmt.setInt(4, t.getOrder_link());
			pstmt.setDouble(5, t.getTotalPrice());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "CREATE  ->  orders");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Order t) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "update orders set lineItem_id = ?, store_id = ?, customer_id = ?, order_link = ?, totalPrice = ? where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, t.getLineItem_id());
			pstmt.setInt(2, t.getStore_id());
			pstmt.setInt(3, t.getCustomer_id());
			pstmt.setInt(4, t.getOrder_link());
			pstmt.setDouble(5, t.getTotalPrice());
			pstmt.setInt(6, t.getId());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "UPDATE  ->  orders");
			
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
			
			logger.logDB(LogLevel.info, "DELETE  ->  orders");
			System.out.println("Order id: " + t.getId() + ", successfully deleted from the database.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Order> getAllByOrderLinkCustomer(String orderBySelection, int customerId, String sort, String filterPick) {
		List<Order> orderList = new ArrayList<Order>();
		String query = "";
		
		if(filterPick.equals("customer") && sort.equals("price")) {
			query = "select orders.* from orders join orderlink on orders.order_link = orderlink.id and orders.customer_id = ?  order by orderlink.subtotal " + orderBySelection;
		}else if(filterPick.equals("customer") && sort.equals("orderNum")) {
			query = "select * from orders where customer_id = ? order by order_link " + orderBySelection;
		}else if(filterPick.equals("store") && sort.equals("price")) {
			query = "select orders.* from orders join orderlink on orders.order_link = orderlink.id and orders.store_id = ?  order by orderlink.subtotal " + orderBySelection;
		}else {
			query = "select * from orders where store_id = ? order by order_link " + orderBySelection;
		}
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  orders");
			
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("id"), rs.getInt("lineItem_id"), rs.getInt("store_id"), rs.getInt("customer_id"), rs.getInt("order_link"), rs.getDouble("totalPrice")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}

}
