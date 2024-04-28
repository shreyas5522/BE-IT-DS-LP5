import java.rmi.*;
import java.rmi.server.*;
import java.lang.Math;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	public ServerImplementation() throws RemoteException {}
	public double sqrt(double num) {
		double result = Math.sqrt(num);
		System.out.println("At Server: sqrt(" + num + ") = " + result);
		return result;
	}
}
