import java.util.InputMismatchException;
import java.util.Scanner;

public class TokenRing {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = scan.nextInt();  // Number of nodes
        int token = 0;
        int ch = 0, flag = 0;
        
        // Outer loop to handle multiple token passing cycles
        do {
            System.out.println("Enter sender:");
            int s = scan.nextInt();  // Sender node
            System.out.println("Enter receiver:");
            int r = scan.nextInt();  // Receiver node
            System.out.println("Enter Data:");
            int a = scan.nextInt();  // Data to be sent
            
            System.out.print("Token passing:");
            
            // Display the path of token passing from sender to receiver
            for (int i = token, j = token; (i % n) != s; i++, j = (j + 1) % n) {
                System.out.print(" " + j + "->");
            }
            System.out.println(" " + s);
            
            // Display sender node sending data to the receiver
            System.out.println("Sender " + s + " sending data: " + a);
            
            // Display forwarding of data from sender to receiver through intermediate nodes
            for (int i = s + 1; i != r; i = (i + 1) % n) {
                System.out.println("Data " + a + " forwarded by " + i);
            }
            
            // Display receiver node receiving the data
            System.out.println("Receiver " + r + " received data: " + a + "\n");
            
            // Update the token position to the sender node
            token = s;
            
            // Loop to handle user input for sending data again
            do {
                try {
                    if (flag == 1)
                        System.out.print("Invalid Input!!...");
                    
                    System.out.print("Do you want to send again? Enter 1 for Yes and 0 for No: ");
                    ch = scan.nextInt();
                    
                    if (ch != 1 && ch != 0)
                        flag = 1;
                    else
                        flag = 0;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                    scan.next();  // Clear the invalid input
                }
            } while (ch != 1 && ch != 0);
            
        } while (ch == 1);  // Repeat the process if user chooses to send again
        
        scan.close();  // Close the scanner
    }
}
