package com.example.androidapp.countingassholes;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "carDB.db";
    private static final String TABLE_NAME = "cars";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + "id INTEGER PRIMARY KEY,color TEXT,make TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addCar(CarPacket packet) {

        ContentValues values = new ContentValues();
        values.put("color", packet.getColor());
        values.put("make", packet.getMake());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public CarPacket getCar(int id) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        CarPacket packet = new CarPacket();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            packet.setId(Integer.parseInt(cursor.getString(0)));
            packet.setColor(cursor.getString(1));
            packet.setMake(cursor.getString(2));
            cursor.close();
        }
        else {
            packet = null;
        }
        db.close();
        return packet;
    }

    public ArrayList<CarPacket> getAllCars() {
        ArrayList<CarPacket> results = new ArrayList<CarPacket>();
        String query = "Select * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
            cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++) {
            results.add(new CarPacket(cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }

        db.close();
        return results;
    }

    public boolean deleteCar(int id) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_NAME + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            int packetID = (Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, "id = ?", new String[] { String.valueOf(packetID) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public void deleteAllCars() {
        String query = "Delete FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query);
    }
}