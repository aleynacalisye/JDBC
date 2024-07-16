import Entity.Category;
import Entity.Customer;
import Repository.CategoryRepository;
import Repository.CustomerRepository;
import Repository.ProductRepository;
import Util.DatabaseUtil;

import java.util.List;

public static void main(String[] args) {
    DatabaseUtil.connect();

    // Category operations
//    String categoryName = "deneme";
//    CategoryRepository.insert(categoryName);
//
//    List<Category> categoryList = CategoryRepository.list();
//    if (categoryList.isEmpty()) {
//        System.out.println("Kategori listesi boş.");
//    } else {
//        for (Category cat : categoryList) {
//            System.out.println("Category ID: " + cat.getId() + ", Name: " + cat.getName());
//        }
//    }
//
//    int categoryId = 0;
//    String updatedCategoryName = "updatedName";
//    CategoryRepository.update(categoryId, updatedCategoryName);
//    CategoryRepository.delete(categoryId);

    // Customer
    String first_name = "Zalina";
    String last_name = "Barkinhoeva";
    String email = "barkinhoeva@email.com";
    String city = "Grozny";
    String country = "Russia";
    CustomerRepository.insert(first_name, last_name, email, city, country);
    int id = 0;

    String updatedCustomer = "updatedCustomer";
    CustomerRepository.update(id, first_name, last_name, email, city, country);
    CustomerRepository.delete(id);
    List<Customer> customerList = CustomerRepository.list();
    if (customerList.isEmpty()) {
        System.out.println("Müşteri listesi boş.");
    } else {
        for (Customer cus : customerList) {
            System.out.println("Customer ID: " + cus.getId() + ", First Name: " + cus.getFirst_name() + ", Last Name: " + cus.getLast_name() +
                    ", Email: " + cus.getEmail() + ", City: " + cus.getCity() + ", Country: " + cus.getCountry());
        }
    }
}


    // Product

//    int productId = 0;
//    ProductRepository.list(productId);
//    String updatedProductName ="updatedProduct";
//    ProductRepository.update(productId, updatedProductName);
//    ProductRepository.delete(customerId);


