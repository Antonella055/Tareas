package Estructuras;


/**
 * Clase que representa un nodo en una lista enlazada
 * @author Antonella
 * @param <T>  tipo de dato almacenado en el nodo
 */
public class Node <T>{
    private T data;
    private Node next;
    

    public Node(T element) {
        this.data = element;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T element) {
        this.data = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}