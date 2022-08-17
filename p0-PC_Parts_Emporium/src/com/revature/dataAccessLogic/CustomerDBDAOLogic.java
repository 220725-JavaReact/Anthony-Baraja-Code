package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class CustomerDBDAOLogic implements Dao<Customer>, CustomerInterface{
	
	private static Logger logger = new Logger();

	@Override
	public Customer get(int id) {
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from customers where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  customers");
			
			if(rs.next()) {
				return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phone_number"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Customer getCustomerByName(String name) {
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from customers where name like ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			
			logger.logDB(LogLevel.info, "GET  ->  customers");
			
			if(rs.next()) {
				return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phone_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customerList = new ArrayList<Customer>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from customers";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			logger.logDB(LogLevel.info, "GET  ->  customers");
			
			while(rs.next()) {
				customerList.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phone_number")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return customerList;
	}

	@Override
	public void save(Customer t) {
		// TODO Auto-generated method stub
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "Insert into customers (id, name, address, email, phone_number) values (DEFAULT,?,?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getAddress());
			pstmt.setString(3, t.getEmail());
			pstmt.setString(4, t.getPhone());
			pstmt.execute();
			
			logger.logDB(LogLevel.info, "CREATE  ->  customers");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer t) {
		// TODO Auto-generated method stub
		
	}

}
