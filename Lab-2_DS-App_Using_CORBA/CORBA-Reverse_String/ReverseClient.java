import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient {
	public static void main(String args[]) {
		Reverse ReverseImpl = null;
		try {
			// initialize the ORB
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			
			// resolve the initial reference to the NameService
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			
			// specify the name of the Reverse object
			String name = "Reverse";
			
			// narrow the reference to the Reverse object
			ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));
			
			// prompt the user to enter a string
			System.out.println("Enter String=");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			
			// call the reverse_string method of the Reverse object
			String tempStr = ReverseImpl.reverse_string(str);
			
			// print the reversed string
			System.out.println(tempStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}