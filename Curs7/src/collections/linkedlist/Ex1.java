package collections.linkedlist;

import java.util.LinkedList;

public class Ex1 {
    public static void main(String[] args) {
        LinkedList<String>list1=new LinkedList<>();
        System.out.println(list1.add("aa"));
        list1.add("bb");
        list1.add(1,"cc");
        list1.addFirst("fff");
        list1.offer("yellow");
        System.out.println(list1);
        System.out.println(list1.pop());
        //System.out.println(list1.element());
    }

}
