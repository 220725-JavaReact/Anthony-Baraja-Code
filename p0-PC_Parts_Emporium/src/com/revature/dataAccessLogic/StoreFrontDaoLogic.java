package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.StoreFront;
import com.revature.util.ConnectionFactory;

public class StoreFrontDaoLogic implements Dao<StoreFront> {

	@Override
	public StoreFront get(int id) {
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from storefront where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new StoreFront(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<StoreFront> getAll() {
		// TODO Auto-generated method stub
		List<StoreFront> storeFrontList = new ArrayList<StoreFront>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from storefront";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				storeFrontList.add(new StoreFront(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return storeFrontList;
	}
	/*
	public List<StoreFront> getAll() {
		return this.StoreFrontList;
	}*/

	@Override
	public void save(StoreFront t) {
	}

	@Override
	public void update(StoreFront t) {
		
	}

	@Override
	public void delete(StoreFront t) {
		
	}

}
