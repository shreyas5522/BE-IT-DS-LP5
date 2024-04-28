import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseServer {
    public static void main(String[] args) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Initialize the POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // Create the ReverseImpl object
            ReverseImpl rvr = new ReverseImpl();

            // Get the object reference from the servant class
            Object ref = rootPOA.servant_to_reference(rvr);
            Reverse h_ref = ReverseHelper.narrow(ref);

            // Resolve the NameService
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the object reference to the Naming Service
            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);

            System.out.println("Reverse Server ready and waiting...");
            
            // Start processing CORBA requests
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
