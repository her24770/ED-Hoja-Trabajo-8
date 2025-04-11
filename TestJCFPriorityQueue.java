import org.junit.Test;
import static org.junit.Assert.*;

public class TestJCFPriorityQueue {
    
    @Test
    public void testAddAndRemoveSingleElement() {
        JCFPriorityQueue<Integer> queue = new JCFPriorityQueue<>();
        queue.add(5);
        assertEquals(1, queue.size());
        assertEquals(Integer.valueOf(5), queue.remove());
        assertTrue(queue.isEmpty());
    }

    
    @Test
    public void testAddMultipleElementsReverseOrder() {
        JCFPriorityQueue<Integer> queue = new JCFPriorityQueue<>();
        queue.add(3);
        queue.add(2);
        queue.add(1);
        
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(Integer.valueOf(2), queue.remove());
        assertEquals(Integer.valueOf(3), queue.remove());
    }
    
    @Test
    public void testAddAndRemoveRandomOrder() {
        JCFPriorityQueue<Integer> queue = new JCFPriorityQueue<>();
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(2);
        
        assertEquals(5, queue.size());
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(Integer.valueOf(2), queue.remove());
        assertEquals(Integer.valueOf(3), queue.remove());
        assertEquals(Integer.valueOf(4), queue.remove());
        assertEquals(Integer.valueOf(5), queue.remove());
    }
    
    @Test
    public void testAddPacientes() {
        JCFPriorityQueue<Paciente> queue = new JCFPriorityQueue<>();
        queue.add(new Paciente("Juan", "Fractura", 'C'));
        queue.add(new Paciente("Maria", "Apendicitis", 'A'));
        queue.add(new Paciente("Luis", "Dolor cabeza", 'E'));
        
        assertEquals('A', queue.remove().getCodigoEmergencia());
        assertEquals('C', queue.remove().getCodigoEmergencia());
        assertEquals('E', queue.remove().getCodigoEmergencia());
    }
    
    @Test
    public void testClear() {
        JCFPriorityQueue<Integer> queue = new JCFPriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}