import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseServer {
    public static void main(String[] args) {
        try {
            // Step 1: Initialize the ORB (Object Request Broker)
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Step 2: Obtain the RootPOA (Portable Object Adapter)
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // Step 3: Create an instance of your implementation class (ReverseImpl)
            ReverseImpl rvr = new ReverseImpl();

            // Step 4: Convert the implementation object to a CORBA object reference
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);

            // Step 5: Narrow the CORBA object reference to your interface type (Reverse)
            Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);

            // Step 6: Obtain the Naming Service reference
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Step 7: Bind your CORBA object to a name in the Naming Service
            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);

            // Step 8: Print a message and start processing client requests
            System.out.println("Reverse Server reading and waiting....");
            orb.run();
        } catch (Exception e) {
            // Handle any exceptions that might occur
            e.printStackTrace();
        }
    }
}
