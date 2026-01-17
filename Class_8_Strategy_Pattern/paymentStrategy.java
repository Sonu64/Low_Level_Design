// Strategy to Pay interface
interface paymentSystem {
    public void pay(int amount);
}

// Concrete classes implementing the interface
class creditCardPayment implements paymentSystem {
    protected int cardNumber;

    public creditCardPayment(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void pay(int amount) {
        System.out.printf("Paying Rs.%d through Credit Card. Card Number is: %d\n", amount, cardNumber);
        // More Logic for Credit Card payment...Connecting to Bank API, etc...
    }
}

class payPalPayment implements paymentSystem {
    protected String email;

    public payPalPayment(String email) {
        this.email = email;
    }
    public void pay(int amount) {
        System.out.println("Paying Rs." + amount + " through PayPal. E-Mail ID: " + email + ".");
        // More Logic for payPal Payments....connecting to payPal API..etc.
    }
}

class shoppingCart {
    protected paymentSystem paySystem;
    protected int amount;

    public shoppingCart(paymentSystem pS, int amount) {
        this.paySystem = pS;
        this.amount = amount;
    }
    public void pay() {
        paySystem.pay(amount);
    }
    public void setPaymentSystem(paymentSystem pS) {
        this.paySystem = pS;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}


public class paymentStrategy {
    public static void main(String[] args) {
        shoppingCart myCart = new shoppingCart(new creditCardPayment(12489), 240);
        myCart.pay();
        myCart.setPaymentSystem(new payPalPayment("sampleEmail@gmail.com"));
        myCart.setAmount(4500);
        myCart.pay();
    }
}
