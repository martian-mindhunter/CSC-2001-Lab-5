import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // LLStack Tests
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
        LLStack emptyMethod = LLStack.empty_stack();
        assertTrue(empty.equals(emptyMethod));
    }

    @Test
    void testLLStackPush() {
        // adding to populated stack
        llStackA.push("z");
        LLStack test = new LLStack( new Pair("z", new Pair("a", new Pair("b", new Pair("c", null)))));
        assertTrue(llStackA.equals(test));
        // adding to an empty stack
        test = LLStack.empty_stack();
        test.push("first");
        assertTrue(test.equals(new LLStack( new Pair("first", null))));
    }

    @Test
    void testLLStackPop() {
        // popping populated stack
        String popElt = llStackA.pop();
        LLStack test = new LLStack( new Pair("b", new Pair( "c", null)));
        assertTrue(llStackA.equals(test));
        assertEquals(popElt, "a");
        // popping empty stack (error test)
        LLStack empty = LLStack.empty_stack();
        assertThrows(NoSuchElementException.class, () -> {
            empty.pop();
        });
    }

    @Test
    void testLLStackPeek() {
        String peekElt = llStackA.peek();
        assertEquals(peekElt, "a");
        // peeking empty stack
        LLStack empty = LLStack.empty_stack();
        assertThrows(NoSuchElementException.class, () -> {
            empty.peek();
        });
    }

    @Test
    void testLLStackSize() {
        assertEquals(3, llStackA.size());
        // size empty stack
        LLStack empty = LLStack.empty_stack();
        assertEquals(0, empty.size());
    }

    @Test
    void testLLStackIsEmpty() {
        assertFalse(llStackA.is_empty());
        LLStack empty = LLStack.empty_stack();
        assertTrue(empty.is_empty());
    }

    // AStack Tests
    AStack aStackA = new AStack(new String[]{"a", "b", "c"});

    @Test
    void testAStackEquals() {
        AStack aStackB = new AStack(new String[]{"a", "b", "c"});
        assertTrue(aStackA.equals(aStackB));
    }

    @Test
    void testAStackEmptyStack(){
        AStack empty = AStack.empty_stack();
        assertTrue(empty.equals(new AStack()));
        assertFalse(aStackA.equals(empty));
    }

    @Test
    void testAStackPush(){
        aStackA.push("z");
        System.out.println(Arrays.toString(aStackA.astackList));
        assertTrue(aStackA.equals(new AStack(new String[]{"z", "a", "b", "c"})));
        // pushing to an empty astack
        AStack empty = AStack.empty_stack();
        System.out.println(Arrays.toString(empty.astackList));
        empty.push("a");
        assertTrue(empty.equals(new AStack(new String[]{"a"})));
    }

    @Test
    void testAStackPop(){
        String top = aStackA.pop();
        assertEquals("a",top);
        assertTrue(aStackA.equals(new AStack(new String[]{"b", "c"})));
        // empty pop check
        AStack empty = AStack.empty_stack();
        assertThrows(NoSuchElementException.class, () -> {
            empty.pop();
        });
    }

    @Test
    void testAStackPeek(){
        String top = aStackA.peek();
        assertEquals("a",top);
        // empty peek check
        AStack empty = AStack.empty_stack();
        assertThrows(NoSuchElementException.class, () -> {
            empty.peek();
        });
    }

    @Test
    void testAStackSize(){
        int size = aStackA.size();
        assertEquals(3, size);
    }

    @Test
    void testAStackIsEmpty(){
        AStack empty = AStack.empty_stack();
        assertTrue(empty.is_empty());
        assertFalse(llStackA.is_empty());
    }

}
