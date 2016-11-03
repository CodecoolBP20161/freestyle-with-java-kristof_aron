import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kekesaron on 2016.11.02..
 */
public class CashRegister {
    public static int customer = 0;
    List<Product> basket;

    public CashRegister() {
        basket = new ArrayList<Product>();
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        Scanner input = new Scanner(System.in);
        int barcode;
        boolean nextCustomer;
        System.out.println("Welcome to Cash Register Pro!");
        while (1 < 2) {
            customer++;
            System.out.println("Bill for customer: " + customer);
            nextCustomer = true;
            while(nextCustomer) {
                System.out.print("item: ");
                try {
                    barcode = input.nextInt();
                    input.nextLine();
                    try {
                        Product product = stock.getProductByBarcode(barcode);
                        System.out.println(product.getName() + "/t" + product.getNetPrice());
                    }
                    catch (UnregisteredProductException e) {
                        System.out.println("Error: " + e);
                    }
                }
                catch (InputMismatchException e) {
                    nextCustomer = false;
                    input.nextLine();
                }


            }
        }

    }
}