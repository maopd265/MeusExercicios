import java.util.ArrayList;

import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        ArrayList<String> array = new ArrayList<>();
        ArrayList<Double> arrayDouble =new ArrayList<>();
        arrayDouble.add(1.54);
        arrayDouble.add(5.457);
        arrayDouble.add(3.4879);
        System.out.println(arrayDouble);
        array.add("Brasil");
        array.add("Abacaxi");
        System.out.println(array);
        // array.sort(null);
        Collections.sort(array);
        Collections.sort(arrayDouble);
        for(String string: array)
        {
            
            System.out.println(string);
        }
        for (Double double1 : arrayDouble) 
        {
         System.out.println(double1);   
        }
    }
}
