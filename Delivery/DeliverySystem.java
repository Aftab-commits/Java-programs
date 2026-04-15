package Delivery;

import java.util.ArrayList;

public class DeliverySystem {
    //aggregate an array of the restaurant and does not own them:

    //field:
    private final Restaurant [] r; //declaring final as there is no
    // add and remove method for the r

    //constructor:
    DeliverySystem(Restaurant [] r) {
        this.r = r;
    }

    // method for finding the restaurants by city :
    ArrayList<Restaurant> find(String cityF){
        ArrayList<Restaurant> f = new ArrayList<>();
        for(Restaurant a : r){
            if(a.getCity().equals(cityF)){
                f.add(a);
            }
        }
        return f; // this will return all the restaurants in the
        // required city
    }

    // A display method to display the menu of the all the restaurants:
    String displayMenu(){
        StringBuilder res =new StringBuilder();
        res.append("================================\n");
        res.append("   ALL RESTAURANTS & MENUS\n");
        res.append("================================\n");
        for(Restaurant a: r){
            res.append(a.toString());
            res.append("\n");
        }
        return res.toString();
    }


    // This method will display the menu of all the restaurants in the
    // restaurants in the given city:
    String displayByCity(String city){
        StringBuilder res = new StringBuilder();
        res.append("================================\n");
        res.append("   RESTAURANTS IN " + city.toUpperCase() + "\n");
        res.append("================================\n");
        boolean found =false;
        for(Restaurant a : r){
            if(a.getCity().equals(city)){
                res.append(a.toString());
                res.append("\n");
                found = true;
            }
        }
        if(!found){
            res.append("  No restaurants found in " + city + ".\n");
            res.append("================================");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("================================\n");
        sb.append("   FOODPANDA DELIVERY SYSTEM\n");
        sb.append("================================\n");
        for (Restaurant a : r) {
            sb.append(a +"\n");
        }
        sb.append("================================");
        return sb.toString();
    }
}
