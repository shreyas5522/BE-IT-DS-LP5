// Importing necessary modules and packages
import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

// Defining the ReverseServer class
class ReverseServer {

    // Main method
    public static void main(String[] args) {

        try {
            // Initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Initialize the POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // Creating the ReverseImpl object
            ReverseImpl rvr = new ReverseImpl();

            // Get the object reference from the servant class
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);

            // Narrowing the object reference to Reverse interface
            Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);

            // Resolve the initial reference for NameService
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Define the name and path for binding
            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);

            // Rebind the object reference to the NameService
            ncRef.rebind(path, h_ref);

            // Inform that the server is running and waiting for requests
            System.out.println("Reverse Server reading and waiting....");

            // Start processing requests by the ORB
            orb.run();
        } catch (Exception e) {
            // Print stack trace in case of exception
            e.printStackTrace();
        }
    }
}
