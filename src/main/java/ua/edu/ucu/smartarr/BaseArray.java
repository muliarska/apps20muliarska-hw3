package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] data;

    public BaseArray(Object[] data) {
        this.data = data;
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i<size(); i++) {
            res += toArray()[i] + " ";
        }
        return res;
    }
}
