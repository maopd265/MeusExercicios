/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabjacob;

/**
 *
 * @author Mauricio
 */
public class threadJacob extends Thread{
    double[][] matriz;
    double[] b;
    double e;
    int numIter;
       
    public threadJacob(double[][] matriz, double[] b, double e, int numIter) {
        this.matriz = matriz;
        this.b = b;
        this.e = e;
        this.numIter = numIter;
        start();
    }
    
    public static double[] jacobi(double[][] matriz, double[] b, double e, int numIter) {
	
	double[] x0 = new double[matriz.length];    //vetor dos resultados anteriores
	double[] x = x0.clone();                    //vetor dos resultados atuais
	double erro = 100, soma;
	int k = 0;      //A quantidade de iterações feitas

    //Zera o vetor x0
	for (int i = 0; i < x0.length; i++) {
		x0[i] = 0;
	}

	while (erro >= e && k <= numIter) {
		for (int i = 0; i < matriz.length; i++) {
			soma = 0;
			for (int j = 0; j < matriz[0].length; j++) {
				if (i != j) {
					soma += (matriz[i][j] * x0[j]) / matriz[i][i];
				}
				x[i] = (b[i] / matriz[i][i]) - soma;
			}
		}
		erro = calcErro(x, x0);
		x0 = x.clone();
		k++;
	}
	
	return x;
	
}
	


//Faz o cálculo do erro
private static double calcErro(double[] a, double[] b) {
	double result[] = new double[a.length];
	for (int i = 0; i < a.length; i++) {
		result[i] = Math.abs(a[i] - b[i]);
	}
	int cont = 0;            //um contador
	double maior = 0;       //o maior número contido no vetor
	while (cont < a.length) {
		maior = Math.max(maior, result[cont]);
		cont++;
	}
	return maior;
}
    
    public void run()
    {
        double[] x ;
        x=jacobi(matriz,b,e,numIter);
        for(double valor :x)
        {
            System.out.println("x = "+valor);
        } 
    }
    
    
}
