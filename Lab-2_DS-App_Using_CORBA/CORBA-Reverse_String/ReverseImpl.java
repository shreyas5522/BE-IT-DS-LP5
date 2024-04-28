import ReverseModule.ReversePOA;
import java.lang.String;

// ReverseImpl class that extends ReversePOA
class ReverseImpl extends ReversePOA {

	// Constructor for ReverseImpl class
	ReverseImpl() {
		super();
		System.out.println("Reverse Object Created");
	}

	// Method to reverse a string
	public String reverse_string(String name) {
		// Create a StringBuffer object with the given string
		StringBuffer str = new StringBuffer(name);

		// Reverse the string using the reverse() method of StringBuffer
		str.reverse();

		// Return the reversed string with a prefix
		return (("Server Send " + str));
	}
}
