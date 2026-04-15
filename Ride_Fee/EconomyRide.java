public class EconomyRide extends Ride {
    private final double ratePerKm = 10;

    // constructor:
    EconomyRide(int id, String name, int distance){
        super(id, name, distance);
    }

    // override the calculate fare of the abstract class:


    @Override
    protected double calculateFare() {
        double fare;
        fare = basefair + (getDistance()*ratePerKm);
        return fare;
    }


    @Override
    public void display(){
        super.display();
        System.out.println();
        System.out.println("===Economy Ride===\n" +
                "Rate per km = " + ratePerKm + " Rs" + "\n" +
                "Calculated fare = " + calculateFare() + " Rs" + "\n");
    }
}
