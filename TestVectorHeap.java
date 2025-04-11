import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Vector;

public class TestVectorHeap {
    
    @Test
    public void testAddAndRemoveSingleElement() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(5);
        assertEquals(1, heap.size());
        assertEquals(Integer.valueOf(5), heap.remove());
        assertTrue(heap.isEmpty());
    }
    
  

    
    @Test
    public void testAddAndRemoveRandomOrder() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(5);
        heap.add(1);
        heap.add(3);
        heap.add(4);
        heap.add(2);
        
        assertEquals(5, heap.size());
        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(2), heap.remove());
        assertEquals(Integer.valueOf(3), heap.remove());
        assertEquals(Integer.valueOf(4), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testRemoveFromEmptyHeap() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.remove();
    }
    
    @Test
    public void testAddPacientes() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        heap.add(new Paciente("Juan", "Fractura", 'C'));
        heap.add(new Paciente("Maria", "Apendicitis", 'A'));
        heap.add(new Paciente("Luis", "Dolor cabeza", 'E'));
        
        assertEquals('A', heap.remove().getCodigoEmergencia());
        assertEquals('C', heap.remove().getCodigoEmergencia());
        assertEquals('E', heap.remove().getCodigoEmergencia());
    }
    
    @Test
    public void testConstructorWithVector() {
        Vector<Integer> vector = new Vector<>();
        vector.add(3);
        vector.add(1);
        vector.add(2);
        
        VectorHeap<Integer> heap = new VectorHeap<>(vector);
        assertEquals(Integer.valueOf(1), heap.remove());
        assertEquals(Integer.valueOf(2), heap.remove());
        assertEquals(Integer.valueOf(3), heap.remove());
    }
}