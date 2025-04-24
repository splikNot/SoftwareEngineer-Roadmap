package entities;

public class OrderItem {
    
    private Product product;
    private Integer quantity;
    private Double price;

    public OrderItem(){

    }

    public OrderItem(Product product, Integer quantity){
        this.product = product;
        this.price = product.getPrice();
        this.quantity = quantity;
    }

    public Product getProduct(){
        return product;
    }

    public Double subTotal(){
        return quantity*price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        
        return String.format("There is %d %s for %.2f %nSubtotal: %.2f", quantity, 
        product.getName(), getPrice(), subTotal());
    }
}
