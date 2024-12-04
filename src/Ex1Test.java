//student name: Snir Nachmany
//ID: 322593047


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() { //check if base<2 or base>16 or num<0 return empty string
            assertEquals("",Ex1.int2Number(34,17));
            assertEquals("",Ex1.int2Number(34,1));
            assertEquals("",Ex1.int2Number(-1,5));
        }
    @Test
    void int2NumberTest1() { //check all base with different num
        assertEquals("22bG",Ex1.int2Number(34,16));
        assertEquals("0bG",Ex1.int2Number(0,16));
        assertEquals("1bG",Ex1.int2Number(1,16));
        assertEquals("EFbG",Ex1.int2Number(239,16));
        assertEquals("15bF",Ex1.int2Number(20,15));
        assertEquals("1DbE",Ex1.int2Number(27,14));
        assertEquals("5bD",Ex1.int2Number(5,13));
        assertEquals("71bC",Ex1.int2Number(85,12));
        assertEquals("30bB",Ex1.int2Number(33,11));
        assertEquals("1000bA",Ex1.int2Number(1000,10));
        assertEquals("121b9",Ex1.int2Number(100,9));
        assertEquals("6626b8",Ex1.int2Number(3478,8));
        assertEquals("10b7",Ex1.int2Number(7,7));
        assertEquals("0b6",Ex1.int2Number(0,6));
        assertEquals("40b5",Ex1.int2Number(20,5));
        assertEquals("11b4",Ex1.int2Number(5,4));
        assertEquals("22b3",Ex1.int2Number(8,3));
        assertEquals("10110b2",Ex1.int2Number(22,2));
        String s = Ex1.int2Number(22,8);
        assertEquals( s,"26b8");
        String t = Ex1.int2Number(16,16);
        assertEquals( t, "10bG");
        }
        @Test
        void maxIndexTest() {
            String[] numbers = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
           assertEquals(4,Ex1.maxIndex(numbers));
           String[] numbers1 = {"100bA","76b9", "12b6","BbF","101100b2","144b8"};
           assertEquals(0,Ex1.maxIndex(numbers1));

        }

    @Test
    void testEquals() {
        assertTrue(Ex1.equals("954bC","954bC"));
        assertFalse(Ex1.equals("954bC","954bB"));
        assertTrue(Ex1.equals("1011b2","11bA"));

    }

    @Test
    void goodChar() {
    }

    @Test
    void beginOfNum() {
    }

    @Test
    void endOfNum() {
    }

    // Add additional test functions - test as much as you can.
    }
