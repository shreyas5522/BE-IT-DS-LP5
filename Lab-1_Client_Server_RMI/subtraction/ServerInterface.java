import java.rmi.*;

public interface ServerInterface extends Remote {
	double sub(double num1, double num2) throws RemoteException;
}
