package product;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class HibernateApp {

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        EntityManager entityManager = factory.createEntityManager();

        ProductDao productDao = new ProductDao(entityManager);

        Product product1 = new Product("jjj", 555);
        Product product2 = new Product("rrr", 111);
        Product product3 = new Product("kkk", 444);

        productDao.saveOrUpdate(product1);
        productDao.saveOrUpdate(product2);
        productDao.saveOrUpdate(product3);

        System.out.println("All products: " + productDao.findAll().toString());
        System.out.println("Product with ID=2: " + productDao.findById(2L).toString());
        productDao.deleteById(2L);
        System.out.println("All products: " + productDao.findAll().toString());
    }
}
