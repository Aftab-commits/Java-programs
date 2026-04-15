public class PremiumRide extends Ride{
    private final double comfortFee = 100;
    private final double ratePerKm = 10;

    //constructor:
    PremiumRide(int id, String name, int distance){
        super(id,name, distance);
    }

    @Override
    protected double calculateFare(){
        double fare;
        fare = basefair + (getDistance()*ratePerKm) + comfortFee;
        return fare;
    }



    @Override
    public void display(){
        super.display();
        System.out.println();
        System.out.println("===Premium Ride===\n" +
                "Comfort Fee = " + comfortFee + " Rs" + "\n" +
                "Rate per km = " + ratePerKm + " Rs" + "\n" +
                "Calculated fare = " + calculateFare() + " Rs" +  "\n");
    }

}
