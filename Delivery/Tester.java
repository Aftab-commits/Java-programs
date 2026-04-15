package Delivery;

import java.util.ArrayList;

public class Tester {
    public static void main(String args[]){
        // create three restaurants:
        Restaurant r1 = new Restaurant("Butt Karahi", "Lahore", 4.0);
        Restaurant r2 = new Restaurant("Kolachi", "Karachi", 4.5);
        Restaurant r3 = new Restaurant("Monal", "Islamabad", 4.9);

        r1.addMenuItem(new MenuItem("Nihari", 800, "Desi"));
        r1.addMenuItem(new MenuItem("Lassi", 200, "Drinks"));

        r2.addMenuItem(new MenuItem("Grilled Fish", 1800, "Seafood"));
        r2.addMenuItem(new MenuItem("Prawn Karahi", 2500, "Seafood"));

        r3.addMenuItem(new MenuItem("BBQ Platter", 3000, "BBQ"));
        r3.addMenuItem(new MenuItem("Green Tea", 300, "Drinks"));

        Restaurant [] res = {r1,r2,r3};

        // create a delivery system:
        DeliverySystem FoodPanda = new DeliverySystem(res);
        System.out.println(FoodPanda);

        //demonstrate placing orders, copying orders (deep
        //copy), and using toString/equals.

        // placing some orders
        ArrayList<MenuItem> aliItems = new ArrayList<>();
        aliItems.add(new MenuItem("Karahi", 1500, "Desi"));
        aliItems.add(new MenuItem("Lassi", 200,"Drinks"));
        Order order1 = new Order("Ali", aliItems);

        ArrayList<MenuItem> aftabItems = new ArrayList<>();
        aftabItems.add(new MenuItem("Grilled Fish", 1800, "Seafood"));
        aftabItems.add(new MenuItem("Prawn Karahi", 2500, "Seafood"));
        Order order2 = new Order("Aftab", aftabItems);

        System.out.println("\n" + order1);
        System.out.println(order2);

        // copying orders to check the deep copy:
        Order copy = new Order(order1);
        System.out.println("The order id of the original order: " + order1.getOrderId());
        System.out.println("The order id of the copied order: " + copy.getOrderId());
        System.out.println(copy);

        // demonstrate the equals method:
        MenuItem m1 = new MenuItem("Karahi", 1500, "Desi");
        MenuItem m2 = new MenuItem("Karahi", 1500, "Desi");
        MenuItem m3 = new MenuItem("Biryani", 500, "Desi");
        System.out.println("\nm1 equals m2: " + m1.equals(m2)); // should be true
        System.out.println("m1 equals m3: " + m1.equals(m3));

        // demonstrate the composition in the Restaurant:
        Restaurant r3Copy = new Restaurant(r3);
        r3Copy.addMenuItem(new MenuItem("Coffee", 400, "Drinks"));
        System.out.println("\nOriginal Monal (no Coffee):");
        System.out.println(r3);
        System.out.println("Copied Monal (has Coffee):");
        System.out.println(r3Copy);

        // finding the restaurants in lahore
        ArrayList<Restaurant> lahoreRestaurants = FoodPanda.find("Lahore");
        System.out.println("Restaurants in Lahore:");
        for (Restaurant r : lahoreRestaurants) {
            System.out.println(r);
        }

        // getting seafood items from kolachi
        ArrayList<MenuItem> seafood = r2.getMenuByCategory("Seafood");
        System.out.println("\nSeafood at Kolachi:");
        for (MenuItem m : seafood) {
            System.out.println(m);
        }

        // removing pizza from butt karahi and printing to verify
        r1.removeMenuItem(new MenuItem("Pizza", 1000, "Fast Food"));
        System.out.println("\nButt Karahi after removing Pizza:");
        System.out.println(r1);

        // display methods
        System.out.println(FoodPanda.displayMenu());
        System.out.println(FoodPanda.displayByCity("Karachi"));
        System.out.println(FoodPanda.displayByCity("Peshawar"));
    }
}
