import java.rmi.*;

// Client application
public class ClientRequest {
    public static void main(String[] args) {
        try {
            // Look up the remote object from the Registry
            Search obj = (Search) Naming.lookup("rmi://localhost/search");
            // Invoke the remote method
            String result = obj.query("Java");
            // Display the result
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}