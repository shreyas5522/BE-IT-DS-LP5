import java.rmi.*;
import java.rmi.registry.*;

public class SearchServer {
    public static void main(String[] args) {
        try {
            // Start the RMI Registry on port 1099
            LocateRegistry.createRegistry(1099);
            // Create an instance of the implementation class
            Search obj = new SearchQuery();
            // Bind the remote object to the Registry
            Naming.rebind("search", obj);
            System.out.println("Server started.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}