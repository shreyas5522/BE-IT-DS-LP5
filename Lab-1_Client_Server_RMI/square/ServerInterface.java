import java.rmi.*;

public interface ServerInterface extends Remote {
	double square(double num) throws RemoteException;
}
