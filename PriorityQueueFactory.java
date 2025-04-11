/**
 * Factory para crear colas de prioridad.
 * Permite crear colas de prioridad usando VectorHeap o JCFPriorityQueue.
 */

public class PriorityQueueFactory {

    public static <E extends Comparable<E>> InterfacePriorityQueue<E> createPriorityQueue(String type) {
        switch (type) {
            case "1":
                return new VectorHeap<>();
            case "2":
                return new JCFPriorityQueue<>();
            default:
                throw new IllegalArgumentException("Tipo de cola no soportado");
        }
    }
}