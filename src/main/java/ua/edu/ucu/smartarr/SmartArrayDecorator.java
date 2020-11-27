package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public static Object[] shiftElements(Object[] array, int shift) {
        if (shift == 0) {
            return array;
        }

        Object[] newArray = new Object[array.length - shift];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }

    @Override
    public String toString() {
        return smartArray.toString();
    }
}
