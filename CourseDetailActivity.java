package com.example.courses;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDetailActivity extends AppCompatActivity {
//  constants for used intent
    public static final String EXTRA_BRANCH_NAME = "extra_branch_name";
    public static final String EXTRA_SEMESTERS_COUNT = "extra_semesters_count";
    public static final String EXTRA_SUBJECTS = "extra_subjects";

    //UI of lists
    private TextView branchNameTextView;
    private TextView semestersCountTextView;
    private LinearLayout semestersContainer;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_detail);

        // Initialize views
        branchNameTextView = findViewById(R.id.branch_name);
        semestersCountTextView = findViewById(R.id.semesters_count);
        semestersContainer = findViewById(R.id.semesters_container);
        backButton = findViewById(R.id.back_button);

        // Get data from intent
        String branchName = getIntent().getStringExtra(EXTRA_BRANCH_NAME);
        int semestersCount = getIntent().getIntExtra(EXTRA_SEMESTERS_COUNT, 0);
        HashMap<Integer, List<String>> semesterSubjects =
            (HashMap<Integer, List<String>>) getIntent().getSerializableExtra(EXTRA_SUBJECTS);

        // Set data to views
        branchNameTextView.setText(branchName);
        semestersCountTextView.setText(semestersCount + " Semesters");

        // Back button functionality
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //  a loop toPopulate semester cards
        if (semesterSubjects != null) {
            for (Map.Entry<Integer, List<String>> entry : semesterSubjects.entrySet()) {
                int semesterNumber = entry.getKey();
                List<String> subjects = entry.getValue();
                addSemesterCard(semesterNumber, subjects);
            }
        }
    }

    private void addSemesterCard(int semesterNumber, List<String> subjects) {
        // Inflate the semester card layout
        View semesterView = getLayoutInflater().inflate(R.layout.semester_card, semestersContainer, false);

        // Set semester title and subject count
        TextView semesterTitle = semesterView.findViewById(R.id.semester_title);
        TextView subjectsCount = semesterView.findViewById(R.id.subjects_count);
        LinearLayout subjectsList = semesterView.findViewById(R.id.subjects_list);

        semesterTitle.setText("Semester " + semesterNumber);
        subjectsCount.setText(subjects.size() + " Subjects");

        // Add subjects to the card
        for (String subject : subjects) {
            TextView subjectView = new TextView(this);
            subjectView.setText("• " + subject);
            subjectView.setTextSize(16);
            subjectView.setPadding(0, 8, 0, 8);
            subjectsList.addView(subjectView);
        }

        // Add the semester card to the container
        semestersContainer.addView(semesterView);
    }
}