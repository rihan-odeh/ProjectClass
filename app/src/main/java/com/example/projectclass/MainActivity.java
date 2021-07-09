package com.example.projectclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addProjectByNameAndDescription;
    private Button addProjectByName;
    private Button addEmptyProject;
    private Button viewAllProjects;
    private EditText nameOnly; // adding by only the name
    private EditText name;
    private EditText description;
    private Project project;
    public static final String prefs = "MyPreferences";
    private ArrayList<Project> projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();


        addProjectByNameAndDescription.setOnClickListener(v -> {
            project = new Project(name.getText().toString(), description.getText().toString());
            Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();

        });
        addProjectByName.setOnClickListener(v -> {
            project = new Project(nameOnly.getText().toString());
            Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();


        });
        addEmptyProject.setOnClickListener(v -> {
            project = new Project();
            Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();


        });
        viewAllProjects.setOnClickListener(v -> {
            Intent intent = new Intent(this, Portfolio.class);
            startActivity(intent);

        });
        addToSharedPreferences();
    }
    private void bindUI(){
        addProjectByNameAndDescription = findViewById(R.id.bothParametersButton);
        addProjectByName = findViewById(R.id.nameButton);
        addEmptyProject = findViewById(R.id.NoParametersButton);
        viewAllProjects = findViewById(R.id.goToAllProjects);
        nameOnly = findViewById(R.id.onlyNameEditText);
        name = findViewById(R.id.nameEditText);
        description = findViewById(R.id.descriptionEditText);
    }

    public void addToSharedPreferences() {
        SharedPreferences.Editor editor = getSharedPreferences(prefs, MODE_PRIVATE).edit();
        projects= new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences(prefs, MODE_PRIVATE);
        String json = sharedPreferences.getString("Input", "");
        projects = new Gson().fromJson(json, ArrayList.class);
        if (projects == null) {
            projects = new ArrayList<>();
        }
        projects.add(project);
        Gson gson = new Gson();
        String arrayToGson = gson.toJson(projects);
        editor.putString("Input", arrayToGson);
        editor.apply();



    }
}


/*
i want to make a button in main activity to show all projects, when one is clicked
its data is shown, separated by a comma...
so i have a
 1- main activity, with four buttons, 3 with the different constructors of project class
and one for the recycler view
2- project class with constructors, setters, getters and methods.
3- recycler view activity to show the projects added with the capability to click on specific item to show its name and
description.
 */