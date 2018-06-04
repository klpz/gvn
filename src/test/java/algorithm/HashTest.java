package algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import algorithm.*;


public class HashTest extends Assert{
    HashTable table;
    @Before
    public void setUp() throws Exception {
        table = new HashTable(25);
    }

    @After
    public void tearDown() throws Exception {
        table.makeEmpty();
    }

    @Test
    public void test1() {    //simple insert and find
        int testValue = 5;
        table.insert("testKey", 5);
        assertEquals(table.get("testKey"), testValue);
    }

    @Test
    public void test2(){    //insert delete find
        int testValue = -1;
        table.insert("testKey", 5);
        table.remove("testKey");
        assertEquals(table.get("testKey"), testValue);
    }

    @Test
    public void test3(){    //insert several entries and find
        int testValue = 6;
        table.insert("testKey1", 5);
        table.insert("testKey2", 6);
        table.insert("testKey3", 7);
        assertEquals(table.get("testKey2"), testValue);
    }

    @Test
    public void test4(){    //insert several entries with same key and find
        int testValue = 8;
        table.insert("testKey1", 5);
        table.insert("testKey2", 6);
        table.insert("testKey3", 7);
        table.insert("testKey3", 8);
        assertEquals(table.get("testKey3"), testValue);
    }

    @Test
    public void test5() {    //insert several entries in one bucket and find
        int testValue = 7;
        table.insert("testKey1", 5);
        table.insert("testKey3", 7);
        table.insert("testKe3y", 8);
        table.insert("te3stKe3y", 9);
        table.insert("tefstKe3y", 10);
        assertEquals(table.get("testKey3"), testValue);
    }

    @Test
    public void test6() {    //insert several entries in one bucket and deleting one entrie in middle of chain
        int testValue = 3;
        table.insert("te3stjiomnbqsKe3y", 1);
        table.insert("te3stjiomnbKe3y", 2);
        table.insert("teestKe3y", 3);
        table.remove("te3stjiomnbKe3y");
        assertEquals(table.get("teestKe3y"), testValue);
    }

    @Test
    public void test7() {    //insert several entries in one bucket and deleting one entrie in head of chain
        int testValue = 3;
        table.insert("te3stjiomnbqsKe3y", 1);
        table.insert("te3stjiomnbKe3y", 2);
        table.insert("teestKe3y", 3);
        table.remove("te3stjiomnbqsKe3y");
        assertEquals(table.get("teestKe3y"), testValue);
    }
}
