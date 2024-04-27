import java.rmi.*;
// Remote interface
public interface Search extends Remote {
// Remote method declaration
public String query(String search) throws RemoteException;
}