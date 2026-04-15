package Delivery;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<MenuItem> menu;
    // this class should compose this arraylist menu:

    private String name;
    private String city;
    public double rating;

    Restaurant(String name, String city,double rating){
        menu = new ArrayList<>();

        // some MenuItems are common in all the restaurants by default:
        menu.add(new MenuItem("Karahi", 1500, "Desi"));
        menu.add(new MenuItem("Biryani", 500, "Desi"));
        menu.add(new MenuItem("Pizza", 1000, "Fast Food"));

        this.name = name;
        this.city = city;
        this.rating = rating;
    }
    Restaurant(Restaurant r){
        this.city = r.city;
        this.name = r.name;
        menu = new ArrayList<>();

        // deep copy for the menu item to display the composition:
        for(MenuItem a : r.menu){
            // this will call the copy constructor of the
            // MenuItem class and that will use deep copy:
            this.menu.add(new MenuItem(a));
        }
        this.rating = r.rating;
    }

    // Setters for the name and the city (no setter for the menu, you can only add or remove in it):
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getters for the name, city and menu:
    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getMenu() {
        ArrayList<MenuItem> newMenu = new ArrayList<>();
        for(MenuItem m : menu){
            newMenu.add(new MenuItem(m));
        }
        return newMenu; // this will return a copy of the menu preventing changing in the original one
    }

    void addMenuItem(MenuItem a){
        menu.add(new MenuItem(a));
    }

    void removeMenuItem(MenuItem a){
        // this will the equals method of the MenuItem internally:
        menu.remove(a);
    }

    // method to return all the items of the matching category:
    ArrayList<MenuItem> getMenuByCategory(String category){
        ArrayList<MenuItem> res = new ArrayList<>();
        for(MenuItem a : menu){
            if(a.getCategory().equals(category)){
                res.add(new MenuItem(a));
            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("================================\n");
        sb.append("  " + name + " (" + city + ")\n");
        sb.append("  Rating: " + rating + "/5\n");
        sb.append("--------------------------------\n");
        sb.append("  MENU:\n");
        for (MenuItem m : menu) {
            sb.append("  - " + m.getName() + " [" + m.getCategory() + "] ... Rs. " + m.getPrice() + "\n");
        }
        sb.append("================================");
        return sb.toString();
    }

}
