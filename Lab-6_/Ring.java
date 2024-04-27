import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Ring {
    int maxProcesses;
    int coordinator;
    boolean processes[];
    ArrayList<Integer> pid;
    
    public Ring(int max) {
        coordinator = max;
        maxProcesses = max;
        pid = new ArrayList<Integer>();
        processes = new boolean[max];
        
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("P" + (i + 1) + " created.");
        }
        System.out.println("P" + coordinator + " is the coordinator");
    }
    
    void displayProcesses() {
        for (int i = 0; i < maxProcesses; i++) {
            if (processes[i])
                System.out.println("P" + (i + 1) + " is up.");
            else
                System.out.println("P" + (i + 1) + " is down.");
        }
        System.out.println("P" + coordinator + " is the coordinator");
    }
    
    void upProcess(int processId) {
        if (!processes[processId - 1]) {
            processes[processId - 1] = true;
            System.out.println("Process P" + processId + " is up.");
        } else {
            System.out.println("Process P" + processId + " is already up.");
        }
    }
    
    void downProcess(int processId) {
        if (!processes[processId - 1]) {
            System.out.println("Process P" + processId + " is already down.");
        } else {
            processes[processId - 1] = false;
            System.out.println("Process P" + processId + " is down.");
        }
    }
    
    void displayArrayList(ArrayList<Integer> pid) {
        System.out.print("[ ");
        for (Integer x : pid) {
            System.out.print(x + " ");
        }
        System.out.print(" ]\n");
    }
    
    void initElection(int processId) {
        if (processes[processId - 1]) {
            pid.add(processId);
            int temp = processId;
            System.out.print("Process P" + processId + " sending the following list:- ");
            displayArrayList(pid);
            while (temp != processId - 1) {
                if (processes[temp]) {
                    pid.add(temp + 1);
                    System.out.print("Process P" + (temp + 1) + " sending the following list:- ");
                    displayArrayList(pid);
                }
                temp = (temp + 1) % maxProcesses;
            }
            coordinator = Collections.max(pid);
            System.out.println("Process P" + processId + " has declared P" + coordinator + " as the coordinator");
            pid.clear();
        }
    }
    
    public static void main(String args[]) {
        Ring ring = null;
        int maxProcesses = 0, processId = 0;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Ring Algorithm");
            System.out.println("1. Create processes");
            System.out.println("2. Display processes");
            System.out.println("3. Up a process");
            System.out.println("4. Down a process");
            System.out.println("5. Run election algorithm");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the total number of processes: ");
                    maxProcesses = sc.nextInt();
                    ring = new Ring(maxProcesses);
                    break;
                case 2:
                    ring.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter the process to up: ");
                    processId = sc.nextInt();
                    ring.upProcess(processId);
                    break;
                case 4:
                    System.out.print("Enter the process to down: ");
                    processId = sc.nextInt();
                    ring.downProcess(processId);
                    break;
                case 5:
                    System.out.print("Enter the process which will initiate election: ");
                    processId = sc.nextInt();
                    ring.initElection(processId);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error in choice. Please try again.");
                    break;
            }
        }
    }
}
