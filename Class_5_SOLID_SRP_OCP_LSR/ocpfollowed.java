import java.util.ArrayList;
import java.util.List;
class Product {
  private String name;
  private float price;
  public Product(String name, float price) {
    this.name = name;
    this.price = price;
  }
  public String getName() {
    return this.name;
  }
  public float getPrice() {
    return this.price;
  }
}

class shoppingCart {
  private List < Product > products = new ArrayList < > ();
  public void addProduct(Product p) {
    products.add(p);
  }
  public List < Product > getProducts() {
    return this.products;
  }
  public float calculateTotal() {
    float total = 0;
    for (Product product: products) {
      total += product.getPrice();
    }
    return total;
  }
}

class invoicePrinter {
  private shoppingCart cart;
  public invoicePrinter(shoppingCart cart) {
    this.cart = cart;
  }
  public void printInvoice() {
    System.out.println("\n\n------------------------------ Invoice ------------------------------\n");
    System.out.println("Item Name\t\t\t\t\t\t\t\tItem Price");
    for (Product product: cart.getProducts()) {
      System.out.print(product.getName() + "\t\t" + product.getPrice());
      System.out.println();
    }
  }
}

interface saveToDB {
  public void save(shoppingCart cart);
}

class saveToSQL implements saveToDB {
  // No constructors built here, but the method .save() needs a shoppingCart Object
  @Override
  public void save(shoppingCart cart) {
    System.out.println("Saving to SQL Database...");
  }
}

class saveToMongo implements saveToDB {
  @Override
  public void save(shoppingCart cart) {
    System.out.println("Saving to MongoDB Database...");
  }
}

class saveToPostgreSQL implements saveToDB {
  @Override
  public void save(shoppingCart cart) {
    System.out.println("Saving to PostgreSQL Database...");
  }
}

public class ocpfollowed {

  public static void main(String[] args) {
    // Creating some Products
    Product p1 = new Product("Computer Vision for Robotics, 3rd Ed.", 1500);
    Product p2 = new Product("Full-Stack Python Development, 1st Ed.", 1000);
    // Creating Empty Cart and Printing Invoice
    shoppingCart myCart = new shoppingCart();
    invoicePrinter myInvoicePrinter = new invoicePrinter(myCart);
    saveToDB myPostgresDBsaver = new saveToPostgreSQL();
    saveToDB mySQLDBsaver = new saveToSQL();
    saveToDB myMongoDBsaver = new saveToMongo();
    myInvoicePrinter.printInvoice();
    myCart.addProduct(p1);
    myCart.addProduct(p2);
    myInvoicePrinter.printInvoice();
    // Saving to different databases
    mySQLDBsaver.save(myCart);
    myPostgresDBsaver.save(myCart);
    myMongoDBsaver.save(myCart);
  }
}