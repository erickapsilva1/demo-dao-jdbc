package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		
		List<Seller> list = sellerDao.findByDepartment(seller.getDepartment());
		
		System.out.println(seller);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("-------------");
		
		List<Seller> listAll = sellerDao.findAll();
		for(Seller s: listAll) {
			System.out.println(s);
		}

	}

}
