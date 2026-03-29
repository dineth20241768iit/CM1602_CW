import model.Volunteer;
import system.VolunteerCoordinationSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VolunteerCoordinationSystem system = new VolunteerCoordinationSystem();
        Scanner scanner = new Scanner(System.in);

        // Pre-load 10 volunteers
        system.addVolunteer(new Volunteer("V001", "Asel Perera", "Registration Desk", "high"));
        system.addVolunteer(new Volunteer("V002", "Dineth Rathnayake", "Crowd Control", "medium"));
        system.addVolunteer(new Volunteer("V003", "Kavindi Silva", "Logistics", "high"));
        system.addVolunteer(new Volunteer("V004", "Thisara Fernando", "First Aid", "high"));
        system.addVolunteer(new Volunteer("V005", "Senali Jayawardena", "Parking Management", "medium"));
        system.addVolunteer(new Volunteer("V006", "Ravindu Dissanayake", "Registration Desk", "low"));
        system.addVolunteer(new Volunteer("V007", "Imasha Wickramasinghe", "Crowd Control", "high"));
        system.addVolunteer(new Volunteer("V008", "Dulitha Bandara", "Logistics", "medium"));
        system.addVolunteer(new Volunteer("V009", "Thilini Madushanka", "First Aid", "low"));
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
            System.out.println("10. Assign by Priority");
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
                    System.out.print("Enter Task (Registration Desk / Crowd Control / Logistics / First Aid / Parking Management): ");
                    String task = scanner.nextLine();
                    System.out.print("Enter Priority (low / medium / high): ");
                    String priority = scanner.nextLine();
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
                    System.out.print("Enter Priority to view (low / medium / high): ");
                    String prio = scanner.nextLine();
                    system.viewByPriority(prio);
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

                //Added after changing the priority order
                case 10:
                System.out.println("Select Priority to assign:");
                System.out.println("1. High");
                System.out.println("2. Medium");
                System.out.println("3. Low");
                System.out.print("Enter choice: ");
                int assignPrio = scanner.nextInt();
                scanner.nextLine();
                switch (assignPrio) {
                    case 1: system.assignByPriority("high");   break;
                    case 2: system.assignByPriority("medium"); break;
                    case 3: system.assignByPriority("low");    break;
                    default: System.out.println("Invalid choice.");
                }
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