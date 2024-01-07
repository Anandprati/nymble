import java.util.ArrayList;
import java.util.List;

class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> signedUpPassengers;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.signedUpPassengers = new ArrayList<>();
    }

    // Getters and setters

    public boolean signUpPassenger(Passenger passenger) {
        if (signedUpPassengers.size() < capacity && !signedUpPassengers.contains(passenger)) {
            signedUpPassengers.add(passenger);
            return true;
        }
        return false;
    }

    // Other methods as needed
}

class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    // Getters and setters

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    // Other methods as needed
}

class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType type;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber, double balance, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.type = type;
        this.signedUpActivities = new ArrayList<>();
    }

    // Getters and setters

    public boolean signUpForActivity(Activity activity) {
        if (type.canSignUpForActivity(this, activity)) {
            boolean success = activity.signUpPassenger(this);
            if (success) {
                signedUpActivities.add(activity);
                return true;
            }
        }
        return false;
    }

    // Other methods as needed
}

enum PassengerType {
    STANDARD {
        @Override
        public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
            return passenger.getBalance() >= activity.getCost();
        }
    },
    GOLD {
        @Override
        public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
            double discountedCost = activity.getCost() * 0.9;
            return passenger.getBalance() >= discountedCost;
        }
    },
    PREMIUM {
        @Override
        public boolean canSignUpForActivity(Passenger passenger, Activity activity) {
            return true; // Premium passengers can sign up for any activity for free
        }
    };

    public abstract boolean canSignUpForActivity(Passenger passenger, Activity activity);
}

class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // Getters and setters

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity && !passengers.contains(passenger)) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    // Other methods as needed

    public void printItinerary() {
        // Implement itinerary printing logic
    }

    public void printPassengerList() {
        // Implement passenger list printing logic
    }

    public void printPassengerDetails(Passenger passenger) {
        // Implement passenger details printing logic
    }

    public void printAvailableActivities() {
        // Implement available activities printing logic
    }
}

public class TravelAgencySystem {
    public static void main(String[] args) {
        // Example usage of the TravelPackage system
        // You can create instances of TravelPackage, Destination, Activity, and Passenger and test the functionality.
    }
}
