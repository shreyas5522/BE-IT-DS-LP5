import ReverseModule.ReversePOA;

// Class definition for ReverseImpl, which extends ReversePOA
class ReverseImpl extends ReversePOA {
    
    // Constructor for ReverseImpl
    ReverseImpl() {
        super();
        System.out.println("Reverse Object Created");
    }

    // Method to reverse a string and convert it to uppercase
    public String reverse_string(String name) {
        return "Server Send " + name.toUpperCase();
    }
}
