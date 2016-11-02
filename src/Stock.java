import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by kekesaron on 2016.11.02..
 */
public class Stock {
    private Map<Product, Integer> inventory = new HashMap<Product, Integer>();

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

    public Integer getProductNumInStock(int barcode) {
        for (Product product : inventory.keySet()) {
            if (product.getBarcode() == barcode) {
                return inventory.get(product);
            }
        }
        try {
            throw new Exception("Barcode not registered in inventory.");
        }
        catch (Exception e) {
            System.out.println("The following error has occurred: " + e);
            return -1;
        }
    }
}
