package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		Department department = new Department(2, null);
		
		System.out.println("------------------------");
		System.out.println("Common select");
		System.out.println(seller);
		System.out.println("------------------------");
		
		List<Seller> list = sellerDao.findByDepartment(seller.getDepartment());
		
		System.out.println("------------------------");
		System.out.println("Common select - list of department");
		System.out.println(seller);
		System.out.println("------------------------");
		
		System.out.println(seller);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("------------------------");
		System.out.println("Common select - all");
		System.out.println(seller);
		System.out.println("------------------------");
		
		List<Seller> listAll = sellerDao.findAll();
		for(Seller s: listAll) {
			System.out.println(s);
		}
		
		System.out.println("------------------------");
		System.out.println("Insert");
		Seller newSeller = new Seller(null, "Chris", "chris@gmail.com", new Date(), 3587.86, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted. New id = " + newSeller.getId());
		System.out.println();
		System.out.println("------------------------");
		
		System.out.println("------------------------");
		System.out.println("Update");
		seller = sellerDao.findById(1);
		seller.setName("Luna Silva");
		sellerDao.update(seller);
		seller = sellerDao.findById(1);
		System.out.println(seller);
		System.out.println("------------------------");

	}

}
