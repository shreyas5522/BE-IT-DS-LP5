import java.rmi.*;

public interface ServerInterface extends Remote {
	double sqrt(double num) throws RemoteException;
}
