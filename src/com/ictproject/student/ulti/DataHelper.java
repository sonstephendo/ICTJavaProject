package com.ictproject.student.ulti;

import com.ictproject.student.alert.AlertMaker;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataHelper<T> {
    private String fileName;

    public DataHelper(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<T> readData() {
        FileInputStream in = null;
        ArrayList<T> register = new ArrayList<>();
        try {
            in = new FileInputStream(this.fileName);
            XMLDecoder decoder = new XMLDecoder(in);
            register = (ArrayList<T>) decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
            AlertMaker.showWarning(e);
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e1) {
                AlertMaker.showWarning(e1);
            }
        } finally {
            return register;
        }
    }

    public void saveData(ArrayList<T> arrayList) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(this.fileName);
            XMLEncoder encoder = new XMLEncoder(out);
            encoder.setPersistenceDelegate(LocalDate.class, new PersistenceDelegate() {
                @Override
                protected Expression instantiate(Object oldInstance, Encoder out) {
                    LocalDate localDate = (LocalDate) oldInstance;
                    return new Expression(localDate, LocalDate.class, "parse", new Object[]{localDate.toString()});
                }
            });
            encoder.writeObject(arrayList);
            encoder.close();
            System.out.println("Saved list: " + this.fileName);
        } catch (Exception e) {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    AlertMaker.showWarning(e1);
                }
            }
            AlertMaker.showWarning(e);
        }
    }

}
