package HEAP;

public class MaxHeap_ShiftUp<Item extends Comparable> {

	protected Item[] data;
    protected int count;    //閺佹壆绮嶆稉瀣垼
    protected int capacity; //瀵拷鏉堢喓娈戦弫鎵矋閻ㄥ嫬銇囩亸锟�

    //閺嬪嫰锟界姴鍤遍弫锟�
    public MaxHeap_ShiftUp(int capacity) {
        data=(Item[])new Comparable[capacity+1];
        count=0;
        this.capacity=capacity;
    }

    //鏉╂柨娲栭崼鍡曡厬閻ㄥ嫬鍘撶槐鐘遍嚋閺侊拷
    public int size() {
        return count;
    }

    //鏉╂柨娲栨稉锟芥稉顏勭鐏忔柨锟界》绱濈悰銊с仛閸棔鑵戦弰顖氭儊娑撹櫣鈹�
    public boolean isEmpty() {
        return count==0;
    }

    //閸氭垶娓舵径褍鐖㈡稉顓熷絻閸忋儰绔存稉顏呮煀閸忓啰绀岄敍瀹╰em
    public void insert(Item item) {

        //娑撳鐖ｆ稉锟�0閻ㄥ嫮鈹栭梻缈犵瑝閻€劊锟斤拷
        if((count+1) <= capacity) {
            data[count+1]=item; //閸忓牆鐨㈤弫鐗堝祦濞ｈ濮為崚鐗堟殶缂佸嫭婀亸锟�
            count++;
            shiftUp(count); //閻掕泛鎮楃亸鍡樻煀閼哄倻鍋ｉ弨鎯ф躬閻╃ǹ绨叉担宥囩枂閿涘苯鍟€濞嗏€宠埌閹存劖娓舵径褍鐖�
        }
    }

    //娴溿倖宕查崼鍡曡厬缁便垹绱╂稉绡块崪瀹╅惃鍕⒈娑擃亜鍘撶槐锟�
    private void swap(int i,int j) {
        Item t=data[i];
        data[i]=data[j];
        data[j]=t;
    }

    //******************
    //* 閺堬拷婢堆冪垻閺嶇ǹ绺炬潏鍛И閸戣姤鏆�
    //******************
    private void shiftUp(int k) {
        while( (k>1) && (data[k/2].compareTo(data[k])<0)) {
            swap(k, k/2);
            k=k/2;
        }
    }

    public Item get(int i) {
    	return data[i];
    }

    //濞村鐦疢axHeap
    public static void main(String[] args) {

    	MaxHeap_ShiftUp<Integer> maxHeap=new MaxHeap_ShiftUp<Integer>(100);

        int N=50;    //閸棔鑵戦崗鍐娑擃亝鏆�
        int M=100;   //閸棔鑵戦崗鍐閸欐牕锟借壈瀵栭崶锟�

        for(int i=0;i<N;i++) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }
        System.out.print(maxHeap.size());

        System.out.println("=============================");

        
        for(int i=0;i<N;i++) {
            System.out.print(maxHeap.get(i)+" ");
        }
        
        

    }

}