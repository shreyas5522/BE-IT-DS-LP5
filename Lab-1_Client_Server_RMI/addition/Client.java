import java.rmi.*;

public class Client {
	public static void main(String args[]){
		try {
			String rmiURL = "rmi://localhost/Server";
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(rmiURL);
			double num1 = Double.parseDouble(args[0]);
			double num2 = Double.parseDouble(args[1]);
			System.out.println("At Client: add(" + num1 + "," + num2 + ") = " + serverInterface.add(num1, num2));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
