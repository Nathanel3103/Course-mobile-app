package com.example.courses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView branchesListView; // class declarations
    private List<EngineeringBranch> branches; // class declarations

    @Override
    protected void onCreate(Bundle savedInstanceState) { // connecting activity to layout
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        branchesListView = findViewById(R.id.branchesListView); //ListView Initialization and finds the list in the layout, populating data
        initializeBranches();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getBranchNames()
        );
        branchesListView.setAdapter(adapter);

        branchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showBranchDetails(position);
            }
        });
    }

    private void initializeBranches() {
        branches = new ArrayList<>();

        // Software Engineering
        HashMap<Integer, List<String>> csSubjects = new HashMap<>();
        csSubjects.put(1, Arrays.asList("Programming Fundamentals", "Discrete Mathematics", "Technopreneurship",
                                        "Technical Communications", "Operating System","Digital electronics","Analogue Electronics"));
        csSubjects.put(2, Arrays.asList("Visual Programming", "Probability & Statistics", "Database System",
                                       "Data Structures", "Technopreneurship II"));
        csSubjects.put(3, Arrays.asList("Data Structures", "Web technologies", "Discrete Mathematics",
                                       "Object-Oriented Programming ", "Technopreneurship III","Software Project Management"));
        csSubjects.put(4, Arrays.asList("Requirements Engineering", "Mobile App dev", "Software Architecture and design",
                                       "Computer Networks", "Theory of Automata"));
        csSubjects.put(5, Arrays.asList("Industrial Training or in house training"));
        csSubjects.put(6, Arrays.asList("Industrial Training or in house training II"));
        csSubjects.put(7, Arrays.asList("Machine Learning", "Cloud Computing",
                                       "Data Mining", "Final Year Project I", "Technical Elective I"));
        csSubjects.put(8, Arrays.asList("Big Data Analytics", "Final Year Project II",
                                       "Technical Elective II", "Technical Elective III", "Professional Practices"));

        EngineeringBranch cs = new EngineeringBranch("Software Engineering", 8, csSubjects);
        branches.add(cs); // adds software engineering to th list view

        // Mechanical Engineering
        HashMap<Integer, List<String>> mechSubjects = new HashMap<>();
        mechSubjects.put(1, Arrays.asList("Engineering Drawing", "Calculus I", "Physics I",
                                         "English Composition", "Chemistry"));
        mechSubjects.put(2, Arrays.asList("Thermodynamics I", "Calculus II", "Physics II",
                                         "Technical Writing", "Engineering Materials"));
        mechSubjects.put(3, Arrays.asList("Mechanics of Materials", "Differential Equations", "Engineering Statics",
                                         "Manufacturing Processes", "Electrical Engineering Fundamentals"));
        mechSubjects.put(4, Arrays.asList("Fluid Mechanics", "Dynamics", "Machine Design I",
                                         "Instrumentation & Measurement", "Numerical Methods"));
        mechSubjects.put(5, Arrays.asList("Heat Transfer", "Thermodynamics II", "Machine Design II",
                                         "Control Systems", "Mechanical Vibrations"));
        mechSubjects.put(6, Arrays.asList("Industrial training"));
        mechSubjects.put(7, Arrays.asList("Robotics & Automation", "Computational Fluid Dynamics",
                                         "Industrial Engineering", "Final Year Project I", "Technical Elective I"));
        mechSubjects.put(8, Arrays.asList("Advanced Manufacturing Systems", "Final Year Project II",
                                         "Technical Elective II", "Technical Elective III", "Professional Ethics"));

        EngineeringBranch mech = new EngineeringBranch("Mechanical Engineering", 8, mechSubjects);
        branches.add(mech);

        // Civil Engineering
        HashMap<Integer, List<String>> civilSubjects = new HashMap<>();
        civilSubjects.put(1, Arrays.asList("Engineering Drawing", "Calculus I", "Physics I",
                                           "English Composition", "Surveying I"));
        civilSubjects.put(2, Arrays.asList("Mechanics of Materials", "Calculus II", "Technical Writing",
                                           "Surveying II", "Construction Materials"));
        civilSubjects.put(3, Arrays.asList("Structural Analysis I", "Differential Equations", "Soil Mechanics",
                                          "Fluid Mechanics", "Engineering Geology"));
        civilSubjects.put(4, Arrays.asList("Structural Analysis II", "Reinforced Concrete Design I",
                                          "Highway Engineering", "Hydraulics", "Environmental Engineering"));
        civilSubjects.put(5, Arrays.asList("Steel Structures", "Reinforced Concrete Design II",
                                          "Transportation Engineering", "Water Resources Engineering", "Foundation Engineering"));
        civilSubjects.put(6, Arrays.asList("Construction Management", "Hydrology",
                                          "Earthquake Engineering", "Environmental Impact Assessment", "Engineering Economics"));
        civilSubjects.put(7, Arrays.asList("Bridge Engineering", "Geotechnical Engineering",
                                          "Urban Planning", "Final Year Project I", "Technical Elective I"));
        civilSubjects.put(8, Arrays.asList("Advanced Structural Design", "Final Year Project II",
                                          "Technical Elective II", "Technical Elective III", "Professional Ethics"));

        EngineeringBranch civil = new EngineeringBranch("Civil Engineering", 8, civilSubjects);
        branches.add(civil);

        // Electrical Engineering
        HashMap<Integer, List<String>> eeSubjects = new HashMap<>();
        eeSubjects.put(1, Arrays.asList("Basic Electrical Engineering", "Calculus I", "Physics I",
                                          "English Composition", "Programming Fundamentals"));
        eeSubjects.put(2, Arrays.asList("Circuit Theory", "Calculus II", "Physics II",
                                       "Digital Logic Design", "Technical Writing"));
        eeSubjects.put(3, Arrays.asList("Electronics I", "Linear Algebra", "Signals & Systems",
                                       "Electromagnetic Theory", "Probability & Statistics"));
        eeSubjects.put(4, Arrays.asList("Electronics II", "Electrical Machines", "Communication Systems",
                                       "Digital Signal Processing", "Control Systems"));
        eeSubjects.put(5, Arrays.asList("Power Electronics", "Power Systems I",
                                       "Microprocessors & Microcontrollers", "Instrumentation & Measurement", "Numerical Methods"));
        eeSubjects.put(6, Arrays.asList("Power Systems II", "Embedded Systems",
                                       "Digital Communications", "Renewable Energy Systems", "Engineering Economics"));
        eeSubjects.put(7, Arrays.asList("High Voltage Engineering", "Computer Networks",
                                       "Wireless Communications", "Final Year Project I", "Technical Elective I"));
        eeSubjects.put(8, Arrays.asList("Power System Protection", "Final Year Project II",
                                       "Technical Elective II", "Technical Elective III", "Professional Ethics"));

        EngineeringBranch ee = new EngineeringBranch("Electrical Engineering", 8, eeSubjects);
        branches.add(ee);
    }

    private List<String> getBranchNames() {
        List<String> branchNames = new ArrayList<>();
        for (EngineeringBranch branch : branches) {
            branchNames.add(branch.getName());
        }
        return branchNames;
    }

    private void showBranchDetails(int position) {
        EngineeringBranch selectedBranch = branches.get(position); // gets the selected branch by its position on the list when use clicks it

        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(CourseDetailActivity.EXTRA_BRANCH_NAME, selectedBranch.getName());
        intent.putExtra(CourseDetailActivity.EXTRA_SEMESTERS_COUNT, selectedBranch.getSemesters());
        intent.putExtra(CourseDetailActivity.EXTRA_SUBJECTS, selectedBranch.getSemesterSubjects());

        startActivity(intent);
    }
}