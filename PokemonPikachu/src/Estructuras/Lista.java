/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;



/**
 *
 * @author Giuseppe Vaccaro
 * @param <T>
 */
public class Lista <T> {
    //--------------------/ Atributos /---------------------
    private Nodo cabeza;
    private Nodo cola;
    private int numElementos;
    
    //--------------------/ Constructores /-----------------------
    /**
     * Constructor de la clase List
     * inicia una lista vacia
     */
    public Lista() {
        this.cabeza = null;
        this.cola = null;
        this.numElementos = 0;
    }
    
    /**
     * Constructor de la clase List
     * inicia una lista con elementos
     * @param datos 
     */
    public Lista(T... datos){
        for(T dato: datos){
            agregarFinal(dato);
        }
    }
    
    //------------------/ Metodos /-----------------
    /**
     * Obtiene el primer elemento de la lista
     * @return 
     */
    public Nodo getCabeza() {
        return cabeza;
    }
    
    /**
     * Cambia el primer elemento de la lista
     * @param cabeza 
     */
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    /**
     * Obtiene el ultimo elemento de la lista
     * @return 
     */
    public Nodo getCola() {
        return cola;
    }
    
    /**
     * Cambia el ultimo elemento de la lista
     * @param cola 
     */
    public void setCola(Nodo cola) {
        this.cola = cola;
    }
    
    /**
     * Obtiene el numero de elementos
     * @return 
     */
    public int getNumElementos() {
        return numElementos;
    }
    
    /**
     * Cambia el numero de elementos
     * @param elementos 
     */
    public void setNumElementos(int elementos) {
        this.numElementos = elementos;
    }
    
    /**
     * Retorna el ultimo indice de la lista
     * @return 
     */
    public int getUltimoIndice(){
        return numElementos-1;
    }
    
    /**
     * Borra todos los elementos de la lista
     */
    public void vaciarLista(){
        cabeza = cola = null;
        numElementos = 0;
    }
    
    /**
     * Retorna true si la lista no tiene elementos
     * Retorna false si la lista tiene al menos un elemento
     * @return 
     */
    public boolean esVacio(){
        return cabeza == null;
    }
    
    /**
     * Agrega un elemento al final de la lista
     * @param dato 
     */
    public void agregarFinal(T dato){
        Nodo nuevo = new Nodo(dato);
        if(esVacio()){
            cabeza = cola = nuevo;
        }
        else{
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        numElementos++;
    }
    
    /**
     * Agrega un elemento al inicio de la lista
     * @param dato 
     */
    public void agregarInicio(T dato){
        Nodo nuevo = new Nodo(dato);
        if(esVacio()){
            cabeza = cola = nuevo;
        }
        else{
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        }
        numElementos++;
    }
    
    /**
     * Inserta un elemento en la lista dado un indice
     * @param dato
     * @param indice 
     */
    public void insertar(T dato, int indice){
        if(esVacio()){
            agregarFinal(dato);
        }
        else{
            if(indice < 0 || indice >= numElementos){
                System.out.println("Indice fuera de rango");
            }
            else{
                Nodo nuevo = new Nodo(dato);
                Nodo apuntador = cabeza;
                for (int i = 0; i < numElementos-1; i++) {
                    apuntador = apuntador.getSiguiente();
                }
                
                nuevo.setSiguiente(apuntador.getSiguiente());
                apuntador.setSiguiente(nuevo);
                numElementos++;
            }
        }
    }
    
    /**
     * Imprime la lista en consola
     */
    public void imprimir(){
        if(esVacio()){
            System.out.println("Lista vacia");
        }
        else{
            Nodo apuntador = cabeza;    
            System.out.print("[");
            while(apuntador != null){                
                if(apuntador.getSiguiente() != null){
                    System.out.print(apuntador.getDato() + ", ");
                }
                else{
                    System.out.print(apuntador.getDato() + "]");
                }
                apuntador = apuntador.getSiguiente();
            }
            System.out.println("");
        }
    }
    
    /**
     * Elimina el elemento que se encuentra al final de la lista
     */
    public void eliminarFinal(){
        if(esVacio()){
            System.out.println("Lista vacia");
        }
        else{
            Nodo apuntador = cabeza;
            while(apuntador.getSiguiente().getSiguiente() != null){
                apuntador = apuntador.getSiguiente();
            }
            apuntador.setSiguiente(null);
            cola = apuntador;
            numElementos--;
        }
    }
    
    /**
     * Elimina el elemento que se encuentra al inicio de la lista
     */
    public void eliminarInicio(){
        if(esVacio()){
            System.out.println("Lista vacia");
        }
        else{
            cabeza = cabeza.getSiguiente();
            numElementos--;
        }
    }
    
    /**
     * Elimina un elemento de la lista dado un indice
     * @param indice 
     */
    public void eliminar(int indice){
        if(esVacio()){
            System.out.println("Lista vacia");
        }
        else{
            if(indice < 0 || indice >= numElementos){
                System.out.println("Indice fuera de rango");
            }
            else{
                if(indice == 0){
                    eliminarInicio();
                }
                else if(indice == getUltimoIndice()){
                    eliminarFinal();
                }
                else{
                    Nodo apuntador = cabeza;
                    
                    for (int i = 0; i < indice-1; i++) {
                        apuntador = apuntador.getSiguiente();
                    }
                    
                    apuntador.setSiguiente(apuntador.getSiguiente().getSiguiente());
                    numElementos--;
                }
            }
        }
    }
    
    /**
     * Obtiene un elemento de la lista dado un indice
     * @param indice
     * @return El elemento en el índice especificado, o null si la lista está vacía o el índice está fuera de rango
     */
    public T obtener(int indice){
        if(esVacio()){
            System.out.println("Lista vacia");
        }
        else{
            if(indice < 0 || indice >= getNumElementos()){
                System.out.println("Indice fuera de rango");
            }
            else{
                if(indice == 0){
                    return (T) cabeza.getDato();
                }
                else if(indice == getUltimoIndice()){
                    return (T) cola.getDato();
                }
                else{
                    Nodo apuntador = cabeza;
                    for (int i = 0; i < indice; i++) {
                        apuntador = apuntador.getSiguiente();
                    }
                    return (T) apuntador.getDato();
                }
            }
        }
        return null;
    }
    
    /**
     * Retorna true si el elemento esta en la lista
     * Retorna false si el elemento no esta en la lista
     * @param dato
     * @return true si el elemento está presente en la lista, false de lo contrario
     */
    public boolean contiene(T dato){
        if(!esVacio()){
            Nodo apuntador = cabeza;
            while(apuntador != null){
                if(apuntador.getDato().equals(dato)){
                    return true;
                }
                apuntador = apuntador.getSiguiente();
            }            
        }
        return false;
    }
    
    
    /**
     * Reemplaza un elemento de la lista dado un indice
     * @param dato
     * @param indice 
     */
    public void reemplazar(T dato, int indice){
        if(esVacio()){
            System.out.println("Lista vacia");
        }
        else{
            if(indice < 0 || indice >= getNumElementos()){
                System.out.println("Indice fuera de rango");
            }
            else{
                if(indice == 0){
                    cabeza.setDato(dato);
                }
                else if(indice == getUltimoIndice()){
                    cola.setDato(dato);
                }
                else{
                    Nodo apuntador = cabeza;
                    for (int i = 0; i < indice; i++) {
                        apuntador = apuntador.getSiguiente();
                    }
                    apuntador.setDato(dato);
                }
            }
        }        
    }
    
    
    
    
    
    
    
    
            
    
}
