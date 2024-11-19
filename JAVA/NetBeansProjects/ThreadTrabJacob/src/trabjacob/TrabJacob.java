/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabjacob;

/**
 *
 * @author Mauricio
 */
public class TrabJacob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] matriz= {
			      { 1, 2, 3 },
			      { 5, 6, 7 },
                              { 2, 8, 9 }
		       };
        double[] b ={1,2,3};
        double e=2; 
        int numIter=10;
        double[][] matriz2= {
			      { 2, 2, 3 },
			      { 3, 6, 7 },
                              { 5, 4, 9 }
		       };
        double[] b2 ={4,3,3};
        double e2=2; 
        int numIter2=10;
        
        threadJacob tj = new threadJacob(matriz,b,e,numIter);
        threadJacob tj2 = new threadJacob(matriz2,b2,e2,numIter2);
    }
    
}
