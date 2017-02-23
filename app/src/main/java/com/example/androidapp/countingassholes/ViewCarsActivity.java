package com.example.androidapp.countingassholes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewCarsActivity extends AppCompatActivity {

    Button loadCarsButton;
    ArrayList<CarPacket> carPacketArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cars);

        carPacketArrayList = new ArrayList<CarPacket>();
        loadCarsButton = (Button)findViewById(R.id.loadCarsButton);

        loadCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCars();
            }
        });
    }

    public void getCars() {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
    }
}
