package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: seller findByID ===");
		System.out.println(sellerDao.findById(11));
		/*
		 * Seller seller = new Seller(11, "Nicolas Stumpf", "ncs.stumpf@gmail.com",
		 * sdf.parse("1992/11/10") , 1250.0, new Department(1, "asda"));
		 * sellerDao.update(seller); try { sellerDao.insert(new Seller(0,
		 * "Nicolas Stumpf", "ncs.stumpf@gmail.com", sdf.parse("1992/11/10") , 1250.0,
		 * new Department(1, "asda"))); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println("=== Test 2: seller findAll ===");
		System.out.println();
		sellerDao.findAll().forEach(System.out::println);
		System.out.println();
		System.out.println("=== Test 3: seller findByDepartment ===");
		Department department = new Department(2, null);

		sellerDao.findByDepartment(department).forEach(System.out::println);

		System.out.println("=== Test 3: seller findByDepartment ===");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		Seller seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		
		
		
	}
}
