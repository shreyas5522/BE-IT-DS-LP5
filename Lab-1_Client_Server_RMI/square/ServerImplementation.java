import java.rmi.*;
import java.rmi.server.*;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	public ServerImplementation() throws RemoteException {}
	public double square(double num){
		double result = num * num;
		System.out.println("At Server: square(" + num + ") = " + result);
		return result;
	}
}
