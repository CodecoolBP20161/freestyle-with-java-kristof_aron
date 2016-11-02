/**
 * Created by kekesaron on 2016.11.02..
 */
public class Product {
    private int barcode;
    private String name;
    private float netPrice;
    public Product(int barcode, String name, float netPrice){
        this.barcode = barcode;
        this.name = name;
        this.netPrice = netPrice;
    }
    public int getBarcode() {
        return barcode;
    }
    public String getName() {
        return name;
    }
    public float getNetPrice() {
        return netPrice;
    }
}
