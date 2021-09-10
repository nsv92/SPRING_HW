package product;

import javax.persistence.EntityManager;
import java.util.List;


public class ProductDao {
    private EntityManager entityManager;

    public ProductDao() {
    }

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public void deleteById(Long id) {

        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    public void saveOrUpdate(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }


}

