/**
 * PriorityQueue interface, Definicion de funciones aplicables a una cola de prioridad
 */

 public interface InterfacePriorityQueue<E extends Comparable<E>> {
    public E getFirst();
    public E remove();
    public void add(E value);
    public boolean isEmpty();
    public int size();
    public void clear();
}