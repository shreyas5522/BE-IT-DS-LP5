import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			String rmiURL = "rmi://localhost/Server";
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(rmiURL);
			String s1 = args[0];
			String s2 = args[1];
			boolean result = serverInterface.isEqual(s1, s2);
			System.out.println("At Client: isEqual(" + s1 + "," + s2 + ") = " + (result ? "Yes" : "No"));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
