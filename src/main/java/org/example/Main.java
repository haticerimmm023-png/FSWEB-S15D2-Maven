package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Website", "Login page", "ann", Status.IN_PROGRESS, Priority.HIGH);
        Task t2 = new Task("MobileApp", "Profile screen", "bob", Status.ASSIGNED, Priority.MED);
        Task t3 = new Task("CRM", "Bug fix", "carol", Status.IN_QUEUE, Priority.LOW);
        Task t4 = new Task("Website", "Login page", "bob", Status.ASSIGNED, Priority.HIGH);
        Task t5 = new Task("ERP", "Database setup", "", Status.IN_QUEUE, Priority.HIGH);

        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(t1);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(t2);
        bobsTasks.add(t4);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(t3);

        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(t5);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        System.out.println("Ann tasks: " + taskData.getTasks("ann"));
        System.out.println("Bob tasks: " + taskData.getTasks("bob"));
        System.out.println("Carol tasks: " + taskData.getTasks("carol"));
        System.out.println("All tasks: " + taskData.getTasks("all"));

        System.out.println("Union Ann + Bob: " + taskData.getUnion(annsTasks, bobsTasks));
        System.out.println("Intersection Ann + Bob: " + taskData.getIntersection(annsTasks, bobsTasks));
        System.out.println("Difference Bob - Ann: " + taskData.getDifferences(bobsTasks, annsTasks));
    }
}