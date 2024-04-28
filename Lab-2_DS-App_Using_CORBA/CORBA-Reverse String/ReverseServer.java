import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseServer {
	public static void main(String[] args) {
		try {
			// Initialize the ORB
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			// Initialize the BOA/POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();

			// Create the ReverseImpl object
			ReverseImpl rvr = new ReverseImpl();

			// Get the object reference from the servant class
			org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);

			System.out.println("Step1");

			// Narrow the object reference to Reverse interface
			Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);
			System.out.println("Step2");

			// Resolve the NameService object reference
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			System.out.println("Step3");

			// Narrow the NameService object reference to NamingContextExt
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			System.out.println("Step4");

			// Define the name and path for binding the Reverse object
			String name = "Reverse";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, h_ref);

			System.out.println("Reverse Server reading and waiting....");

			// Start the ORB event loop
			orb.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
