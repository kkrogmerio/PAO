package collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/*Iterable
Collection
    List
    Set
    Queue
 */
public class Ex1 {
    public static void main(String[] args) {
        List bulklist=new ArrayList();
        bulklist.add(1);
        bulklist.add("two");
        bulklist.add(new Object());
        System.out.println(bulklist.remove((1)));
        System.out.println(bulklist);
        List<String>List1=new ArrayList<>();
        System.out.println(List1.isEmpty());
        List1.add("one");
        List1.add("doi");
        List1.add(1,"Rude boy");
        System.out.println(List1.remove("onde"));
        List<String>ints=new ArrayList<>();
        ints.add("Yellow");ints.add("Yellow");
        System.out.println("aftermath");
        List<String >list2=new ArrayList<>(ints);
        System.out.println(list2);
        List x= new Vector();
        x.add("one");
        x.add("doi");
        List<Integer> y=new ArrayList<>(x);
        System.out.println(List1);
        List1.addAll(1,List1);
        System.out.println(List1);
        List1.removeAll(x);
        System.out.println(List1);
    }
}
