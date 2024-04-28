import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient {
    public static void main(String args[]) {
        Reverse ReverseImpl = null;
        try {
            // Initialize the ORB (Object Request Broker)
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Resolve the initial reference to the NameService
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Specify the name of the Reverse object
            String name = "Reverse";

            // Narrow the reference to the Reverse object
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            // Prompt the user to enter a string
            System.out.println("Enter String=");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            // Call the reverse_string method on the Reverse object
            String tempStr = ReverseImpl.reverse_string(str);

            // Print the reversed string
            System.out.println(tempStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
