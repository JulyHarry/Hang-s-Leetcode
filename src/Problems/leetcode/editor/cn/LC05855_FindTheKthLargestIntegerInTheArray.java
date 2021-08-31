/*
 * @Desc:  LC05855 - 找出数组中的第 K 大整数
 * @Url:   https://leetcode-cn.com/problems/find-the-kth-largest-integer-in-the-array/
 * @Date:  2021-08-30 21:17:59
 * @Content:
 //给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。 
//
// 返回 nums 中表示第 k 大整数的字符串。 
//
// 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1
//" 是第三大的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = ["3","6","7","10"], k = 4
//输出："3"
//解释：
//nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
//其中第 4 大整数是 "3"
// 
//
// 示例 2： 
//
// 
//输入：nums = ["2","21","12","1"], k = 3
//输出："2"
//解释：
//nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
//其中第 3 大整数是 "2"
// 
//
// 示例 3： 
//
// 
//输入：nums = ["0","0"], k = 2
//输出："0"
//解释：
//nums 中的数字按非递减顺序排列为 ["0","0"]
//其中第 2 大整数是 "0"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// 1 <= nums[i].length <= 100 
// nums[i] 仅由数字组成 
// nums[i] 不含任何前导零 
// 
// 👍 7 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

class FindTheKthLargestIntegerInTheArray {
    public static void main(String[] args) {
        Solution solution = new FindTheKthLargestIntegerInTheArray().new Solution();
        String[] nums = {"3", "16", "7", "10"};
        int k = 2;
        String s = solution.kthLargestNumber4(nums, k);
        System.out.println(s);
    }

    /*
     * Solution is here.
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums,
                    (o1, o2) -> o1.length() == o2.length() ?
                            o2.compareTo(o1) : o2.length() - o1.length());
            return nums[k - 1];
        }

        public String kthLargestNumber2(String[] nums, int k) {
            Arrays.sort(nums,
                    (o1, o2) -> {
                        return o1.length() == o2.length() ?
                                o2.compareTo(o1) : o2.length() - o1.length();
                    });
            return nums[k - 1];
        }

        public String kthLargestNumber3(String[] nums, int k) {
            Arrays.sort(nums, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o2.compareTo(o1);
                    } else {
                        return o2.length() - o1.length();
                    }
                }
            });
            return nums[k - 1];
        }

        public String kthLargestNumber4(String[] nums, int k) {
            class MyComparator implements Comparator<String> {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length();
                }
            }
            Arrays.sort(nums, new MyComparator());
            for (String num : nums) {
                System.out.println(num);
            }
            return nums[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}