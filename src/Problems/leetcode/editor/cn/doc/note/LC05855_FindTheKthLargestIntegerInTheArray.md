# python自带排序实现
* `sorted`    `reverse=True`为降序  可使用切片直接返回
```python
sorted(nums, key=int, reverse=True)
sorted(nums, key=int, reverse=True)[k]
```
* `.sort()` `reverse=True`为降序  不可使用切片
```python
nums.sort(key=int, reverse=True)
nums[k]
```
* 自定义key
```python
class MyCompare(str):
    def __lt__(self, other):
        if len(self) != len(other):
            return len(self) < len(other)
        else:
            for i in range(len(self)):
                if self[i] != other[i]:
                    return self[i] < other[i]

nums.sort(key=MyCompare, reverse=True)
sorted(nums, key=MyCompare, reverse=True)
```

#Java自带排序实现
* lamada形式
```java
//升序 定义顺序与返回相减顺序一致
Arrays.sort(nums, (o1, o2) -> o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length());
//降序 定义顺序与返回相减顺序相反
Arrays.sort(nums, (o1, o2) -> o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length());
```
* lamada形式 带return返回 一定要有`{}` 和 `;`
```java
Arrays.sort(nums, (o1, o2) -> {return o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length();});
```
* 匿名内部类
```java
//降序 定义顺序与返回相减顺序相反
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
```
* 内部类
```java
//定义内部类 MyComparator
class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() == o2.length() ? o2.compareTo(o1) : o2.length() - o1.length();
    }
}
//调用时一定要new
Arrays.sort(nums,new MyComparator());
```

# Java 内部类 匿名内部类 lamada
以PriorityQueue从默认的小顶堆变为**大顶堆**为例
* 内部类
```java
//内部类一定声明在前，使用再后
class PriorityQueueOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
PriorityQueue<Integer> pq = new PriorityQueue<>(new PriorityQueueOrder()); //大顶堆
```
* 匿名内部类
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
});
```
* lamada
```java
PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
// 其他实现方法
// PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```
~~其他实现方法~~
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```