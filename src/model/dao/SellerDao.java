package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	
	void insert(SellerDao seller);
	void update(SellerDao seller);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<SellerDao> findAll();

}
