/*
 * @Desc:  LC00295 - 数据流的中位数
 * @Url:   https://leetcode-cn.com/problems/find-median-from-data-stream/
 * @Date:  2021-08-27 20:21:00
 * @Content:
 //中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 514 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.PriorityQueue;

class FindMedianFromDataStream{
    public static void main(String[] args) {
        MedianFinder medianFinder = new FindMedianFromDataStream().new MedianFinder();
        medianFinder.addNum(1);
        double m = medianFinder.findMedian();
        System.out.println("m = " + m);
        medianFinder.addNum(2);
        m = medianFinder.findMedian();
        System.out.println("m = " + m);
        medianFinder.addNum(3);
        m = medianFinder.findMedian();
        System.out.println("m = " + m);
        medianFinder.addNum(4);
        m = medianFinder.findMedian();
        System.out.println("m = " + m);
        medianFinder.addNum(1);
        m = medianFinder.findMedian();
        System.out.println("m = " + m);
        medianFinder.addNum(1);
        m = medianFinder.findMedian();
        System.out.println("m = " + m);
    }
    
/*
 * Solution is here.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> a - b);
        min = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.add(num);
            if (min.size() > max.size() + 1) {
                max.add(min.poll());
            }
        } else {
            max.add(num);
            if (max.size() > min.size()) {
                min.add(max.poll());
            }
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return min.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}