package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next().toUpperCase();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Date moment = sdf2.parse("20/04/2018 11:25:09");
		Order order = new Order(moment, OrderStatus.valueOf(status), client);
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();	
			Product product = new Product(productName, productPrice);
			order.addItem(new OrderItem(quantity, productPrice, product));	
		}
		
		System.out.println(order);
		
		
		sc.close();

	}

}
