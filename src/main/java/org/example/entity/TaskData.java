package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        if (name.equalsIgnoreCase("ann")) {
            return annsTasks;
        } else if (name.equalsIgnoreCase("bob")) {
            return bobsTasks;
        } else if (name.equalsIgnoreCase("carol")) {
            return carolsTasks;
        } else if (name.equalsIgnoreCase("all")) {
            Set<Task> allTasks = new HashSet<>();
            allTasks.addAll(annsTasks);
            allTasks.addAll(bobsTasks);
            allTasks.addAll(carolsTasks);
            allTasks.addAll(unassignedTasks);
            return allTasks;
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task> first, Set<Task> second) {
        Set<Task> unionSet = new HashSet<>(first);
        unionSet.addAll(second);
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersectionSet = new HashSet<>(first);
        intersectionSet.retainAll(second);
        return intersectionSet;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> differenceSet = new HashSet<>(first);
        differenceSet.removeAll(second);
        return differenceSet;
    }
}