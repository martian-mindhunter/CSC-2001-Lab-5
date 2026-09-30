import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    LLStack llStackA = new LLStack( new Pair("a", new Pair("b", new Pair("c", null))));

    @Test
    void testLLStackEquals() {
        LLStack llStackB = new LLStack( new Pair( "a", new Pair("b", new Pair("c", null))));
        System.out.println(llStackA);
        System.out.println(llStackB);
        assertTrue(llStackA.equals(llStackB));
    }

    @Test
    void testLLStackEmptyStack() {
        LLStack empty = new LLStack();
        assertTrue(empty.equals(new LLStack()));
    }

}
