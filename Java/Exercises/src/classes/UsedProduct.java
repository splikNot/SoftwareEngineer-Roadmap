package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Date manufactureDate;

    // Constructors
    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    // Getters and Setters
    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        return String.format("%s (used) $ %.2f (Manufacture date: %s)%n", 
        getName(), getPrice(), sdf.format(manufactureDate));

    }
}
