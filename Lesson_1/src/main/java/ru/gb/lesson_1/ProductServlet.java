package ru.gb.lesson_1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//  URL для сервлета
//  http://localhost:8080/Lesson_1_war_exploded/products
@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
//  отдаю html c message
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Product list" + "</h1>");
        out.println("<p>" + message + "</p>");
        out.println("</body></html>");
    }

    @Override
    public void init() {
//        создал массив продуктов и закинул его в message
        int productCount = 10;
        Product[] products = new Product[productCount];
        for (int i = 0; i < products.length; i++) {
            double cost = 1000 * Math.random();
            products[i] = new Product(i + 1, "product" + (i + 1), cost);
        }
        message = Arrays.toString(products);
    }

    @Override
    public void destroy() {
    }
}
