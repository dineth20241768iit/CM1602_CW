package datastructures;

import model.Volunteer;

public class LinkedList {
    private Node head;

    public void add(Volunteer v) {
        Node newNode = new Node(v);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean remove(String volunteerId) {
        if (head == null) return false;
        if (head.data.volunteerID.equals(volunteerId)) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.volunteerID.equals(volunteerId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Volunteer searchById(String volunteerId) {
        Node current = head;
        while (current != null) {
            if (current.data.volunteerID.equals(volunteerId)) return current.data;
            current = current.next;
        }
        return null;
    }

    public Volunteer searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.data.name.equalsIgnoreCase(name)) return current.data;
            current = current.next;
        }
        return null;
    }

    public void displayByPriority(String priority) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.data.priorityLevel.equalsIgnoreCase(priority)) {
                System.out.println(current.data);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No volunteers with " + priority + " priority.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No volunteers registered.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    //added later to change the task assignment priority
    public Node getHead() {
    return head;
}
}