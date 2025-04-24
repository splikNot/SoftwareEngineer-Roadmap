package classes;

public class ImportedProduct extends Product {

    Double customFee;

    // Constructors
    public ImportedProduct() {

    }

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(Double customFee) {
        this.customFee = customFee;
    }

    // Metodos
    public Double totalPrice(){
        return getPrice() + getCustomFee();
    }

    @Override
    public String priceTag(){
        return String.format("%s $ %.2f (Custom fee: $ %.2f)%n",
        getName(), totalPrice(), getCustomFee());
    }

}
