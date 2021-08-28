package Main;

import Carts.Cart;
import Products.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println(productRepository);
        System.out.println("--------------");
//        создал 2 корзины для проверки SCOPE_PROTOTYPE
        Cart cart1 = context.getBean(Cart.class);
        Cart cart2 = context.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your command:");
//        cart'i' - показать содержимое cart'i'
//        add_all cart'i' - добавить все позиции в cart'i'
//        delete_all cart'i' - удалить все позиции из cart'i'
//        add 'id' cart'i' - добавить продукт с 'id' в cart'i'
//        delete 'id' cart'i' - удалить продукт с 'id' из cart'i'

        do {
            String cmd = scanner.nextLine();
            if (cmd.startsWith("cart")) {
                if (cmd.endsWith("1")) {
                    System.out.println("Cart1: " + cart1);
                } else if (cmd.endsWith("2")) {
                    System.out.println("Cart2: " + cart2);
                } else System.out.println("Incorrect cart name!");
            } else if (cmd.startsWith("add_all ")) {
                if (cmd.endsWith("cart1")) {
                    cart1.addAll();
                    System.out.println("All products have been added to cart1!");
                } else if (cmd.endsWith("cart2")) {
                    cart2.addAll();
                    System.out.println("All products have been added to cart2!");
                } else System.out.println("Incorrect cart name!");
            } else if (cmd.startsWith("delete_all ")) {
                if (cmd.endsWith("cart1")) {
                    cart1.deleteAll();
                    System.out.println("All products have been deleted from cart1!");
                } else if (cmd.endsWith("cart2")) {
                    cart2.deleteAll();
                    System.out.println("All products have been deleted from cart2!");
                } else System.out.println("Incorrect cart name!");
            } else if (cmd.startsWith("add ")) {
                String[] str = cmd.split("\\s", 3);
                int id = Integer.parseInt(str[1]);
                if (str[2].equals("cart1")) {
                    if (cart1.addById(id)) {
                        System.out.println("Product (id: " + id + ") has been added to cart1 successfully!");
                    } else System.out.println("Product with id: " + id + " doesnt exist!");
                } else if (str[2].equals("cart2")) {
                    if (cart2.addById(id)) {
                        System.out.println("Product (id: " + id + ") has been added to cart2 successfully!");
                    } else System.out.println("Product with id: " + id + " doesnt exist!");
                } else System.out.println("Incorrect cart name!");
            } else if (cmd.startsWith("delete ")) {
                String[] str = cmd.split("\\s", 3);
                int id = Integer.parseInt(str[1]);
                if (str[2].equals("cart1")) {
                    if (cart1.deleteById(id)) {
                        System.out.println("Product (id: " + id + ") has been deleted from cart1 successfully!");
                    } else System.out.println("Cant find product with id: " + id + " in cart1!");
                } else if (str[2].equals("cart2")) {
                    if (cart2.deleteById(id)) {
                        System.out.println("Product (id: " + id + ") has been deleted from cart2 successfully!");
                    } else System.out.println("Cant find product with id: " + id + " in cart2!");
                } else System.out.println("Incorrect cart name!");
            } else System.out.println("Incorrect command!");
        } while (true);
    }
}
