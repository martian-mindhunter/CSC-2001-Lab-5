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

    @Test
    void testLLStackTime(){
        for(int t = 100; t <= 1000; t += 100) {

            int currentN = 1;
            int priorN = 0;

            while (true) {

                LLStack testStack = new LLStack(new Pair("elt", null));

                long startTime = System.nanoTime();

                for (int i = 0; i < currentN; i++) {
                    testStack.push("elt");
                }

                for (int i = 0; i < currentN; i++) {
                    testStack.pop();
                }

                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000;

                if (duration > t) {
                    if (priorN == 0) {
                        IO.println("1 elt was > " + t + " ms\n");
                    } else {
                        IO.println(t + " ms: Largest sequence under limit is: " + priorN + " elts\n");
                    }
                    break;
                }

                priorN = currentN;
                currentN *= 2;

            }
        }
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

    @Test
    void testAStackTime(){
        for(int t = 100; t <= 1000; t += 100) {

            int currentN = 1;
            int priorN = 0;

            while (true) {

                AStack testStack = new AStack(new String[currentN]);

                long startTime = System.nanoTime();

                for (int i = 0; i < currentN; i++) {
                    testStack.push("elt");
                }

                for (int i = 0; i < currentN; i++) {
                    testStack.pop();
                }

                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000;

                if (duration > t) {
                    if (priorN == 0) {
                        IO.println("1 elt was > " + t + " ms\n");
                    } else {
                        IO.println(t + " ms: Largest sequence under limit is: " + priorN + " elts\n");
                    }
                    break;
                }

                priorN = currentN;
                currentN *= 2;

            }
        }
    }

    // LLQueue Tests
    LLQueue llQueueA = new LLQueue(new Pair("a", new Pair("b", new Pair("c", null))));

    @Test
    void testLLQueueEquals(){
        assertTrue(llQueueA.equals( new LLQueue(new Pair("a", new Pair("b", new Pair("c", null))))));
        assertFalse(llQueueA.equals(new LLQueue(new Pair("a", null))));
        // Empty Test
        LLQueue empty = new LLQueue();
        assertTrue(empty.equals(LLQueue.empty_queue()));

    }

    @Test
    void testLLQueueEnqueue(){
        llQueueA.enqueue("d");
        LLQueue llQueueD = new LLQueue(new Pair("a", new Pair("b", new Pair("c", new Pair("d", null)))));
        assertTrue(llQueueA.equals(llQueueD));
        LLQueue empty = LLQueue.empty_queue();
        empty.enqueue("z");
        assertFalse(empty.equals(llQueueD));
        assertTrue(empty.equals(new LLQueue(new Pair("z", null))));

    }

    @Test
    void testLLQueueDequeue(){
        String elt = llQueueA.dequeue();
        assertEquals("a", elt);
        LLQueue empty = LLQueue.empty_queue();
        assertThrows(NoSuchElementException.class, () -> {
            empty.dequeue();
        });
    }

    @Test
    void testLLQueuePeek(){
        String top = llQueueA.peek();
        assertEquals("a", top);
        LLQueue empty = LLQueue.empty_queue();
        assertThrows(NoSuchElementException.class, () -> {
            empty.peek();
        });
    }

    @Test
    void testLLQueueSize(){
        int targetSize = 3;
        assertEquals(targetSize, llQueueA.size());
        llQueueA.enqueue("d");
        assertFalse(targetSize != llQueueA.size());
    }

    @Test
    void testLLQueueIsEmpty(){
        LLQueue empty = LLQueue.empty_queue();
        assertTrue(empty.is_empty());
        assertFalse(llQueueA.is_empty());
    }


    // Tests for AQueue
    AQueue aQueueA = new AQueue(new String[]{"a", "b", "c"});

    @Test
    void testAQueueEquals(){
        assertTrue(aQueueA.equals(new AQueue(new String[]{"a", "b", "c"})));
        AQueue aQueueB = new AQueue(new String[]{"a", "b"});
        assertFalse(aQueueA.equals(aQueueB));
    }

    @Test
    void testAQueueEmpty(){
        assertFalse(aQueueA.equals(AQueue.empty_queue()));
        AQueue empty = AQueue.empty_queue();
        assertTrue(empty.equals(new AQueue()));
        assertTrue(empty.equals(new AQueue(null)));
    }

    @Test
    void testAQueueEnqueue(){
        AQueue aQueueD = new AQueue(new String[]{"a", "b", "c", "d"});
        aQueueA.enqueue("d");
        assertTrue(aQueueA.equals(aQueueD));
        AQueue empty = AQueue.empty_queue();
        empty.enqueue("z");
        assertTrue(empty.equals(new AQueue(new String[]{"z"})));
    }

    @Test
    void testAQueueDequeue(){
        String elt = aQueueA.dequeue();
        assertEquals("a", elt);
        assertTrue(aQueueA.equals(new AQueue(new String[]{"b", "c"})));
        AQueue empty = AQueue.empty_queue();
        assertThrows(NoSuchElementException.class, () -> {
            empty.dequeue();
        });
    }

    @Test
    void testAQueuePeek(){
        String elt = aQueueA.peek();
        assertEquals("a", elt);
        AQueue empty = AQueue.empty_queue();
        assertThrows(NoSuchElementException.class, () -> {
            empty.peek();
        });
    }

    @Test
    void testAQueueSize(){
        int targetSize = aQueueA.size();
        assertEquals(3, targetSize);
        AQueue empty = AQueue.empty_queue();
        assertThrows(NoSuchElementException.class, () -> {
            empty.size();
        });
    }

    @Test
    void testAQueueIsEmpty(){
        AQueue empty = AQueue.empty_queue();
        assertFalse(aQueueA.is_empty());
        assertTrue(empty.is_empty());
    }

}
