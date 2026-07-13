package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>,Deque<T>{
    private T[] item;
    private int size;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;

    }

    @Override
    public void addFirst(T x) {
        if (size == item.length) {
            resize(item.length * 2);
        }
        item[nextFirst] = x;
        nextFirst = nextFirst - 1;
        if (nextFirst < 0) {
            nextFirst = item.length - 1;
        }
        size = size + 1;
    }
    @Override
    public void addLast(T x) {
        if (size == item.length) {
            resize(item.length * 2);
        }
        item[nextLast] = x;
        nextLast = nextLast + 1;
        if (nextLast > item.length - 1) {
            nextLast = 0;
        }
        size = size + 1;
    }
    @Override
    public int size() {
        return size;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) { //通过数值而不是isEmpty来进行边界检查
            return null;
        }
        int getT = nextFirst + 1 + index;
        getT = getT % item.length; //注意超过数组限制要通过取余来获得值
        return item[getT];
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int actualIndex = (nextFirst + 1) % item.length;
        T deadItem = item[actualIndex];
        item[actualIndex] = null;//垃圾清除,让对象被内存回收
        nextFirst = nextFirst + 1;
        if (nextFirst == item.length) {
            nextFirst = 0;
        }
        size = size - 1;
        //缩容判断
        if (item.length >= 16 && size < item.length * 0.25) {
            resize(item.length / 2);
        }
        return deadItem;
    }
    @Override
    //两个的边界值不太一样,注意分开讨论
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int actualIndex = nextLast - 1;
        if (actualIndex < 0) {
            actualIndex = item.length - 1;
        }
        T deadItem = item[actualIndex];
        item[actualIndex] = null;

        nextLast = nextLast - 1;
        if (nextLast == 0) {
            nextLast = item.length - 1;
        }
        size = size - 1;
        //缩容
        if (item.length >= 16 && size < item.length * 0.25) {
            resize(item.length / 2);
        }
        return deadItem;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " "); //用实现好的get方法
        }
        System.out.println();
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        item = a;//让核心指针指新的数组
        nextFirst = item.length - 1;
        nextLast = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;


        //构造函数
        public ArrayDequeIterator(){
            wizPos = 0;
        }

        @Override
        public boolean hasNext(){
            return wizPos < size;
        }


        @Override
        public T next(){
            T returnItem = get(wizPos);
            wizPos = wizPos + 1;
            return returnItem;
        }



    }


    @Override
    public boolean equals(Object o){
        //先看是否是自己
        if (this == o){
            return true;
        }
        //身份
        if(!(o instanceof ArrayDeque)){
            return false;
        }
        ArrayDeque<?> other = (ArrayDeque<?>) o;

        if (other.size != this.size){
            return false;
        }

        for (int i = 0;i < size;i++){
            if(!this.get(i).equals(other.get(i))){
                return false;
            }
        }
        return true;

    }



}