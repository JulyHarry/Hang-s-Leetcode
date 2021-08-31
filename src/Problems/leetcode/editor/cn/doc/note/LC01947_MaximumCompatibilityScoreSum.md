# 状态压缩

## 定义状态

用一个长度为 `m` 的二进制数 `mask` 表示每一名学生是否被分配了老师。

如果 `mask` 的第 `i` 位为 `1` ，那么第 `i` 位学生被分配到了老师，否则就没有被分配到老师。

同时也意味着 `mask` 中 1 的个数，代表当前有几个老师分配到了学生。

**学生的分配方式和老师的数量决定了当前状态的确定性。**

`f[mask]` 表示当老师被分配学生的状态为 `mask` 时，最大的兼容性评分和。

> 示例
> 以 $(111)_2$ 为例  
> 计算 $(111)_2$ 可由 $(110)_2$ 、 $(101)_2$ 、 $(011)_2$ 得到  
> $(110)_2$ 、 $(101)_2$ 、 $(011)_2$ 中有2个 `1` ，均表示已经有两个老师得到分配  
> **$(101)_2$ 表示：第1个学生和第三个学生被分配到了老师，当前有2个老师得到了分配名额**  
> 这样的含义相当于给出了 score 函数的横纵坐标  
> 在计算 $(111)_2$ 时，我们只需要将 mask 状态通过与每一位的 1 异或得到 sub 状态，再加上当前 score 的分数即可

## 状态转移方程

当前状态的 `mask` 一定**由前一个状态 `sub` 变化而来**， 如果将 `sub` 中第 `i` 位的 `0` 的位置变为 `1` ，得到 `mask`，
(此时如果 `mask` 中有 `c` 个 `1` ，那么 `sub` 中一定只有 `c-1` 个 `1`， sub 中新产生的 `1` 是第 `c` 个，代表第 `c` 个老师分配到了学生， 但是学生标号是从 `0` 开始，
所以第 `c` 个老师从学生得到的分数为 `score[i][c-1]`)
， 那么 `dp[mask] = dp[sub] + score[i][c−1]`
$$dp[mask]= \underset{mask的第i位为1}{max}\{ dp[mask\i]+score[i][c−1]\}$$
`mask\i` 表示将 `mask` 的第 `i` 位从 `1` 变成 `0`

## 代码示例

```java
class Solution {
    int[][] score;
    int m;

    //dp
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        score = new int[m][m];
        int n = 1 << m;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                calculate(students[i], mentors[j], i, j);
            }
        }
        for (int mask = 0; mask < n; mask++) {
            int bitCount = Integer.bitCount(mask);
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << i)] + score[i][bitCount - 1]);
                }
            }
        }
        return dp[n - 1];
    }

    private void calculate(int[] student, int[] mentor, int i, int j) {
        int res = 0;
        for (int k = 0; k < student.length; k++) {
            if (student[k] == mentor[k]) {
                res++;
            }
        }
        score[i][j] = res;
    }
}
```

回溯代码

```java
class Solution {
    boolean[] visited;
    int[][] score;
    int m;
    int res = 0;

    //backtrack
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        score = new int[m][m];
        visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                calculate(students[i], mentors[j], i, j);
            }
        }
        backtrack(0, 0);
        return res;
    }

    private void backtrack(int s, int cur) {
        if (s == m) {
            res = Math.max(res, cur);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur += score[s][i];
                backtrack(s + 1, cur);
                cur -= score[s][i];
                visited[i] = false;
            }
        }
    }

    private void calculate(int[] student, int[] mentor, int i, int j) {
        int res = 0;
        for (int k = 0; k < student.length; k++) {
            if (student[k] == mentor[k]) {
                res++;
            }
        }
        score[i][j] = res;
    }
}
```