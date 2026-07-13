package deque;


import java.util.Comparator;
//继承父类Arraydeque
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> defaultComparator;


    //构造函数
    public MaxArrayDeque(Comparator<T> c){
     super();
     defaultComparator = c;
    }

    public T max(Comparator<T> c){
        if(isEmpty()){
            return null;
        }

        T maxItem = get(0);
        //调用size()获得长度，而不允许直接访问size
        for (int i = 1; i< size();i++){
            if (c.compare(get(i),maxItem ) > 0){
                maxItem = get(i);
            }
        }
        return maxItem;
    }
    //方法重载
    public T max(){
        return max(defaultComparator);
    }
}
