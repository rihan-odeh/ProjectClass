package com.example.projectclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button addProjectByNameAndDescription;
    Button addProjectByName;
    Button addEmptyProject;
    Button viewAllProjects;
    EditText nameOnly; // adding by only the name
    EditText name;
    EditText description;
    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addProjectByNameAndDescription= findViewById(R.id.bothParametersButton);
        addProjectByName = findViewById(R.id.nameButton);
        addEmptyProject= findViewById(R.id.NoParametersButton);
        viewAllProjects= findViewById(R.id.goToAllProjects);
        nameOnly= findViewById(R.id.onlyNameEditText);
        name=findViewById(R.id.nameEditText);
        description= findViewById(R.id.descriptionEditText);


        addProjectByNameAndDescription.setOnClickListener(v -> {
            project = new Project(name.getText().toString(), description.getText().toString());
            Toast.makeText(getApplicationContext(),"Created",Toast.LENGTH_LONG ).show();

        });
        addProjectByName.setOnClickListener(v -> {
            project= new Project(nameOnly.getText().toString());
            Toast.makeText(getApplicationContext(),"Created",Toast.LENGTH_LONG ).show();


        });
        addEmptyProject.setOnClickListener(v -> {
            project= new Project();
            Toast.makeText(getApplicationContext(),"Created",Toast.LENGTH_LONG ).show();


        });
        viewAllProjects.setOnClickListener(v -> {
            Intent intent = new Intent(this, Portfolio.class);
            startActivity(intent);

        });
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