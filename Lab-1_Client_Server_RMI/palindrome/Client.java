import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			String rmiURL = "rmi://localhost/Server";
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(rmiURL);
			String s = args[0];
			boolean isPalindrome = serverInterface.palindrome(s);
			String result = isPalindrome ? "Yes" : "No";
			System.out.println("At Client: palindrome(" + s + ") = " + result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
