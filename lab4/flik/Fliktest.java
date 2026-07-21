package flik;


import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class Fliktest {

    @Test
    public void testIsSameNumber(){

           assertTrue( Flik.isSameNumber(1,1));


           assertTrue(Flik.isSameNumber(128,128));
        }


}
