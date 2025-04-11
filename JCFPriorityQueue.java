/**
 * Mofdificacion de la clase PriorityQueue de Java Collections Framework (JCF)
 * para implementar la interfaz InterfacePriorityQueue.
 */
import java.util.PriorityQueue;

public class JCFPriorityQueue<E extends Comparable<E>> implements InterfacePriorityQueue<E> {
    private PriorityQueue<E> jcfQueue;

    public JCFPriorityQueue() {
        jcfQueue = new PriorityQueue<>();
    }

    @Override
    public E getFirst() {
        return jcfQueue.peek();
    }

    @Override
    public E remove() {
        return jcfQueue.poll();
    }

    @Override
    public void add(E value) {
        jcfQueue.add(value);
    }

    @Override
    public boolean isEmpty() {
        return jcfQueue.isEmpty();
    }

    @Override
    public int size() {
        return jcfQueue.size();
    }

    @Override
    public void clear() {
        jcfQueue.clear();
    }
}