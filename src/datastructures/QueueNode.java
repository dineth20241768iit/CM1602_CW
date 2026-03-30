package datastructures;

//making imports
import model.Volunteer;

public class QueueNode {
    public Volunteer data;
    public QueueNode next;

    public QueueNode(Volunteer data) {
        this.data = data;
        this.next = null;
    }
}