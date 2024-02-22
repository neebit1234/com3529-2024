package uk.ac.shef.com3529;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DIFTest {

    @Test
    public void findLast_failure() {
        int[] x = {1,2,3};
        int y = 1;
        assertEquals(DIF.findLast(x, y), 0);
    }

    @Test
    public void findLast_defectNotExecuted() {
        int[] x = {1,2,3};
        int y = 2;
        assertEquals(DIF.findLast(x, y), 1);
    }

//    @Test
//    public void countPositive_failure() {
//        int[] x = {1,2,3};
//        assertEquals(DIF.countPositive(x), 3);
//    }

//    @Test
//    public void lastZero_failure() {
//        int[] x = {1,2,3};
//        int y = 1;
//        assertEquals(DIF.findLast(x, y), 0);
//    }
//
//    @Test
//    public void oddOrPos_failure() {
//        int[] x = {1,2,3};
//        int y = 1;
//        assertEquals(DIF.findLast(x, y), 0);
//    }
}
