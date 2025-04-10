/**
 * Clase con el control de la cola de prioridad, basada en un arbol de prioridad
 * Codigo basado en material de estudio en clase de Estructura de Datos en Universidad del Valle de Guatemala
 */
import java.util.LinkedList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private LinkedList<E> data;

    public VectorHeap() {
        data = new LinkedList<>();
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data.getFirst();
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data.removeFirst();
    }

    @Override
    public void add(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot add null to priority queue");
        }
        
        int index = 0;
        while (index < data.size() && value.compareTo(data.get(index)) > 0) {
            index++;
        }
        data.add(index, value);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}