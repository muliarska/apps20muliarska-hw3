package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        deleteEquals();
    }

    private void deleteEquals() {
        Object[] data = smartArray.toArray();
        int shift = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i] != null) {
                for (int j = i + 1; j < data.length; j++) {
                    if (data[i].equals(data[j])) {
                        data[j] = null;
                        shift++;
                    }
                }
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
        return "This operation remove duplicates " +
                "from SmartArray";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
