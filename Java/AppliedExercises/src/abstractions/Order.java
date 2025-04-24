package abstractions;

import entities.Client;
import entities.OrderItem;
import entities.enums.OrderStatus;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Order {

    //private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
    private final Client client;
    private final LocalDateTime moment;
    private OrderStatus status;
    private final List<OrderItem> order = new ArrayList<>();

    public Order(Client client, LocalDateTime moment, OrderStatus status){
        this.client = client;
        this.moment = moment;
        this.status = status;
    }

    public Client getClient(){
        return client;
    }

    public LocalDateTime getMoment(){
        return moment;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setStatus(OrderStatus newStatus){
        this.status = newStatus;
    }

    public void addItem(OrderItem item){
        order.add(item);
    }

    public void removeItem(OrderItem item){
        order.remove(item);
    }

    public Double total(){
        double count = 0;

        for(OrderItem item : order){
            count += item.subTotal();
        }

        return count;
    }

    @SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "override"})
     public String toString(){

        StringBuilder sb = new StringBuilder();
        
        sb.append("Client: " + client.getName() + " - ");
        sb.append("Email: " + client.getEmail() + "\n");
        sb.append("Order Date: ");
        sb.append(dtf.format(moment) + "\n");
        sb.append("Status: ");
        sb.append(status + "\n");
        sb.append("\n");
        sb.append("Order: \n");

        for (OrderItem item : order){
            sb.append(item.getQuantity() + "x " + item.getProduct().getName() + " - " + "R$: " + 
            String.format("%.2f", item.subTotal()) + "\n");
        }
        sb.append("\n");
        sb.append("Total: R$ " + String.format("%.2f", total()));
        
        return sb.toString();
    }

}
