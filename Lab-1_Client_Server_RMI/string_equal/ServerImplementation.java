import java.rmi.*;
import java.rmi.server.*;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	public ServerImplementation() throws RemoteException {}
	public boolean isEqual(String s1, String s2) {
		boolean result = s1.equals(s2);
		System.out.println("At Serer: isEqual(" + s1 + "," + s2 + ") = " + (result ? "Yes" : "No"));
		return result;
	}
}
