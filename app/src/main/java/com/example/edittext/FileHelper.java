package com.example.edittext;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {
    public static final String FILENAME = "listinfo.dat";
    public static final String FILENAMEserial = "listinfo2.dat";
    public static final String FILENAMEfilm = "listinfo3.dat";

    public static void writeData(ArrayList<String> items, Context context){

        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<String> readData(Context context){
        ArrayList<String> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            itemsList = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemsList;
    }
    public static void writeDataSer(ArrayList<String> items, Context context){

        try {
            FileOutputStream fos2 = context.openFileOutput(FILENAMEserial, Context.MODE_PRIVATE);
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos2.writeObject(items);
            oos2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<String> readDataSer(Context context){
        ArrayList<String> itemsList2 = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAMEserial);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList2 = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            itemsList2 = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemsList2;
    }
    public static void writeDataFilm(ArrayList<String> items, Context context){

        try {
            FileOutputStream fos3 = context.openFileOutput(FILENAMEfilm, Context.MODE_PRIVATE);
            ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
            oos3.writeObject(items);
            oos3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<String> readDataFilm(Context context){
        ArrayList<String> itemsList3 = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAMEfilm);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList3 = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            itemsList3 = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemsList3;
    }
}