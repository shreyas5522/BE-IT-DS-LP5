import java.rmi.*;
import java.rmi.server.*;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
	public ServerImplementation() throws RemoteException {}
	public boolean palindrome(String s) {
		int length = s.length();
		// Iterate through the string form both ends
		for (int i = 0; i < (length / 2); i++) {
			// Compare characters from oposite ends
			if (s.charAt(i) != s.charAt(length - i - 1)) {
				System.out.println("At Server: palindrome(" + s + ") = No");
				return false; // If characters don't match, it's not palindrome
			}
		}
		// If we reach here, the string is a palindrome
		System.out.println("At Server: palindrome(" + s + ") = Yes");
		return true;
	}
}
