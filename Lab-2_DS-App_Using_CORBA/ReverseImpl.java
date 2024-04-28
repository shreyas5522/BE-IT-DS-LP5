import ReverseModule.ReversePOA;

// Define the ReverseImpl class that extends ReversePOA
public class ReverseImpl extends ReversePOA {

    // Constructor for ReverseImpl class
    public ReverseImpl() {
        super(); // Call the constructor of the parent class (ReversePOA)
        System.out.println("Reverse Object Created"); // Print a message indicating object creation
    }

    // Method to reverse a given string
    public String reverse_string(String name) {
        StringBuffer str = new StringBuffer(name); // Create a StringBuffer from the input string
        str.reverse(); // Reverse the StringBuffer
        return "Server Send " + str.toString(); // Return the reversed string with a prefix
    }

}
