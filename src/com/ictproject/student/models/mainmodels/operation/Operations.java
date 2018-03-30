package com.ictproject.student.models.mainmodels.operation;

import com.ictproject.student.alert.AlertMaker;
import com.ictproject.student.models.mainmodels.Registration;
import com.ictproject.student.models.mainmodels.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Operations<T> {

    private ArrayList<T> dataList;

    public Operations() {
        this.dataList = new ArrayList<>();
    }

    public ArrayList<T> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<T> dataList) {
        this.dataList = dataList;
    }

    public boolean addData(T newElement) {
        boolean isExist = false;
        String newIdentify = converter(newElement);
        for (T t : dataList) {
            String converted = converter(t);
            if (converted.equals(newIdentify)) {
                isExist = true;
            }
        }
        if (!isExist) {
            dataList.add(newElement);
            return true;
        }
        return false;
    }

    public void deleteData(T removeElement) {
        dataList.remove(removeElement);
    }

    public void deleteData(String element) {
        for (T t : dataList) {
            String converted = converter(t);
            if (converted.equals(element)) {
                deleteData(t);
                break;
            }
        }

    }

    public T getData(String element) {
        for (T t : dataList) {
            String converted = converter(t);
            if (converted.equals(element)) {
                return t;
            }
        }
        return null;
    }

    public abstract String converter(T element);
}
