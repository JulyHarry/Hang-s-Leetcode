public class StraightInsertionSort {
    public static void insertSort(int[] a){
        int temp = 0;
        for(int i = 1; i < a.length; i++){
            int j = i - 1;
            temp = a[i];
            for(;j >= 0 && temp < a[j]; j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
}
