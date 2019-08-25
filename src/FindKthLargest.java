import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static int findKthLargestA1(int[] nums, int k) {
        /*
        使用优先队列
        1. 队列：特殊的线性表，只能从头部移除，从尾部加入
        2. 优先：无论插入顺序如何，输出时自动排好序
        3. 方法： 推荐使用：offer,poll,peek | put,take | add,remove,element
        O(N lg K) running time + O(K) memory
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // <Integer>一定要加 不然返回类型是object
        for (int val : nums){ // N
            pq.offer(val); // lg K
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int findKthLargestA2(int[] nums, int k) {
        /*
        利用快排 平均时间复杂度 N log N
        O(N) best case / O(N^2) worst case running time + O(1) memory
        The smart approach for this problem is to use the selection algorithm
        (based on the partion method - the same one as used in quicksort).
         */
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if(j < k) {
                l = j + 1;
            } else if (j > k) {
                h = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l,int h){
        int i = l;
        int j = h + 1;
        while(true) {
            while(i < h && less(a[++i], a[l]));
            while(j > l && less(a[l], a[--j]));
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int a, int b){
        return a < b;
    }

    public static int findKthLargestA3(int[] nums, int k) {
        /*
        O(N lg N) running time + O(1) memory
         */
        int len = nums.length;
        if (k<1 | k>len) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[len-k];
    }

//    public static void main() {
//        int[] nums = {1,2,4};
//        System.out.print(findKthLargest(nums,1));
//    }
}
