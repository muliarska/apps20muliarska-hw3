package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] data;

    public BaseArray(Object[] data) {
        this.data = data.clone();
    }

    @Override
    public Object[] toArray() {
        return data.clone();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return data.length;
    }
}
