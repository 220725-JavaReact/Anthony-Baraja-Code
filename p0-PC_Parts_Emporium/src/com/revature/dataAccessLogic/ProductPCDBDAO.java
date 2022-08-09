package com.revature.dataAccessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.ProductPC;
import com.revature.models.StoreFront;
import com.revature.util.ConnectionFactory;

public class ProductPCDBDAO implements Dao<ProductPC>, ProductInterface<ProductPC> {

	@Override
	public ProductPC get(int id) {
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from products where id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new ProductPC(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("category"), rs.getInt("store_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ProductPC> getAllByStoreId(int store_id) {
		List<ProductPC> productList = new ArrayList<ProductPC>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from products where store_id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, store_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				productList.add(new ProductPC(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("category"), rs.getInt("store_id")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	public List<Integer> getAllProductStoreIdList(int store_id) {
		List<Integer> productIdSelectionList = new ArrayList<Integer>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select id from products where store_id = ?";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, store_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//productList.add(new ProductPC(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("category"), rs.getInt("store_id")));
				productIdSelectionList.add(rs.getInt("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productIdSelectionList;
	}

	@Override
	public List<ProductPC> getAll() {
		// TODO Auto-generated method stub
		List<ProductPC> productList = new ArrayList<ProductPC>();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from products";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				productList.add(new ProductPC(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("category"), rs.getInt("store_id")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public void save(ProductPC t) {
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "Insert into products (id, name, price, description, category, store_id) values (DEFAULT,?,?,?,?,?)";
			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, t.getName());
			pstmt.setDouble(2, t.getPrice());
			pstmt.setString(3, t.getDescription());
			pstmt.setString(4, t.getCategory());
			pstmt.setInt(5, t.getStoreId());
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProductPC t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProductPC t) {
		// TODO Auto-generated method stub

	}

}
