package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Pedro Henrique", "pedrohenrique@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! Id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Updated to " + seller.getName());
		
		/*System.out.println("\n=== TEST 6: seller delete ===");
		System.out.print("Enter with id to delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted!");*/
		
		System.out.println("\n=== TEST 7: department insert ===");
		department = new Department(null, "Music");
		departmentDao.insert(department);
		System.out.println("Inserted! New department: " + department.getName());
		
		System.out.println("\n=== TEST 8: department findById ===");
		department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 9: department findAll ===");
		for (Department obj : departmentDao.findAll()) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 9: department findAll ===");
		departmentDao.deleteByName("Music");
		System.out.println("Deleted!");
			
		sc.close();
	}
	
}
