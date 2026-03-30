import model.Volunteer;
import system.VolunteerCoordinationSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VolunteerCoordinationSystem system = new VolunteerCoordinationSystem();
        Scanner scanner = new Scanner(System.in);

        // Pre-load 10 volunteers
        system.addVolunteer(new Volunteer("V001", "Asel Perera", "Registration Desk", "medium"));
        system.addVolunteer(new Volunteer("V002", "Dineth Rathnayake", "Crowd Control", "high"));
        system.addVolunteer(new Volunteer("V003", "Kavindi Silva", "Logistics", "medium"));
        system.addVolunteer(new Volunteer("V004", "Thisara Fernando", "First Aid", "high"));
        system.addVolunteer(new Volunteer("V005", "Senali Jayawardena", "Parking Management", "low"));
        system.addVolunteer(new Volunteer("V006", "Ravindu Dissanayake", "Registration Desk", "medium"));
        system.addVolunteer(new Volunteer("V007", "Imasha Wickramasinghe", "Crowd Control", "high"));
        system.addVolunteer(new Volunteer("V008", "Dulitha Bandara", "Logistics", "medium"));
        system.addVolunteer(new Volunteer("V009", "Thilini Madushanka", "First Aid", "high"));
        system.addVolunteer(new Volunteer("V010", "Sachith Gunasekara", "Parking Management", "low"));

        int choice;

        do {
            System.out.println("\n========== VOLUNTEER COORDINATION SYSTEM ==========");
            System.out.println("1. Add Volunteer");
            System.out.println("2. Remove Volunteer");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Assign Next Volunteer in Queue");
            System.out.println("6. View Volunteers by Priority");
            System.out.println("7. Undo Last Action");
            System.out.println("8. Display All Volunteers");
            System.out.println("9. Display Registration Queue");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Select Task:");
                    System.out.println("1. Registration Desk (medium)");
                    System.out.println("2. Crowd Control (high)");
                    System.out.println("3. Logistics (medium)");
                    System.out.println("4. First Aid (high)");
                    System.out.println("5. Parking Management (low)");
                    System.out.print("Enter task number: ");
                    int taskChoice = scanner.nextInt();
                    scanner.nextLine();

                    String task;
                    String priority;

                    switch (taskChoice) {
                        case 1: task = "Registration Desk"; priority = "medium"; break;
                        case 2: task = "Crowd Control";     priority = "high";   break;
                        case 3: task = "Logistics";         priority = "medium"; break;
                        case 4: task = "First Aid";         priority = "high";   break;
                        case 5: task = "Parking Management";priority = "low";    break;
                        default:
                            System.out.println("Invalid task. Volunteer not added.");
                            continue;
                    }

                    system.addVolunteer(new Volunteer(id, name, task, priority));
                    break;

                case 2:
                    System.out.print("Enter Volunteer ID to remove: ");
                    String removeId = scanner.nextLine();
                    system.removeVolunteer(removeId);
                    break;

                case 3:
                    System.out.print("Enter Volunteer ID to search: ");
                    String searchId = scanner.nextLine();
                    system.searchById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Volunteer Name to search: ");
                    String searchName = scanner.nextLine();
                    system.searchByName(searchName);
                    break;

                case 5:
                    system.assignNextVolunteer();
                    break;

                case 6:
                    System.out.println("Select Priority:");
                    System.out.println("1. High");
                    System.out.println("2. Medium");
                    System.out.println("3. Low");
                    System.out.print("Enter choice: ");
                    int prioChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (prioChoice) {
                        case 1: system.viewByPriority("high");   break;
                        case 2: system.viewByPriority("medium"); break;
                        case 3: system.viewByPriority("low");    break;
                        default: System.out.println("Invalid choice.");
                    }
                    break;

                case 7:
                    system.undoLastAction();
                    break;

                case 8:
                    system.displayAllVolunteers();
                    break;

                case 9:
                    system.displayQueue();
                    break;

                case 0:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}