package com.example.androidapp.countingassholes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button addCarButton, viewCarsButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCarButton = (Button) findViewById(R.id.addCarButton);
        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCar();
            }
        });

        viewCarsButton = (Button) findViewById(R.id.viewCarsButton);
        viewCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewCars();
            }
        });
    }

    public void addCar()
    {
        Intent intent = new Intent(this, AddCarActivity.class);
        startActivity(intent);
    }

    public void viewCars()
    {
        Intent intent = new Intent(this, ViewCarsActivity.class);
        startActivity(intent);
    }
}
