package model.dao;

import java.util.List;

public interface SellerDao {
	
	void insert(SellerDao seller);
	void update(SellerDao seller);
	void deleteById(Integer id);
	SellerDao findById(Integer id);
	List<SellerDao> findAll();

}
