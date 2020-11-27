package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator cm) {
        super(smartArray);
        this.comparator = cm;
        sort();
    }

    private void sort() {
        Object[] data = smartArray.toArray();
        Arrays.sort(data, comparator);

        SmartArray newArray = new BaseArray(data);
        this.smartArray = newArray;
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This operation removes elements that " +
                "do not meet the predicate conditions";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
