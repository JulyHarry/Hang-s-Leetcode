package Sort;

public class BubbleSort {
    public static void bubbleSort(int[] a){
        int temp = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = a.length-1; j>i; j--)
                if (a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
        }
    }
}
