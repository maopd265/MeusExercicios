import java.util.*;


public class Main {
    public static void escreveFila(ArrayDeque fila){
        for (Object object : fila) {
            System.out.println(" Valor: "+object);
        }
    }
    public static void main(String[] args) {
        ArrayDeque fila = new ArrayDeque();
        System.out.println("Algoritmo de FILA");
        fila.add(10);
        fila.add(100);
        fila.add(210);
        fila.add(30);
        fila.add(40);
        escreveFila(fila);
        fila.remove();
        System.out.println("-----Fila pos remocao-----");
        escreveFila(fila);
    }
}
