package classes;

import entities.enums.OrderStatus;
import java.util.Date;


public class Order {

    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Order(Integer id, Date moment, OrderStatus status){
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("id=").append(id);
        sb.append(", moment=").append(moment);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    

}

