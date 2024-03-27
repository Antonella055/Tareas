/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Antonella
 */
public class ArbolAVL {
    private NodoArbolAVL raiz;

    public ArbolAVL() {
        raiz=null;
    }

    public NodoArbolAVL getRaiz() {
        return raiz;
    }
    
    public NodoArbolAVL buscar(int d,NodoArbolAVL r){
        if (raiz==null) {
            return null;
        }else if(r.dato==d){
            return r;
        }else if(r.dato<d){
            return buscar(d,r.hijoDerecho);
        }else{
            return buscar (d,r.hijoIzquierdo);
        }
    }
    
    /**
     * Obtener el factor de equilibrio 
     * @param x
     * @return 
     */
    public int obtenerFE(NodoArbolAVL x){
        if (x==null) {
            return -1;
        }else
            return x.fe;
    }
    
    /**
     * Rotacion simple izquierda
     * @param c
     * @return 
     */
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
         NodoArbolAVL aux =c.hijoIzquierdo;
        c.hijoIzquierdo= aux.hijoDerecho;
        aux.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        return aux;
    }
    
    /**
     * Rotacion simple derecha
     * @param c
     * @return 
     */
    public NodoArbolAVL rotacionDerecha (NodoArbolAVL c){
        NodoArbolAVL aux=c.hijoDerecho;
        c.hijoDerecho=aux.hijoDerecho;
        aux.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        return aux;  
    }
    
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
        NodoArbolAVL temp;
        c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
        temp= rotacionIzquierda(c);
        return temp;
    }
    
     public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
        NodoArbolAVL temp;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temp=rotacionDerecha(c);
        return temp;
    }
     
     public NodoArbolAVL insertar(NodoArbolAVL nuevo,NodoArbolAVL subAr){
         NodoArbolAVL nuevoPadre= subAr;
         
         if (nuevo.dato < subAr.dato) {
             if(subAr.hijoIzquierdo==null){
                 subAr.hijoIzquierdo=nuevo;
             }else{
                 subAr.hijoIzquierdo= insertar(nuevo,subAr.hijoIzquierdo);
                 
                 if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)) ==2){
                     if(nuevo.dato < subAr.hijoIzquierdo.dato){
                         nuevoPadre= rotacionIzquierda(subAr);
                     }else{
                         nuevoPadre= rotacionDobleIzquierda(subAr);
                     }
                 }
             }
         }else if (nuevo.dato > subAr.dato){
             if(subAr.hijoDerecho==null){
                 subAr.hijoDerecho=nuevo;
             }else {
            subAr.hijoDerecho = insertar(nuevo, subAr.hijoDerecho);
            if ((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo)) == 2) {
                if (nuevo.dato > subAr.hijoDerecho.dato) {
                    nuevoPadre = rotacionDerecha(subAr);
                } else {
                    nuevoPadre = rotacionDobleDerecha(subAr);
                }
                    }
                }
         } else {
                System.out.println("Nodo Duplicado");
            }
    
        // Actualizando la altura
        if ((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)) {
            subAr.fe = subAr.hijoDerecho.fe + 1;
        } else if ((subAr.hijoDerecho == null) && (subAr.hijoIzquierdo != null)) {
            subAr.fe = subAr.hijoIzquierdo.fe + 1;
        } else {
            subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) + 1;
        }

        return nuevoPadre;
    }
     
     public void agregar(int d){
         NodoArbolAVL nuevo= new NodoArbolAVL(d);
         if(raiz==null){
             raiz=nuevo;
         }else{
             raiz= insertar(nuevo,raiz );
         }
     }
     
     //Recorridos
     
     //Inorden
    public void inOrden(NodoArbolAVL r){
        if(r!=null){
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato + ".");
            inOrden(r.hijoDerecho);
    }
    }
        
    public void preOrden(NodoArbolAVL r){
        if(r!=null){
        System.out.print(r.dato + ",");
        preOrden(r.hijoIzquierdo);
        preOrden(r.hijoDerecho);
        }
        }
    
    //Postorden
    public void postOrden(NodoArbolAVL r){
    if(r!=null){
    postOrden(r.hijoIzquierdo);
    postOrden(r.hijoDerecho);
    System.out.print(r.dato + ",");
         }
      }
    
}