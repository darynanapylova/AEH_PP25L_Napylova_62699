package pl.pp;

abstract class Vehicle {
    protected String registrationNumber;
    protected String vinNumber;
    protected String color;
    protected double price;
    protected double fuelConsumption;
    protected String fuelLevel;
    protected double mileage;

    public Vehicle(String registrationNumber, String vinNumber, String color, double price,
                   double fuelConsumption, String fuelLevel, double mileage) {
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.color = color;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.mileage = mileage;
    }

    public abstract void refuel();

    public void displayInfo() {
        System.out.println("Vehicle: " + registrationNumber);
        System.out.println("- VIN: " + vinNumber);
        System.out.println("- Color: " + color);
        System.out.println("- Price: " + price + " PLN");
        System.out.println("- Consumption: " + fuelConsumption + " L/100km");
        System.out.println("- Fuel level: " + fuelLevel);
        System.out.println("- Mileage: " + mileage + " km");
    }
}

interface FuelType {
    String fuelKind();
}

class PassengerCar extends Vehicle implements FuelType {
    private int doorCount;

    public PassengerCar(String registrationNumber, String vinNumber, String color, double price,
                        double fuelConsumption, String fuelLevel, double mileage, int doorCount) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage);
        this.doorCount = doorCount;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling passenger car: " + registrationNumber);
        fuelLevel = "Full";
    }

    @Override
    public String fuelKind() {
        return "petrol";
    }
}

class Truck extends Vehicle implements FuelType {
    private double maxLoad;

    public Truck(String registrationNumber, String vinNumber, String color, double price,
                 double fuelConsumption, String fuelLevel, double mileage, double maxLoad) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage);
        this.maxLoad = maxLoad;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling truck: " + registrationNumber);
        fuelLevel = "Full";
    }

    @Override
    public String fuelKind() {
        return "diesel";
    }
}

class Motorcycle extends Vehicle implements FuelType {
    private boolean hasSidecar;

    public Motorcycle(String registrationNumber, String vinNumber, String color, double price,
                      double fuelConsumption, String fuelLevel, double mileage, boolean hasSidecar) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling motorcycle: " + registrationNumber);
        fuelLevel = "Full";
    }

    @Override
    public String fuelKind() {
        return "petrol";
    }
}

class ConstructionMachine extends Vehicle implements FuelType {
    private double workedHours;

    public ConstructionMachine(String registrationNumber, String vinNumber, String color, double price,
                               double fuelConsumption, String fuelLevel, double mileage, double workedHours) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage);
        this.workedHours = workedHours;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling construction machine: " + registrationNumber);
        fuelLevel = "Full";
    }

    @Override
    public String fuelKind() {
        return "diesel";
    }
}

public class mojaCzternastaAplikacja {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new PassengerCar("WA4321A", "VIN987", "Silver", 67000, 6.8, "Low", 8200, 4),
                new Truck("GD5589T", "VIN654", "White", 158000, 22.5, "Full", 125000, 14.5),
                new Motorcycle("PO4433M", "VIN321", "Green", 18500, 4.2, "Half", 3700, false),
                new ConstructionMachine("LU8907B", "VIN777", "Orange", 92000, 18.0, "Quarter", 45000, 1560.0)
        };

        for (Vehicle vehicle : fleet) {
            System.out.println("\n=== Checking vehicle ===");
            vehicle.displayInfo();
            vehicle.refuel();

            if (vehicle instanceof FuelType) {
                System.out.println("Fuel type: " + ((FuelType) vehicle).fuelKind());
            }
        }
    }
}
