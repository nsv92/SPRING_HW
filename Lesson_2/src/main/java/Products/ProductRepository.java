package Products;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product(1, "Apple", 50.0));
        productList.add(new Product(2, "Banana", 61.00));
        productList.add(new Product(3, "Orange", 24.0));
        productList.add(new Product(4, "Mango", 94.0));
        productList.add(new Product(5, "Coconut", 54.0));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void productListAdd(Product newProduct) {
        productList.add(newProduct);
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "productList=" + productList +
                '}';
    }
}
