package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		List<Product> prod = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used, imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Customs fee: ");
				Double customs = sc.nextDouble();
				prod.add(new ImportedProduct(name, price, customs));
			}
			else if(type == 'c') {
				prod.add(new Product(name, price));
			}
			else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				prod.add(new UsedProduct(name, price, manufactureDate));
			}
			
		}
		
		System.out.println();
		System.out.println("Price Tags:");
		for (Product prods : prod) {
			System.out.println(prods.priceTag());
		}
		
		sc.close();

	}

}
