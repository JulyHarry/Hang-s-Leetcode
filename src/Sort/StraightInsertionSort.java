package Sort;

public class StraightInsertionSort {
    /**
     * 插入排序
     * 思想:将一个记录插入到已排好序的有序表中，从而得到一个新的、记录数增1的有序表，
     * 默认将第一个元素看为有序表，一次插入后边的所欲元素
     * 时间复杂度O(n^2)
     * 空间复杂度O(1) 适用于记录数量小的
     * @param arr
     * @return
     */
    public static int[] InsertSort(int[] arr) {
        //从小到大排列
        for(int i=1;i<arr.length;i++)
        {
            //待插入元素
            int temp = arr[i];
            int j;
            for(j=i-1;j>=0 && temp < arr[j];j--)
            {
                //待插入元素小于已有的，就将已有往后挪，直到元素大于插入元素或已经到序列最首端了
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
