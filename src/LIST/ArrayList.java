package LIST;

public class ArrayList implements List{
    /**
     * 顺序表默认的初始大小
     */
    public static final int defLen = 10;
    private int maxLen;
    private Object[] array;
    private int size;

    public ArrayList() {
        size = 0;
        maxLen = defLen;
        array = new Object[defLen];
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Object get(int i) {
        if(i>=0 && i<size)
            return array[i];
        else
            return null;
    }

    @Override
    public int indexOf(Object e) {
        int i =0;
        while(i<size && !array[i].equals(e)) {
            i++;
        }
        if(i < size)
            return i;
        else
            return -1;
    }

    @Override
    public void insert(int i, Object e) {
        if(i >= size) {
            i = size;
            if((size) >= maxLen)//如果插入数的位置大于顺序表的最大容量，则扩大容量
                expand();
        }
        for(int j = size; j>i+1; j--) {
            array[j] = array[j-1];
        }
        array[i+1] = e;
        size ++;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    @Override
    public int lastIndexOf(Object e) {
        int i = size-1;
        while(i>=0 && !array[i].equals(e)) {
            i--;
        }
        if(i>=0)
            return i;
        else
            return -1;
    }

    @Override
    public void remove(int i) {
        for(int j=i; j<size-1; j++) {
            array[j] = array[j+1];
        }
        size --;
    }

    @Override
    public void set(int i, Object e) {
        array[i] = e;
    }

    @Override
    public int size() {
        return size;
    }
    /**
     * 当顺序表的大小不够时，扩充顺序表的大小
     */
    private void expand() {
        maxLen = 2*maxLen;
        Object newArray[] = new Object[maxLen];
        for(int i=0; i<size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void push(Object e) {
        if(size >=maxLen)
            expand();
        array[size] = e;
        size ++;
    }
}
