package HEAP;

public class MaxHeap<Item> {

    Item[] data; 
    //这里的Item，是类的泛型，并不是Java中的某个类
    //就像参数，MaxHeap<Integer> maxHeap=new MaxHeap<Integer>(100);
    //这里，创建堆对象时，Item就会是Integer类型，下面的Item都是Integer类型，即本类中Item等价于Integer
    //并且本类中，要一直使用Item

    private int count;

    //构造函数，构造一个空堆，可容纳capacity个元素
    public MaxHeap(int capacity) {
        data=(Item[])new Object[capacity+1];    //数组0位置，不使用
        count=0;
    }

    public void add(int seat, Item value) {
        data[seat]=value;
    }

    public Item get(int index) {
        return data[index];
    }

    //返回堆中元素个数
    public int size() {
        return count;
    }

    //返回布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return count==0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap=new MaxHeap<Integer>(10);
        System.out.println(maxHeap.size());
        //System.out.println(maxHeap.data[2]);

        maxHeap.add(2, 3);
        System.out.println(maxHeap.get(2));

    }

	public void insert(Integer integer) {
	}

}