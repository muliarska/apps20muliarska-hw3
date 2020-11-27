package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction fn) {
        super(smartArray); // smart array
        this.function = fn;
        map();
    }

    private void map() {
        Object[] data = smartArray.toArray();

        for (int i = 0; i < size(); i++) {
            data[i] = function.apply(data[i]);
        }

        SmartArray newArray = new BaseArray(data);
        this.smartArray = newArray;
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This operation map every element to"
                + " another object using MyFunction";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
