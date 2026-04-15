package Delivery;

import java.util.ArrayList;

public class Order {
    private final int orderId;
    private static int counter = 1;
    private final String name;
    private final ArrayList<MenuItem> item;

    // the items ordered are in composition:
    Order(String name, ArrayList<MenuItem> m){
        this.name = name;
        item = new ArrayList<>();
        for(MenuItem n : m){
            item.add(new MenuItem(n));
        }
        this.orderId = counter;
        counter ++;
    }

    Order(Order a){
        this.name = a.name;
        item = new ArrayList<>();
        for(MenuItem n : a.item){
            item.add(new MenuItem(n));
        }
        this.orderId = counter;
        counter ++;
    }

    double getTotalPrice(){
        // it gives the price of all the items ordered:
        double total= 0;
        for(MenuItem a: item){
            total+= a.getPrice();
        }
        return total;
    }

    int getOrderId(){
        return orderId;
    }

    // toString() — should display orderId,
    // customerName, items, and total price


    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("================================\n");
        sb.append("  Order ID: " + orderId + "\n");
        sb.append("  Customer: " + name + "\n");
        sb.append("--------------------------------\n");
        sb.append("  ITEMS:\n");
        for (MenuItem m : item) {
            sb.append("  - " + m.getName() +" [" + m.getCategory() + "] ... Rs. "+ m.getPrice() + "\n");
        }
        sb.append("--------------------------------\n");
        sb.append("  Total: Rs. " + getTotalPrice() + "\n");
        sb.append("================================");
        return sb.toString();
    }
}
