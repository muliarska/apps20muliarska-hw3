package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    private static final int limitGPA = 4;

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object student) {
                Student st = (Student) student;
                return st.getYear() == 2 && st.getGPA() >= limitGPA;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object student1, Object student2) {
                Student st1 = (Student) student1;
                Student st2 = (Student) student2;
                return st1.getSurname().compareTo(st2.getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object student) {
                Student st = (Student) student;
                return st.getSurname() + " " + st.getName();
            }
        };

        SmartArray sa = new BaseArray(students);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);
        sa = new DistinctDecorator(sa);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
