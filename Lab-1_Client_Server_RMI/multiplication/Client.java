import java.rmi.*;

public class Client {
	public static void main(String args[]){
		try {
			String rmiURL = "rmi://localhost/Server";
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(rmiURL);
			double num1 = Double.parseDouble(args[0]);
			double num2 = Double.parseDouble(args[1]);
			double result = serverInterface.multi(num1, num2);
			System.out.println("At Client: multi(" + num1 + "," + num2 + ") = " + result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
