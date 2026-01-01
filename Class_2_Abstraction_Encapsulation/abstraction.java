/*
Car Interface --> Act as an interface for Outside world to operate the car.
This interface tells 'WHAT' all it can do rather then 'HOW' it does that.
Since this is an interface we cannot directly create Objects of this. We
need to implement it first and then that child class will have the responsibility to
provide implementation details of all the methods in the interface.

In our real world example of Car, imagine you sitting in the car and able to operate
the car (startEngine, accelerate, brake, turn) just by pressing or moving some
pedals/buttons/stearing wheel etc. You dont need to know how these things work, and
also they are hidden under thre hood.
This Interface 'Car' denotes that (pedals/buttons/stearing wheel etc).
*/

interface Car {
    // All interface methods are implicitly PUBLIC or STATIC unless declared default.
    public void startEngine();
    public void shiftGear(int gear);
    public void accelerate();
    public void brake();
    public void stopEngine();

    /* It declares methods without providing any implementation details (no method bodies).
    By doing this, it hides the complex mechanism of how an engine starts, or how a gear shift occurs.
    The user of the interface only sees the public contract */
}

class SportsCar implements Car {
    String brand;
    String model;
    boolean isEngineOn = false;
    int currentSpeed;
    int currentGear;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    @Override
    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot Cannot Shift Gear.");
            return;
        }
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    @Override
    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}



public class abstraction {
    public static void main(String[] args) {

        // using the interface, not the class, because we will write methods accepting
        // Car interfaces as parameters, not seperate functions accepting different Car type Objects
        // Variable types of type PARENT can be assigned to new object of type CHILD
        Car myCar = new SportsCar("Ferrari", "Roma");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.brake();
        myCar.stopEngine();

        /* How it Achieves Abstraction: When you call myCar.startEngine(), you are interacting
        only with the Car interface. You don't need to know if myCar is a SportsCar, a Truck,
        or an EconomyCar. The specific implementation details (like the isEngineOn variable,
        the speed calculation, or the "roar" sound printed) are hidden from the client code in
        the main method. The client only relies on the abstract concept of "startEngine()"
        which is in the public contract provided by the interface Car*/
    }
}