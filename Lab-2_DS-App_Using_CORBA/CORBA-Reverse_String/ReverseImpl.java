import ReverseModule.ReversePOA; // Importing the ReversePOA class from the ReverseModule package
import java.lang.String; // Importing the String class from the java.lang package

class ReverseImpl extends ReversePOA { // Defining a class named ReverseImpl that extends ReversePOA

	ReverseImpl() { // Constructor for the ReverseImpl class
		super(); // Calling the constructor of the parent class
		System.out.println("Reverse Object Created"); // Printing a message to indicate that a Reverse object has been created
	}

	public String reverse_string(String name) { // Method to reverse a string
		StringBuffer str = new StringBuffer(name); // Creating a StringBuffer object with the given string
		str.reverse(); // Reversing the contents of the StringBuffer object
		return (("Server Send " + str)); // Returning the reversed string with a prefix
	}
}
