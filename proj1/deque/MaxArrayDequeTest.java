package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {
    //构建字符串比较器
    public static class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2){
            return s1.compareTo(s2);

        }

    }
    //static静态类的话不需要new
    public static class LengthComparator implements Comparator<String>{
        public int compare(String s1,String s2){
            return (s1.length() -s2.length());
        }
    }


    @Test
    public void testMaxArrayDeque(){
        MaxArrayDeque<String> max1 = new MaxArrayDeque<>(new StringComparator());
        max1.addLast("zoo");
        max1.addLast("pear");
        max1.addLast("banana");

        org.junit.Assert.assertEquals("zoo", max1.max());

        org.junit.Assert.assertEquals("banana",max1.max(new LengthComparator()));

        org.junit.Assert.assertEquals("zoo", max1.max());
    }




}
