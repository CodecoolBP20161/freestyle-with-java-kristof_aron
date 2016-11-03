import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by kekesaron on 2016.11.02..
 */
public class CashRegister {
    public static int customer = 0;

    public static void main(String[] args) {
        Stock stock = new Stock();
        Scanner input = new Scanner(System.in);
        int barcode;
        boolean nextCustomer;

        stock.registerProduct(new Product(10, "Bread", 5.00f));
        stock.registerProduct(new Product(11, "Chocolate", 9.99f));
        stock.registerProduct(new Product(12, "Beer", 5.99f));
        stock.registerProduct(new Product(13, "Milk", 2.90f));
        stock.registerProduct(new Product(14, "Ice cream", 15.90f));
        stock.registerProduct(new Product(15, "Rice", 5.29f));
        stock.registerProduct(new Product(16, "Sugar", 4.29f));
        stock.registerProduct(new Product(17, "Flour", 3.79f));
        stock.registerProduct(new Product(18, "Eggs", 5.50f));
        stock.registerProduct(new Product(19, "Mineral water", 1.99f));
        stock.registerProduct(new Product(20, "Orange juice", 4.39f));

        System.out.println("Welcome to Cash Register Pro!");
        Bill bill;
        while (1 < 2) {
            customer++;
            System.out.println("Bill for customer: " + customer);
            System.out.println("**********************");
            bill = new Bill();
            nextCustomer = true;
            while(nextCustomer) {
                System.out.print("item: ");
                try {
                    barcode = input.nextInt();
                    input.nextLine();
                    try {
                        Product product = stock.getProductByBarcode(barcode);
                        bill.addItem(product);
                        System.out.println(product.getName() + "\t" + product.getNetPrice());
                    }
                    catch (UnregisteredProductException e) {
                        System.out.println("Error: " + e);
                    }
                }
                catch (InputMismatchException e) {
                    nextCustomer = false;
                    input.nextLine();
                    bill.printBill();
                }


            }
        }

    }
}