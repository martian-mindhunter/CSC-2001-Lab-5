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
        assertEquals(llStackA, llStackB);
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
        assertEquals(test, llStackA);
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
        assertEquals(test, llStackA);
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
    AStack aStackA = new AStack(new String[]{"a", "b", "c"}, 3);

    @Test
    void testAStackEquals() {
        AStack aStackB = new AStack(new String[]{"a", "b", "c"}, 3);
        assertTrue(aStackA.equals(aStackB));
    }

    @Test
    void testAStackEmptyStack(){
        AStack empty = AStack.empty_stack();
        System.out.println(Arrays.toString(empty.astackList));
        assertTrue(empty.equals(new AStack()));
        assertFalse(aStackA.equals(empty));
    }

    @Test
    void testAStackPush(){
        System.out.println(Arrays.toString(aStackA.astackList));
        aStackA.push("z");
        System.out.println(Arrays.toString(aStackA.astackList));
//        assertFalse(aStackA.equals(new AStack(new String[]{"z", "a", "b", "c"}, 4)));
        assertNotEquals(Arrays.toString(aStackA.astackList), Arrays.toString((new AStack(new String[]{"a", "b", "c", "z"}, 4).astackList)));
        assertEquals(Arrays.toString(aStackA.astackList), Arrays.toString((new AStack(new String[]{"a", "b", "c", "z", null, null}, 4).astackList)));
        assertEquals(new AStack(new String[]{"a", "b", "c", "z", null, null}, 4), aStackA);
//        assertTrue(aStackA.equals(new AStack(new String[]{"a", "b", "c", "z", null, null}, 4)));
        // pushing to an empty astack
        AStack empty = AStack.empty_stack();
        System.out.println(Arrays.toString(empty.astackList));
        empty.push("a");
        assertTrue(empty.equals(new AStack(new String[]{"a"}, 1)));
    }

