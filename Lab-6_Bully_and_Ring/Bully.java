import java.util.Scanner;

public class Bully {
    int coordinator;
    int maxProcesses;
    boolean processes[];

    public Bully(int max) {
        maxProcesses = max;
        processes = new boolean[maxProcesses];
        coordinator = max;

        System.out.println("Creating processes...");
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("P" + (i + 1) + " created");
        }
        System.out.println("Process P" + coordinator + " is the coordinator");
    }

    void displayProcesses() {
        for (int i = 0; i < maxProcesses; i++) {
            if (processes[i]) {
                System.out.println("P" + (i + 1) + " is up");
            } else {
                System.out.println("P" + (i + 1) + " is down");
            }
        }
        System.out.println("Process P" + coordinator + " is the coordinator");
    }

    void upProcess(int processId) {
        if (!processes[processId - 1]) {
            processes[processId - 1] = true;
            System.out.println("Process " + processId + " is now up.");
        } else {
            System.out.println("Process " + processId + " is already up.");
        }
    }

    void downProcess(int processId) {
        if (!processes[processId - 1]) {
            System.out.println("Process " + processId + " is already down.");
        } else {
            processes[processId - 1] = false;
            System.out.println("Process " + processId + " is down.");
        }
    }

    void runElection(int processId) {
        coordinator = processId;
        boolean keepGoing = true;
        for (int i = processId; i < maxProcesses && keepGoing; i++) {
            System.out.println("Election message sent from process " +
                    processId + " to process " + (i + 1));
            if (processes[i]) {
                keepGoing = false;
                runElection(i + 1);
            }
        }
    }

    public static void main(String args[]) {
        Bully bully = null;
        int maxProcesses = 0, processId = 0;
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Bully Algorithm");
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
                    System.out.print("Enter the number of processes: ");
                    maxProcesses = sc.nextInt();
                    bully = new Bully(maxProcesses);
                    break;
                case 2:
                    bully.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter the process number to up: ");
                    processId = sc.nextInt();
                    bully.upProcess(processId);
                    break;
                case 4:
                    System.out.print("Enter the process number to down: ");
                    processId = sc.nextInt();
                    bully.downProcess(processId);
                    break;
                case 5:
                    System.out.print("Enter the process number which will perform election: ");
                    processId = sc.nextInt();
                    bully.runElection(processId);
                    bully.displayProcesses();
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
