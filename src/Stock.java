import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by kekesaron on 2016.11.02..
 */


public class Stock {
    private Map<Product, Integer> inventory;

    public Stock() {
        inventory = new HashMap<Product, Integer>();
    }

    public void registerProduct(Product newProduct) {
        if (inventory.containsKey(newProduct)) {
            System.out.println("This item has already been registered.");
        }
        else {
            inventory.put(newProduct, 0);
        }
    }

    public Set<Product> getRegisteredProducts() {
        return inventory.keySet();
    }

    public Integer getProductNumInStock(int barcode) throws UnregisteredProductException {
        Product product = getProductByBarcode(barcode);
        return inventory.get(product);
    }
    public void setProductNumInStock(int barcode, int quantity) throws UnregisteredProductException {
        Product product = getProductByBarcode(barcode);
        int currentNumber = -2;
        if (inventory.get(product) + quantity < 0) {
            System.out.println("Not enough items available ins stock");
            currentNumber = -1;
        }
        else {
            currentNumber += quantity;
            inventory.put(product, currentNumber);
        }
        if (currentNumber < -1) {
            throw new UnregisteredProductException("Barcode not registered in inventory");
        }
    }

    public Product getProductByBarcode(int code) throws UnregisteredProductException {
        for (Product product : inventory.keySet()) {
            if (product.getBarcode() == code) {
                return product;
            }
        }
        throw new UnregisteredProductException("Barcode not registered in inventory");
    }
}
