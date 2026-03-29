package datastructures;
//making imports
import model.Volunteer;

public class Node {
    public Volunteer data;
    public Node next;

    public Node(Volunteer data) {
        this.data = data;
        this.next = null;
    }
}
