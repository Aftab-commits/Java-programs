package Delivery;

public class MenuItem {
    private String name;
    private double price;
    private String category;

    MenuItem(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // copy constructor performing deep copy:
    MenuItem(MenuItem m){
        this.name = m.name;
        this.price = m.price;
        this.category = m.category;
    }


    // Setters:
    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //Getters:
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        MenuItem other  = (MenuItem) obj;

        return this.name.equals(other.name) &&
                this.price == other.price; // this will return true if
        // they have the same name and the same price.
    }


    @Override
    public String toString() {
        return "  - " + name +" [" + category + "] ... Rs. " + price;
    }
}
