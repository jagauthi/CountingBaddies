package com.example.androidapp.countingassholes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddCarActivity extends AppCompatActivity {

    Button whiteButton, blackButton, redButton, blueButton, greenButton, otherColorButton;
    Button fordButton, dodgeButton, otherCarButton;
    Button submitButton;

    TextView colorText, makeText;

    String selectedColor, selectedMake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        selectedColor = "";
        selectedMake = "";

        colorText = (TextView)findViewById(R.id.colorText);
        makeText = (TextView)findViewById(R.id.makeText);

        whiteButton = (Button)findViewById(R.id.whiteButton);
        blackButton = (Button)findViewById(R.id.blackButton);
        redButton = (Button)findViewById(R.id.redButton);
        blueButton = (Button)findViewById(R.id.blueButton);
        greenButton = (Button)findViewById(R.id.greenButton);
        otherColorButton = (Button)findViewById(R.id.otherColorButton);

        whiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor("White");
            }
        });
        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor("Black");
            }
        });
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor("Red");
            }
        });
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor("Blue");
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor("Green");
            }
        });
        otherColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor("Other");
            }
        });

        fordButton = (Button)findViewById(R.id.fordButton);
        dodgeButton = (Button)findViewById(R.id.dodgeButton);
        otherCarButton = (Button)findViewById(R.id.otherCarButton);

        fordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMake("Ford");
            }
        });
        dodgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMake("Dodge");
            }
        });
        otherCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMake("Other");
            }
        });

        submitButton = (Button)findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitCar();
            }
        });
    }

    public void selectColor(String color) {
        selectedColor = color;
        colorText.setText("Color: " + color);
    }

    public void selectMake(String make) {
        selectedMake = make;
        makeText.setText("Make: " + make);
    }

    public void submitCar() {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);

        if(!selectedColor.equals("") && !selectedMake.equals("")) {
            dbHandler.addCar(new CarPacket(1, selectedColor, selectedMake));
            Log.d("DebuggingTag", "Inserted a car");
        }
        else {
            Log.d("DebuggingTag", "Did not insert");
        }
    }
}
