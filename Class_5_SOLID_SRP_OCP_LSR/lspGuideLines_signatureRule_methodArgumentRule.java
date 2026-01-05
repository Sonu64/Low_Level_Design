// Parent Class
class MessagePrinter {
    public void printMsg(String msg) {
        System.out.println("Message from Parent -> " + msg);
    }
}

// Child Class
class NotificationPrinter extends MessagePrinter {
    public void printMsg(String msg) {
        System.out.println("Message from Child -> " + msg);
    }
}

// Client Class
class Client {
    private MessagePrinter printerObj;
    public Client (MessagePrinter p) {
        this.printerObj = p;
    }
    public void clientPrint(String msg) {
        printerObj.printMsg(msg);
    }
}

public class lspGuideLines_signatureRule_methodArgumentRule {
    public static void main(String[] args) {
        MessagePrinter p = new MessagePrinter();
        MessagePrinter np = new NotificationPrinter();

        Client clientObject1 = new Client(np);
        Client clientObject2 = new Client(p);
        clientObject1.clientPrint("A Message printed from Client : ");
        clientObject2.clientPrint("Message printed from Client : ");
    }
}
