package datastructures;

//making imoports
import model.Volunteer;

public class Stack {
    private StackNode top;

    public void push(String action, Volunteer volunteer) {
        StackNode newNode = new StackNode(action, volunteer);
        newNode.next = top;
        top = newNode;
    }

    public StackNode pop() {
        if (isEmpty()) return null;
        StackNode popped = top;
        top = top.next;
        return popped;
    }

    public StackNode peek() {
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
