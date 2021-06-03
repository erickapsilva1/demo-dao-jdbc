package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(SellerDao seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SellerDao seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select s.*, d.NAME as DEPNAME "
					+ "from SELLER s "
					+ "join DEPARTMENT d on d.ID = s.ID "
					+ "where s.ID = ?"					
					);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				
				Department department = instantiateDepartment(rs);
				Seller seller = instantiateSeller(rs, department);
				
				return seller;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("ID"));
		seller.setName(rs.getString("NAME"));
		seller.setEmail(rs.getString("EMAIL"));
		seller.setBaseSalaty(rs.getDouble("BASESALARY"));
		seller.setBirthDate(rs.getDate("BIRTHDATE"));
		seller.setDepartment(department);
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("DEPARTMENTID"));
		department.setName(rs.getString("DEPNAME"));
		return department;
	}

	@Override
	public List<SellerDao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
