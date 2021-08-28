package Array;

import java.util.Arrays;

/**
 * Description:
 *
 * @author hang
 * @date 2021/1/19
 */
public class DynamicArray {
    private int[] array;
    private int size = 0;
    private int initSize = 3;

    public DynamicArray() {
        array = new int[initSize];
    }

    public void push_back(int n) {
        if (initSize == size) {
            initSize *= 2;
            array = Arrays.copyOf(array, initSize);
        }
        array[size++] = n;
    }

    public int size() {
        return size;
    }

    public int index(int idx) {
        return array[idx];
    }

    public static void main(String[] args) {
        DynamicArray dy = new DynamicArray();
        dy.push_back(1);
        dy.push_back(2);
        dy.push_back(3);
        dy.push_back(4);
//        dy.push_back(5);
//        dy.push_back(6);
//        dy.push_back(7);
        System.out.println(dy.size());
        System.out.println(dy.index(0));
        System.out.println(dy.index(1));
        System.out.println(dy.index(2));
        System.out.println(dy.index(3));
//        System.out.println(dy.index(5));
//        System.out.println(dy.index(6));
//        System.out.println(dy.index(7));
    }
}
