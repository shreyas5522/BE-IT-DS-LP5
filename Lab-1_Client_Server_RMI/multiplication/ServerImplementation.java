import java.rmi.*;
import java.rmi.server.*;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	public ServerImplementation() throws RemoteException {}
	public double multi(double num1, double num2) {
		double result = num1 * num2;
		System.out.println("At Server: multi(" + num1 + "," + num2 + ") = " + result);
		return result;
	}
}
