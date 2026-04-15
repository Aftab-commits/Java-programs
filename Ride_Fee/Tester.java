public class Tester {
    public static void main(String args[]){
        Ride [] sample = new Ride[4]; // to display economical and premium rides

        sample [0] = new EconomyRide(100, "Ali", 70);
        sample [1] = new EconomyRide(101, "Aftab", 50);
        sample[2] = new PremiumRide(102, "Umer", 100);
        sample [3] = new PremiumRide(103, "Eisha", 80);

        // using loop to display the details:
        int i = 1;
        for(Ride r : sample){
            System.out.println("The information of the ride " + i + " is: ");
            r.display();
            System.out.println();
            i++;
        }

        System.out.println("The total number of rides are: " + Ride.getTotalRides());
    }
}
