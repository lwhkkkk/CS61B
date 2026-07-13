package deque;


import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>,Deque<T>{
    private IntNode sentinel;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T>{
        private IntNode wizPos;

        public DequeIterator(){
            wizPos = sentinel.next;
        }

        @Override
        public boolean hasNext(){
            return wizPos != sentinel;
        }


        @Override
        public T next(){
            T returnItem = wizPos.item;

            wizPos =  wizPos.next;

            return returnItem;
        }


    }
    @Override
    public boolean equals(Object o){
        //如果同一个内存地址
        if ( o == this){
            return true;
        }

        //检查o是不是LinkedListdeque类
        if (!( o instanceof LinkedListDeque)){
            return false;
        }

        //强制类型转换
        LinkedListDeque<?> other = (LinkedListDeque<?>) o ;
        //比较长度
        if (other.size != this.size ){
            return false;
        }
        //逐个对比
        for (int i = 0 ;i < size;i++){
            if(!this.get(i).equals(other.get(i))){
                return false;
            }

        }
        return true;

    }




    private class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;


        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }


    public LinkedListDeque() {
        size = 0;
        //单独先创建sentinel节点
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    @Override
    public int size() {
        return size;
    }


    @Override
    public void addFirst(T item) {
        IntNode newNode = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size = size + 1;
    }
    @Override
    public void addLast(T item){
        IntNode newNode  =new IntNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size = size + 1;
    }
    @Override
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        IntNode oldFirst = sentinel.next;
        T items = oldFirst.item;

        sentinel.next =oldFirst.next;
        oldFirst.next.prev = sentinel;

        oldFirst.prev =null;
        oldFirst.next = null;
        oldFirst.item = null;

        size = size -1 ;
        return items;
    }
    @Override
    public T removeLast(){
        if (isEmpty()){
            return null;
        }

    IntNode oldLast = sentinel.prev;
    T items  = oldLast.item;
    oldLast.prev.next = sentinel;
    sentinel.prev = oldLast.prev;

    oldLast.prev = null;
    oldLast.next = null;
    oldLast.item = null;

    size = size -1 ;
    return items;

    }

    @Override
    //找对应序号的节点
    public T get(int index){
        if (isEmpty() || index >= size){
            return null;
        }
        IntNode current = sentinel.next;
        for (int i = 0; i <index ;i++){
            current = current.next;
       }
        return current.item;


    }

    //递归查找，暴露给别人去用的
    public T getRecursive(int index){
        if (isEmpty() || index >= size){
            return null;
        }
        return getRecursiveHelper(sentinel.next,  index);

    }

    //这个方法只能是大类里面的getRecursive调用
    private T getRecursiveHelper(IntNode curr,int index){
        if (index == 0){
            return curr.item;
        }
        else{

            return getRecursiveHelper(curr.next,index -1 );
        }
    }
    //打印队列里面的全部元素
    public void printDeque(){
        IntNode curr = sentinel.next;

        for(int i = 0; i <size; i++){
            System.out.print(curr.item +" ");

            curr = curr.next;

        }

        System.out.println();
    }





}