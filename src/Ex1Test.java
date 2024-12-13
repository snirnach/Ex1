//student name: Snir Nachmany
//ID: 322593047


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("1000",Ex1.int2Number(1000,10));
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
        assertNotEquals("2134b9", Ex1.int2Number(354, 6));
        assertNotEquals("10b16", Ex1.int2Number(10, 16));
        assertNotEquals("3bA", Ex1.int2Number(3, 10));
        }
        @Test
        void maxIndexTest() {
            String[] numbers = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
           assertEquals(4,Ex1.maxIndex(numbers));
           String[] numbers1 = {"100bA","76b9", "12b6","BbF","101100b2","144b8"};
           assertEquals(0,Ex1.maxIndex(numbers1));
            String[] number = {"100"}; // array with one element
            assertEquals(0, Ex1.maxIndex(number));
            String[] numbers3 = {"10","20b5","1010b2","AbC","11b9"}; // array all numbers equals
            assertEquals(0,Ex1.maxIndex(numbers3));

            assertNotEquals(2,Ex1.maxIndex(numbers));
            assertNotEquals(2,Ex1.maxIndex(number));
        }

    @Test
    void testEquals() {
        assertTrue(Ex1.equals("954bC","954bC"));
        assertFalse(Ex1.equals("954bC","954bB")); // same num different base
        assertFalse(Ex1.equals("0","954bB"));// 0 with another num
        assertTrue(Ex1.equals("1011b2","11bA"));
        assertTrue(Ex1.equals("007bB","7b8"));

    }

    @Test
    void goodChar() {
        char[] goodChars = {'0', '5', '9', 'C', 'G'};
       for (int i=0; i< goodChars.length;i++){
           boolean ok = Ex1.goodChar(goodChars[i]);
           assertTrue(ok);
       }

        char[] notGoodChars = {'H', 'a', '$', '[', ' '};
       for (int i=0; i< notGoodChars.length;i++){
           boolean not_good = Ex1.goodChar(notGoodChars[i]);
           assertFalse(not_good);
       }

    }

    @Test
    void beginOfNum() {
        assertEquals("123", Ex1.beginOfNum("123b456"));
        assertEquals("", Ex1.beginOfNum("b456"));
        assertEquals("456", Ex1.beginOfNum("456b"));
        assertEquals("", Ex1.beginOfNum("b"));
        assertEquals("123", Ex1.beginOfNum("123bb6b"));
        assertEquals("123", Ex1.beginOfNum("123"));

    }

    @Test
    void endOfNum() {
        assertEquals('5', Ex1.endOfNum("12345"));
        assertEquals('C', Ex1.endOfNum("12cdC"));
        assertEquals('g', Ex1.endOfNum("123g"));
        assertEquals(' ', Ex1.endOfNum(""));
    }

    @Test
    void fixnum() {
        assertEquals("A", Ex1.fixnum(10));
        assertEquals("B", Ex1.fixnum(11));
        assertEquals("C", Ex1.fixnum(12));
        assertEquals("D", Ex1.fixnum(13));
        assertEquals("E", Ex1.fixnum(14));
        assertEquals("F", Ex1.fixnum(15));
        assertEquals("G", Ex1.fixnum(16));
        assertEquals("9", Ex1.fixnum(9)); // check random number
        assertEquals("0", Ex1.fixnum(0));// check 0

        assertNotEquals("11",Ex1.fixnum(11));
        assertNotEquals("8",Ex1.fixnum(5));
        }

    }
