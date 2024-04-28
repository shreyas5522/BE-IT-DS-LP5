import java.rmi.*;

public class Client {
	public static void main(String args[]){
		try {
			String rmiURL = "rmi://localhost/Server";
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(rmiURL);
			double num = Double.parseDouble(args[0]);
			System.out.println("At Client: sqrt(" + num + ") = " + serverInterface.sqrt(num));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}

