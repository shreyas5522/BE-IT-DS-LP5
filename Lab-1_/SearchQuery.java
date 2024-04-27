import java.rmi.*;
import java.rmi.server.*;

// Implementation of the remote interface
public class SearchQuery extends UnicastRemoteObject implements Search {
    public SearchQuery() throws RemoteException {
        super();
    }

    // Implementation of the remote method
    public String query(String search) throws RemoteException {
        // Implement your search logic here
        // For simplicity, returning a fixed response
        if (search.equals("Java")) {
            return "Java is a programming language.";
        } else {
            return "No information found.";
        }
    }
}