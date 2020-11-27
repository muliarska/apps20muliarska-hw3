package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.predicate = pr;
        filter();
    }

    private void filter() {
        Object[] data = smartArray.toArray();
        int shift = 0;

        for (int i = 0; i < size(); i++) {
            if (! predicate.test(data[i])) {
                data[i] = null;
                shift++;
            }
        }

        SmartArray newArray = new BaseArray(shiftElements(data, shift));
        this.smartArray = newArray;
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "This operation tests every element and " +
                "removes it if it doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
