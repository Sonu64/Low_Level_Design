/*
Encapsulation says 2 things:
1. An Object's Characteristics and its behaviour are encapsulated together
within that Object.
2. All the characteristics or behaviours are not for everyone to access.
Object should provide data security.

We follow above 2 pointers about Object of real world in programming by:
1. Creating a class that act as a blueprint for Object creation. Class contain
all the characteristics (class variable) and behaviour (class methods) in one block,
encapsulating it together.
2. We introduce access modifiers (public, private, protected, default) etc to provide data
security to the class members.
*/


class Sports_Car {
    private String brand;
    private String model;
    private boolean isEngineOn = false;
    private int currentSpeed;
    private int currentGear;
    private String tyreCompany;

    public Sports_Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.tyreCompany = "Bridgestone";
    }

    // Getters and Setters
    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    /* Now you may say that if we are giving both getter and setter to tyreCompany why not
    * declare it public, - BUT - in that case We can't check for validations as we are doing
    * here for setTyreCompany,i.e-> Accepting only MRF and CEAT tyres. */
    public String getTyreCompany() {
        return this.tyreCompany;
    }
    public void setTyreCompany(String tyreCompany) {
        if (tyreCompany.equals("MRF") || tyreCompany.equals("CEAT")) {
            this.tyreCompany = tyreCompany;
            System.out.println("Successfully set tyreCompany to " + tyreCompany);
        }
        else {
            this.tyreCompany = "Bridgestone Default";
            System.out.println("Only MRF or CEAT tyres allowed! Set tyreCompany to Default Bridgestone.");
        }
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }


    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot Cannot Shift Gear.");
            return;
        }
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }


    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }


    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }


    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}



public class encapsulation {
    public static void main(String[] args) {


        Sports_Car myCar = new Sports_Car("Ferrari", "Roma");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.brake();
        myCar.stopEngine();
        System.out.println("Current Speed of My Sports Car is " + myCar.getCurrentSpeed());
        System.out.println("Current Tyre Company of my car: " + myCar.getTyreCompany());
        myCar.setTyreCompany("Apollo");
        myCar.setTyreCompany("CEAT");
        System.out.println("Current Tyre Company of my car: " + myCar.getTyreCompany());
    }
}