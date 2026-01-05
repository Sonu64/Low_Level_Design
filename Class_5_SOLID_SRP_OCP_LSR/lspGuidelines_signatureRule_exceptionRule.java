// Exception Rule:
// A subclass should throw fewer or narrower exceptions 
// (but not additional or broader exceptions) than the parent.
// Java enforces this only for checked Exceptions.

/* 
└── java.lang.Exception                        // Conditions your application might want to catch
    ├── java.io.IOException                    // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
    ├── java.lang.InterruptedException         // Checked thread interruption
    ├── java.sql.SQLException                  // Checked SQL/database errors
    ├── java.text.ParseException               // Checked parsing errors
    └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException      // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException // parent of the two “…OutOfBounds” above
*/

class Parent {
    public void doSomething() {
        throw new RuntimeException("A Generic Runtime Exception thrown by Parent class !");
    }
}

class Child extends Parent {
    public void doSomething() {
        throw new ArrayIndexOutOfBoundsException("Array index out of bounds exception thrown by Child Class, allowed because it is narrower exception than RuntimeException");
        // throw new InterruptedException("Interrupted Excepition not allowed because it is not a narrower exception type of RuntimeException. It is in the same hierarchial level !"); // ❗❗❗ ERROR ❗❗❗
    }
}

class Client {
    private Parent p;
    public Client(Parent p) { 
        this.p = p;
    }
    public void process() {
        try {
            p.doSomething();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}


public class lspGuidelines_signatureRule_exceptionRule {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent c = new Child();

        Client clientObjectFromParent = new Client(p);
        Client clientObjectFromChild = new Client(c);

        clientObjectFromParent.process();
        clientObjectFromChild.process();
    }
}
