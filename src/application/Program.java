package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter client Data");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = input.next();

        Client myClient = new Client(name, email, date);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());

        System.out.print("How many items for this order? ");
        int qtdItem = input.nextInt();

        Order myOrder = new Order(new Date(), status, myClient);

        for (int i = 1; i <= qtdItem; i++){
            System.out.printf("Enter #%d item data:\n", i);

            System.out.print("Product name: ");
            input.nextLine();
            String productName = input.nextLine();
            System.out.print("Product price: ");
            double productPrice = input.nextDouble();
            System.out.print("Quantity: ");
            int quantity = input.nextInt();

            Product myProd = new Product(productName, productPrice);
            OrderItem myOrderItem = new OrderItem(quantity, productPrice, myProd);

            myOrder.addItem(myOrderItem);

        }

        myOrder.OrderSummary(myOrder);

    }
}
