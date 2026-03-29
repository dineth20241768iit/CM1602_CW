package datastructures;

import model.Volunteer;

public class StackNode {
    public String action;
    public Volunteer volunteer;
    public StackNode next;

    public StackNode(String action, Volunteer volunteer) {
        this.action = action;
        this.volunteer = volunteer;
        this.next = null;
    }
}
