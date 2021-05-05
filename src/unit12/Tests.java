package unit12;

import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void checkSignedNumber(){
        int e = Integer.decode("21");
        int el = Integer.decode("-#A");
        int ele = Integer.decode("+21");
        assertEquals(e, 21);
        assertEquals(el, -10);
        assertEquals(ele, 21);
    }
    @Test
    public void check16Based(){
        int e = Integer.decode("0X21");
        int el = Integer.decode("0x83");
        int ele = Integer.decode("#46");
        int elem = Integer.decode("0xaF");
        assertEquals(e, 33);
        assertEquals(el, 131);
        assertEquals(ele, 70);
        assertEquals(elem, 175);
    }
    @Test
    public void check8Based(){
        int e = Integer.decode("021");
        assertEquals(e, 17);
    }
    @Test(expected = Exception.class)
    public void catchException8Based(){
        Integer.decode("08");
    }
    @Test(expected = Exception.class)
    public void catchExceptionOnSignInMiddle(){
        Integer.decode("0x-1");
    }
    @Test(expected = Exception.class)
    public void catchExceptionOnUnknownSymbol(){
        Integer.decode("0XOOP");
    }
    @Test(expected = Exception.class)
    public void catchExceptionOn16BasedWithoutPrefix(){
        Integer.decode("CD");
    }
    @Test(expected = Exception.class)
    public void catchExceptionOnEmpty(){
        Integer.decode("");
    }
    @Test(expected = Exception.class)
    public void catchExceptionOnNull(){
        Integer.decode(null);
    }
}
