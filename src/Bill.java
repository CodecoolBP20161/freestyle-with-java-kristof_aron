import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;


/**
 * Created by kekesaron on 2016.11.02..
 */
public class Bill {
    private List<Product> basket;

    public Bill() {
        basket = new ArrayList<Product>();
    }

    public void addItem(Product item) {
        basket.add(item);
    }

    public void printBill() {
        float total = 0;
        System.out.printf("%n %n %17s %n", "ABC");
        System.out.printf("%23s %n %n", "Nagymezo 44.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-23s %10s %n", "Product", "Price");
        System.out.println("----------------------------------");
        for (Product item : basket) {
            System.out.printf("%-23s %10.2f %n", item.getName(), item.getNetPrice());
            total += item.getNetPrice();
        }
        System.out.println("----------------------------------");
        System.out.printf("%-23s %10.2f %n %n", "Total:", total);
        System.out.println("Date: " + new Date().toString());
        Random rand = new Random();
        System.out.println("NAV ID: " + rand.nextInt(999999) + "\n\n");
    }
}