//    @Test
//    void testFoo(){
//        int arr[] = {5, 6, 7, 8, 0, 0};
//    }
    // TO DO:
    // :)  make push go at the end of the AStack not the beginning
    // :)  fix the constructor to have Live element counter
    // study for midterm by studying questions similar to quizzes
    // identify running time & operations

    @Test
    void testAStackPop(){
        String top = aStackA.pop();
        assertEquals("c",top);
//        assertFalse(aStackA.equals(new AStack(new String[]{"b", "c"}, 2)));
//        assertTrue(aStackA.equals(new AStack(new String[]{"a", "b"}, 2)));
        assertEquals(new AStack(new String[]{"a", "b", null}, 2), aStackA);
        // empty pop check
        AStack empty = AStack.empty_stack();
        assertThrows(NoSuchElementException.class, () -> {
            empty.pop();
        });
    }

    @Test
    void testAStackPeek(){
        String top = aStackA.peek();
        assertEquals("c",top);
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
        aStackA.pop();
        assertEquals(2, aStackA.size());
        aStackA.push("c");
        aStackA.push("d");
        assertEquals(4, aStackA.size());
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

                AStack testStack = new AStack(new String[currentN], currentN);

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
//    LLQueue llQueueA = new LLQueue(new Pair("a", new Pair("b",
//            new Pair("c", null))));
    LLQueue llQueueA = new LLQueue(new Pair("a", new Pair("b", null)),
        new Pair("c", null));
//    LLQueue llQueueB = new LLQueue(new Pair("a", new Pair("b", new Pair("c", null))));
    LLQueue llQueueB = new LLQueue(new Pair("a", new Pair("b", null)),
        new Pair("c", null));

    @Test
    void testLLQueueEquals(){
//        assertTrue(llQueueA.equals( new LLQueue(new Pair("a", new Pair("b", new Pair("c", null))))));
//        assertFalse(llQueueA.equals(new LLQueue(new Pair("a", null))));
        // Empty Test
        LLQueue empty = new LLQueue();
//        assertTrue(empty.equals(LLQueue.empty_queue()));
        assertEquals(llQueueA, llQueueB);
        assertEquals(empty, new LLQueue());

    }

    @Test
    void testLLQueueEnqueue(){
        llQueueA.enqueue("d");
        LLQueue llQueueD = new LLQueue(new Pair("a", new Pair("b", null)),
                new Pair("d", new Pair("c", null)));
//        System.out.println(Arrays.toString(llQueueA.llqueueHead));
        assertEquals(llQueueA, llQueueD);
        LLQueue empty = LLQueue.empty_queue();
        empty.enqueue("z");
        assertEquals(empty, new LLQueue(null,
                new Pair("z", null)));

    }

    @Test
    void testLLQueueDequeue(){
        String elt = llQueueA.dequeue();
        System.out.println(elt);
        assertEquals(new LLQueue(new Pair("b", null),
                new Pair("c", null)), llQueueA);
        assertEquals("a", elt);
        elt = llQueueA.dequeue();
        assertEquals("b", elt);
        assertEquals(new LLQueue(null, new Pair("c", null)), llQueueA);
        elt = llQueueA.dequeue();
        assertEquals("c", elt);
        assertEquals(new LLQueue(null, null), llQueueA);

        LLQueue fourLength = new LLQueue(null, new Pair("d", new Pair("c", null)));
        LLQueue test = fourLength;
        elt = fourLength.dequeue();
        assertEquals("c", elt);
        assertEquals(new LLQueue(new Pair("d", null), null), fourLength);
        elt = fourLength.dequeue();
        assertEquals("d", elt);
        assertEquals(new LLQueue(null, null), fourLength);

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
        assertNotEquals(targetSize, llQueueA.size());
    }

    @Test
    void testLLQueueIsEmpty(){
        LLQueue empty = LLQueue.empty_queue();
        assertTrue(empty.is_empty());
        assertFalse(llQueueA.is_empty());
    }


    // Tests for AQueue
    AQueue aQueueA = new AQueue(new String[]{"a", "b", "c"}, 3, 0, 4);

    @Test
    void testAQueueEquals(){
        assertEquals(aQueueA, new AQueue(new String[]{"a", "b", "c"}, 3, 0, 4));
        AQueue aQueueB = new AQueue(new String[]{"a", "b"}, 2, 0, 4);
//        assertFalse(aQueueA.equals(aQueueB));
        assertNotEquals(aQueueA, aQueueB);
        aQueueB.enqueue("c");
//        System.out.println(Arrays.toString(aQueueA.aqueueList));
//        aQueueA.enqueue(null);
//        System.out.println(Arrays.toString(aQueueA.aqueueList));
//        System.out.println(Arrays.toString(aQueueB.aqueueList));
        assertEquals(aQueueA, aQueueB);
        assertEquals(new AQueue(new String[]{"a", "b", "c"}, 3, 0, 4), aQueueB);
    }

    @Test
    void testAQueueEmpty(){
        assertEquals(AQueue.empty_queue(0), new AQueue());
        AQueue empty = AQueue.empty_queue(0);
        assertEquals(empty, AQueue.empty_queue(0));
        assertNotEquals(aQueueA, empty);
    }

    @Test
    void testAQueueEnqueue() {
        AQueue aQueueD = new AQueue(new String[]{"a", "b", "c", "d"}, 4, 0, 4);
        aQueueA.enqueue("d");
        System.out.println(Arrays.toString(aQueueA.aqueueList));
        assertEquals(aQueueA, aQueueD);
        AQueue empty = AQueue.empty_queue(1);
        empty.enqueue("z");
        assertEquals(empty, new AQueue(new String[]{"z"}, 1, 0, 1));
        AQueue midQueue = new AQueue(new String[]{null, "a", "b", null}, 2, 1, 4);
        midQueue.enqueue("c");
        System.out.println(Arrays.toString(midQueue.aqueueList));
        assertEquals(new AQueue(new String []{"c", "a", "b", null}, 3, 0, 4), midQueue);
        assertThrows(IllegalStateException.class, () -> {
            aQueueD.enqueue("x");
        });
    }

    @Test
    void testAQueueDequeue(){
        String elt = aQueueA.dequeue();
        assertEquals("a", elt);
//        assertTrue(aQueueA.equals(new AQueue(new String[]{"b", "c"}, 2)));
        System.out.println(Arrays.toString(aQueueA.aqueueList));
        assertEquals(new AQueue(new String[]{null, "b", "c", null}, 2, 1, 4), aQueueA);
        AQueue empty = AQueue.empty_queue(0);
        assertThrows(NoSuchElementException.class, () -> {
            empty.dequeue();
        });
    }

    @Test
    void testAQueuePeek(){
        String elt = aQueueA.peek();
        assertEquals("a", elt);
        AQueue empty = AQueue.empty_queue(0);
        assertThrows(NoSuchElementException.class, () -> {
            empty.peek();
        });
    }

    @Test
    void testAQueueSize(){
        int targetSize = aQueueA.size();
        assertEquals(3, targetSize);
        AQueue empty = AQueue.empty_queue(0);
        assertThrows(NoSuchElementException.class, () -> {
            empty.size();
        });
    }

    @Test
    void testAQueueIsEmpty(){
        AQueue empty = AQueue.empty_queue(0);
        assertFalse(aQueueA.is_empty());
        assertTrue(empty.is_empty());
    }

}
