package com.example.courses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EngineeringBranch implements Serializable {
    private String name;
    private int semesters;
    private List<String> subjects; // Legacy field for backward compatibility
    private HashMap<Integer, List<String>> semesterSubjects; // New field for semester-wise subjects

    // Legacy constructor
    public EngineeringBranch(String name, int semesters, List<String> subjects) {
        this.name = name;
        this.semesters = semesters;
        this.subjects = subjects;
        this.semesterSubjects = new HashMap<>();
    }

    // New constructor with semester-wise subjects
    public EngineeringBranch(String name, int semesters, HashMap<Integer, List<String>> semesterSubjects) {
        this.name = name;
        this.semesters = semesters;
        this.semesterSubjects = semesterSubjects;
    }

    public String getName() {
        return name;
    }

    public int getSemesters() {
        return semesters;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public HashMap<Integer, List<String>> getSemesterSubjects() {
        return semesterSubjects;
    }

    public void addSemesterSubjects(int semester, List<String> subjects) {
        semesterSubjects.put(semester, subjects);
    }
}