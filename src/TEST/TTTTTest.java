package TEST;

import java.util.ArrayList;
import java.util.List;

public class TTTTTest {
    private static int a, b;
    public static void globalvar(){
        System.out.println(a);
    }
    public static void showlist() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(0,3);
        System.out.println(l);
    }
    public static void main(String[] args){
        showlist();
    }
}
