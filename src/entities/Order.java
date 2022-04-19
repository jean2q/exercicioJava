package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    protected static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> itemList = new ArrayList<>();

    public Order(){

    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void addItem(OrderItem item){
        itemList.add(item);
    }

    public void removeItem(OrderItem item){
        itemList.remove(item);
    }

    public void OrderSummary(Order myOrder){
        System.out.println("ORDER SUMMARY: ");
        System.out.println(myOrder);

    };

    public double total(){
        double totalValue = 0;

        for (OrderItem item: itemList){
            totalValue += item.subTotal();
        }

        return totalValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append((sdf.format(moment)));
        sb.append("\nOrder status: ").append(status);
        sb.append("\nClient: ").append(client);
        sb.append("\nOrder Items: \n");
        for (OrderItem item: itemList){
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total price: R$ ").append(this.total());
        return sb.toString();
    }
}
