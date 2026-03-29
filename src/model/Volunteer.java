package model;

public class Volunteer {
    public String volunteerID;
    public String name;
    public String taskAssigned;
    public String priorityLevel; // could be either one of "High" , "Medium", "Low"
    public boolean assigned;

    public Volunteer(String volunteerID, String name, String taskAssigned, String priorityLevel) {
        this.volunteerID = volunteerID;
        this.name = name;
        this.taskAssigned = taskAssigned;
        this.priorityLevel = priorityLevel;
        this.assigned = false;
    }
    // Modified the string representation of the object to be more readable.
    public String toString(){
        return"["+volunteerID+"]"+name+" | Task: "+taskAssigned+" | Priority: "+priorityLevel+" |  Assigned: "+assigned;
    }
}
