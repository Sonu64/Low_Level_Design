class Animal {
    // some Animal class code
    // public Animal() {
    //     System.out.println("Animal created here babe from Animal() class");
    // }
}

class Horse extends Animal {
    // some Horse class code
    // public Horse() {
    //     System.out.println("Horse created here babe from Horse() class");
    // }
}

class Parent {
    public Animal getNewAnimal() {
        System.out.println("Returning an Animal...");
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    public Animal getNewAnimal() {
        System.out.println("Returning an Horse...");
        return new Horse();
    }
}

class Client {
    private Parent parent;
    public Client(Parent p) {
        this.parent = p;
    }
    public void process() {
        parent.getNewAnimal();
    }
}


public class lspGuideLines_signatureRule_returnTypeRule {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent c = new Child();

        Client clientObjectFromParent = new Client(p);
        Client clientObjectFromChild = new Client(c);

        clientObjectFromParent.process();
        System.out.println();
        clientObjectFromChild.process();
    }
}