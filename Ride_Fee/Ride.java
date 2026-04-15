import java.util.TooManyListenersException;

public abstract class Ride {
    private  int rideID;
    private String CustomerName;
    private int distance;
    private static int totalRides = 0;
    protected final double basefair = 100;

    //parameterized constructor:

    Ride(int id, String name, int distance){
        this.rideID = id;
        this. CustomerName = name;
        this.distance = distance;
        totalRides ++; // incremented every time the object is made
    }

    // getters and setters:

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    public static int getTotalRides() {
        return totalRides;
    }


    protected abstract double calculateFare();


    public void display() {
        System.out.println("RideID = " + rideID + "\n" +
                "Customer Name = '" + CustomerName + '\'' +  "\n" +
                "Distance = " + distance + " Km" + "\n" +
                "Base fair = " + basefair + " Rs");
    }
}
