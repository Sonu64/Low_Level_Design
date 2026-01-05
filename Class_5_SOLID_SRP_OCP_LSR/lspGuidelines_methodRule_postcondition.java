// A Postcondition must be satisfied after a method is executed.
// Subclasses can strengthen the Postcondition but cannot weaken it.

class Car {
    protected int speed;

    public Car() {
        speed = 0;
    }

    public void accelerate() {
        System.out.println("Accelerating");
        speed += 20;
    }

    // PostCondition: Speed must reduce after brake
    public void brake() {
        System.out.println("Applying brakes");
        speed -= 20;
    }
}

// Subclass can strengthen postcondition - Does not violate LSP
class HybridCar extends Car {
    private int charge;

    public HybridCar() {
        super();
        charge = 0;
    }

    // PostCondition: Speed must reduce after brake
    // PostCondition: Charge must increase.
    @Override
    public void brake() {
        System.out.println("Applying brakes");
        speed -= 20;
        charge += 10;
    }
}

public class lspGuidelines_methodRule_postcondition {
    public static void main(String[] args) {
        Car hybridCar = new HybridCar();
        Car normalCar = new Car();
        hybridCar.brake();  // Works fine: HybridCar reduces speed and also increases charge. 🔋
        normalCar.brake(); // Only reduces Speed 😃
    
          //Client feels no difference in substituting Hybrid car in place of Car.
    }
}
