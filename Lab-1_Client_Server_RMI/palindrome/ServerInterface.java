import java.rmi.*;

public interface ServerInterface extends Remote {
	boolean palindrome(String s) throws RemoteException;
}
