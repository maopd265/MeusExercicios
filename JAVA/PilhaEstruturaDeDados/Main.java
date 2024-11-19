import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        ArrayList array = new ArrayList();
        pilha.push(10);
        array.add(pilha.peek());
        pilha.push(20);
        array.add(pilha.peek());
        pilha.push(30);
        array.add(pilha.peek());
        
        System.out.println("\n\n--Valores armazenados no Array referentes a pilha original--");
        for (Object object : pilha ) {
            System.out.println("Valor pilha 1:"+object);
        }
        // pilha2.push(pilha.peek());
        // pilha.pop();
        // pilha2.push(pilha.peek());
        // pilha.pop();
        // pilha2.push(pilha.peek());
        // pilha.isEmpty();
        while(!pilha.isEmpty()){
            pilha2.push(pilha.peek());
            array.add(pilha2.peek());
            pilha.pop();

        }

        System.out.println("\n--Valores armazenados no Array--");
        for (Object object : array) {
            System.out.println("Valor :"+object);
        }
        
        System.out.println("\n--Valores armazenados no Array referentes a pilha inversa--");
        for (Object object : pilha2 ) {
            System.out.println("Valor pilha 2:"+object);
        }

    }
    
}