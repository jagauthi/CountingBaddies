package com.example.androidapp.countingassholes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCarsActivity extends AppCompatActivity {

    Button loadCarsButton, deleteCarsButton;
    LinearLayout linearLayout;
    ArrayList<CarPacket> carPacketArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cars);

        carPacketArrayList = new ArrayList<CarPacket>();
        loadCarsButton = (Button)findViewById(R.id.loadCarsButton);
        deleteCarsButton = (Button) findViewById(R.id.deleteCarsButton);
        linearLayout = (LinearLayout)findViewById(R.id.carList);

        loadCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCars();
            }
        });
        deleteCarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCars();
            }
        });
    }

    public void getCars() {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
        ArrayList<CarPacket> cars = dbHandler.getAllCars();
        if(cars.size() == 0) {
            TextView temp = new TextView(linearLayout.getContext());
            temp.setText("No cars in database.");
            linearLayout.addView(temp);
        }
        for(int i = 0; i < cars.size(); i++) {
            TextView temp = new TextView(linearLayout.getContext());
            temp.setText((i+1) + ") " + cars.get(i).getColor() + " " + cars.get(i).getMake());
            linearLayout.addView(temp);
        }
    }

    public void deleteCars() {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
        dbHandler.deleteAllCars();
        linearLayout.removeAllViews();
    }
}
