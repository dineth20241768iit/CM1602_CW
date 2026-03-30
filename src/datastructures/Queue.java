package datastructures;

//making imports
import model.Volunteer;

public class Queue {
    private QueueNode front;
    private QueueNode rear;

    public void enqueue(Volunteer v) {
        QueueNode newNode = new QueueNode(v);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    public Volunteer dequeue() {
        if (isEmpty()) return null;
        Volunteer v = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return v;
    }

    public Volunteer peek() {
        if (isEmpty()) return null;
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}