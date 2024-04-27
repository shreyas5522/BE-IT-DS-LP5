import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient {

    public static void main(String args[]) {
        Reverse ReverseImpl = null; // Declare a variable to hold the Reverse object

        try {
            // Initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Resolve the NameService
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Get the Reverse object reference from the Naming Service
            String name = "Reverse";
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            // Prompt user to enter a string
            System.out.println("Enter String:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            // Invoke the reverse_string method on the server
            String tempStr = ReverseImpl.reverse_string(str);

            // Display the reversed string received from the server
            System.out.println(tempStr);

        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an exception
        }
    }
}
