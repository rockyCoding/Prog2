package driveSim;

public class Car {

    private String name;
    private Double capacity, mileage, fuel;

    // Constructor
    Car(String name, Double capacity, Double mileage, Double fuel){

        this.name = name;
        this.capacity = capacity;
        this.mileage = mileage;
        this.fuel = fuel;

    }

    // Function updates fuel level if distance driven is possible on fuel reserves
    boolean useFuel(Double usage){
        if (this.fuel > usage){
            this.fuel = (this.fuel - usage);
            return true;
        }
        else return false;

    }

    // adds fuel if enough capacity given
    boolean addFuel(double addage){
        if ((addage + this.fuel) < capacity){
            this.fuel = this.fuel + addage;
            return true;
        }
        else return false;
    }

    // gets current fuel level
    double getFuelLevel(){
        return this.fuel;
    }

    // gets milage
    double getMilage(){
        return mileage;
    }

    // gets name of car
    public String getName() {
        return name;
    }

    // gets fuel capacity
    public Double getCapacity() {
        return capacity;
    }
}
