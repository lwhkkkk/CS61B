package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE


    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B  = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {

            int operationNumber = StdRandom.uniform(0, 4);

            if (operationNumber == 0) {

                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);


            } else if (operationNumber == 1) {

                int size1 = L.size();
                int size2 = B.size();

            } else if (operationNumber == 2) {

                if (L.size() > 0) {
                    int last1 = L.getLast();
                    int last2 = B.getLast();


                }
            } else if (operationNumber == 3) {

                if (L.size() > 0) {
                    int removed1 = L.removeLast();
                    int removed2 = B.removeLast();
          
                }
            }
        }
    }

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> testlist1 = new  AListNoResizing<Integer>();
        BuggyAList<Integer> testlist2 = new BuggyAList<Integer>();

        testlist1.addLast(4);
        testlist1.addLast(5);
        testlist1.addLast(6);
        int actual1 =testlist1.removeLast();
        assertEquals(6, actual1);
        int actual2 =testlist1.removeLast();
        assertEquals(5, actual2);
        int actual3 =testlist1.removeLast();
        assertEquals(4, actual3);

        testlist2.addLast(4);
        testlist2.addLast(5);
        testlist2.addLast(6);
        int actual4 =testlist2.removeLast();
        assertEquals(6, actual4);
        int actual5 =testlist2.removeLast();
        assertEquals(5, actual5);
        int actual6 =testlist2.removeLast();
        assertEquals(4, actual6);




    }



}
