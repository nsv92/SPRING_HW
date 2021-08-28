package Carts;

import Products.Product;
import Products.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> cartList = new ArrayList<>();
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean addById (int id) {
        for (Product product : productRepository.getProductList()) {
            if (product.getId() == id) {
                cartList.add(product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int id) {
        for (Product product : cartList) {
            if (product.getId() == id) {
                cartList.remove(product);
                return true;
            }
        }
        return false;
    }

//    добавляет в cart все их productRepo
    public void addAll() {
        cartList.addAll(productRepository.getProductList());
    }

    public void deleteAll()  {
        cartList.clear();
    }

    @Override
    public String toString() {
        return "Cart{ " + cartList + " }";
    }
}
