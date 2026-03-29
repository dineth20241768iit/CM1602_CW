package system;

import datastructures.*;
import model.Volunteer;

public class VolunteerCoordinationSystem {
    private LinkedList volunteers;
    private Queue registrationQueue;
    private Stack actionStack;

    public VolunteerCoordinationSystem() {
        volunteers = new LinkedList();
        registrationQueue = new Queue();
        actionStack = new Stack();
    }
    //Added later to change priority for
    public void assignByPriority(String priority) {
    Node current = volunteers.getHead();
    while (current != null) {
        if (current.data.priorityLevel.equalsIgnoreCase(priority) && !current.data.assigned) {
            current.data.assigned = true;
            actionStack.push("ASSIGN", current.data);
            System.out.println("Priority assigned: " + current.data);
            return;
        }
        current = current.next;
    }
    System.out.println("No unassigned volunteers with " + priority + " priority.");
    }

    public void addVolunteer(Volunteer v) {
        volunteers.add(v);
        registrationQueue.enqueue(v);
        actionStack.push("ADD", v);
        System.out.println("Volunteer added: " + v);
    }

    public void removeVolunteer(String volunteerId) {
        Volunteer v = volunteers.searchById(volunteerId);
        if (v == null) {
            System.out.println("Volunteer not found: " + volunteerId);
            return;
        }
        volunteers.remove(volunteerId);
        actionStack.push("REMOVE", v);
        System.out.println("Volunteer removed: " + v);
    }

    public void searchById(String volunteerId) {
        Volunteer v = volunteers.searchById(volunteerId);
        if (v == null) {
            System.out.println("No volunteer found with ID: " + volunteerId);
        } else {
            System.out.println("Found: " + v);
        }
    }

    public void searchByName(String name) {
        Volunteer v = volunteers.searchByName(name);
        if (v == null) {
            System.out.println("No volunteer found with name: " + name);
        } else {
            System.out.println("Found: " + v);
        }
    }

    public void assignNextVolunteer() {
        Volunteer v = registrationQueue.dequeue();
        if (v == null) {
            System.out.println("No volunteers in queue.");
            return;
        }
        v.assigned = true;
        actionStack.push("ASSIGN", v);
        System.out.println("Assigned: " + v);
    }

    public void viewByPriority(String priority) {
        System.out.println("\n--- " + priority.toUpperCase() + " priority volunteers ---");
        volunteers.displayByPriority(priority);
    }

    public void undoLastAction() {
        StackNode last = actionStack.pop();
        if (last == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        switch (last.action) {
            case "ADD":
                volunteers.remove(last.volunteer.volunteerID);
                System.out.println("Undo ADD: removed " + last.volunteer.name);
                break;
            case "REMOVE":
                volunteers.add(last.volunteer);
                System.out.println("Undo REMOVE: restored " + last.volunteer.name);
                break;
            case "ASSIGN":
                last.volunteer.assigned = false;
                System.out.println("Undo ASSIGN: unassigned " + last.volunteer.name);
                break;
        }
    }

    public void displayAllVolunteers() {
        System.out.println("\n--- All Volunteers ---");
        volunteers.displayAll();
    }

    public void displayQueue() {
        System.out.println("\n--- Registration Queue ---");
        registrationQueue.displayQueue();
    }
}