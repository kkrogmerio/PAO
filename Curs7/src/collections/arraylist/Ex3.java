package collections.arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> ints= Arrays.asList(2,3,66,5,-12,10);
        System.out.println(ints);
        Object[]arrayint=ints.toArray();
        System.out.println(Collections.binarySearch(ints,-(insertion point)-1));
    }
}
